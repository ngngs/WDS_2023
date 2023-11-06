# 클린코드 10일차

## 8장 경계

### 개요

우리는 개발할 때 Third party code(ex. 라이브러리, 오픈 소스 등)를 많이 사용하게 된다. <br/>
이 외부 코드(Third party code)를 우리 코드와 잘 통합시키는 게 중요하다. <br/>
이번 챕터에서는 **경계(외부 코드와 우리 코드 사이의)** 를 깔끔하게 처리하는 기법과 기교에 대해 알아보자.

책의 학습 테스트, 아는 코드와 모르는 코드를 분리하는 경계, ADAPTER 패턴 부분은 이해가 잘 가지 않아 더 경험이 쌓인 뒤에 다시 읽어봐야 할 것 같다. <br/>
[[SUMMARY] Clean Code Chapter 8: Boundaries (Robert C. Martin)](https://www.linkedin.com/pulse/summary-clean-code-chapter-8-boundaries-robert-c-martin-el-mhamdi) 

### 본문

#### Map 인터페이스를 통해 알아보는 적절한 외부 코드 사용법

(1) Map과 같은 경계 인터페이스를 사용할 때의 주의해야 하는 이유

Map이 제공하는 기능성과 유연성은 유용하지만 그만큼 위험도 크다. <br/>
예를 들어, 프로그램에서 Map을 만들어 여기저기 넘긴다고 가정하자. <br/>
넘기는 쪽에서는 "아무도 Map 내용물을 삭제하지 않겠지?"라고 안일하게 생각할 수 있다. <br/>
그러나 Map 인터페이스에는 clear()라는 메서드가 있다. 즉, 누구나 Map의 내용물을 지울 수 있다는 것이다.

(2) 예시

1. 부적절한 사용법
- 이는 clean code라고 볼 수 없다.
  왜냐하면 Map이 리턴하는 Object를 Sensor라는 타입으로 Casting할 책임이 이 코드를 사용하는 클라이언트에게 있기 때문이다.
```java
Map sensors = new HashMap();
Sensor s = (Sensors)sensors.get(sensorId);
```

2. Generics를 통한 부분 해결
- 이렇게 Generics를 이용하면 위 문제를 조금 해결할 수는 있다.
- 그러나 Map<String, Sensor> 라는 인스턴스를 이곳 저곳으로 막 넘기다 보면, 나중에 인터페이스가 변경되거나 코드가 변경됐을 때 수정할 양이 상당히 많아진다.
```java
Map<String, Sensor> sensors = new HashMap<Sensor>();
        ...
Sensor s = sensors.get(sensorId);
```

3. More Clean Code
- **'경계 인터페이스'인 Map을 Sensors 안으로 숨긴 형태**이다.
- <u>Map의 객체 타입 관리를 Sensors 클래스 안에서 관리</u>하면 클라이언트가 코드를 이해하기도 쉽고, 오용할 일도 적다.
- 이처럼 항상 캡슐화하라는 의미는 아니다. 다만 Map과 같은 '경계' 인터페이스를 사용할 땐 항상 '경계'하며 쓰도록 하자.
```java
public class Sensors{
    private Map sensors = new HashMap();
    
    public Sensors getById(String id){
        return (Sensor)sensors.get(id);
    }
}
```
