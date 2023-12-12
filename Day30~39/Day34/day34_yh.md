# 클린코드 34일차

## 18장 동시성2 (2)

#### (3) 결론

스레드가 서로의 작업을 덮어쓰는 과정을 이해하기 위해 바이트 코드를 속속들이 이해할 필요는 없으나, 어떤 연산이 안전하고 안전하지 못한지 파악할 만큼 메모리 모델을 이해하고 있어야 한다.

특히 (전처리 연산, 후처리 연산 둘 다) ++ 연산은 원자적 연산이라 오해하는 사람이 많은데, 이는 분명 원자적 연산이 아니다. 

즉, 다음을 알아야 동시성에 대한 이해가 가능해지는 것이다.
1. 공유 객체/값이 있는 곳
2. 동시 읽기/수정 문제를 일으킬 소지가 있는 코드
3. 동시성 문제를 방지하는 방법


### 라이브러리를 이해하라
#### (2) 스레드를 차단하지 않는(non blocking) 방법 - Atomic 클래스!

다음은 synchronized 키워드로 다른 스레드를 차단하여 동기화를 수행하는 코드다.
```java
public class ObjectWithValue{
    private int value;
    
    public void synchronized incrementValue(){
        ++value;
    }
    
    public int getValue(){
        return value;
    }
}
```

자바 5는 위와 같은 상황에 적합한 새로운 클래스를 제공한다.
- AtomicBoolean, AtomicInteger, AtomicReference 등의 클래스

```java
public class ObjectWithValue{
    private AtomicInteger value = new AtomicInteger(0); // 초기값 0으로 설정
    
    public void incrementValue(){ // AtomicInteger 클래스로 synchronized 키워드 없이 동시성 문제를 해결
        value.incrementAndGet();  
    }
    
    public int getValue(){
        return value.get();
    }
}
```
<br/>

성능 비교 
- 결과 : AtomicInteger를 쓴 경우가 synchronized를 쓴 경우보다 거의 항상 더 빠르다. <br/>(느린 경우는 사실상 없다)
- (1) synchronized는 언제나 lock을 건다. 둘째 스레드가 같은 값을 갱신하는 경우든 아니든 무조건 락부터 건다. 자바 버전이 올라감에 따라 내장 락의 성능이 좋아지긴 했어도 여전히 락을 거는 대가는 여전히 비싸다.
- (2) 스레드를 차단하지 않는(non blocking) 버전은 **여러 스레드가 같은 값을 수정해 문제를 일으키는 상황이 그리 잦지 않다는 가정에서 출발한다.** 그래서 그런 상황이 발생했는지 효율적으로 감지해 갱신이 성공할 때까지 재차 시도한다.

2번과 같은 연산을 **CAS(Compare And Swap) 연산**이라고 한다. CAS 연산은 논리적으로 아래 코드와 유사하다.
```java
int variableBeingSet;

void simulateNonBlockingSet(int newValue){
    int currentValue;
    do{
        currentValue = variableBeingSet
    } while (currentValue != compareAndSwap(currentValue, newValue))
}

int synchronized compareAndSwap(int currentValue, int newValue){
    if(variableBeingSet == currentValue){
        variableBeingSet = newValue;
        return currentValue;
    }    
    return variableBeingSet;
}
```
해석하자면, <u>메서드가 공유 변수를 갱신하려 든다면 CAS 연산은 현재 변수 값이 최종으로 알려진 값인지 확인</u>한다. 
- (1) 그렇다면 변수 값을 갱신
- (2) 아니라면 다른 스레드가 끼어들었다는 뜻이므로 변수 값을 갱신 X

<br/>

#### (3) 다중 스레드 환경에서 안전하지 않은 클래스
본질적으로 다중 스레드 환경에서 안전하지 않은 클래스가 있다. 예를 들어
- SimpleDateFormat
- 데이터베이스 연결
- java.util 컨테이너 클래스
- Servlet

