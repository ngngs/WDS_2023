# 클린코드 14일차

## 10장 클래스 (1)

### 개요

이전까지 살펴본 내용은 다음과 같다.
1. 코드 행과 코드 블록의 clean code (5장)
2. 함수의 clean code (3장)

하지만 위 2가지만 신경 쓴다고 하여 clean code가 되는 것은 아니다. <br/>
**클래스**, <u>즉 코드 블록과 함수를 넘어 더 높은 단계인 클래스</u>의 clean code도 굉장히 중요하다.

### 클래스 체계

클래스를 정의하는 표준 자바 관례에 따르면 체계는 다음과 같다.

1. 변수 목록
    1. 정적 공개 상수 (public static)
   2. 정적 비공개 변수 (private static)
   3. 비공개 인스턴스 변수 (private)
2. 함수 목록
    1. 공개 함수
   2. 비공개 함수 (자신을 호출하는 공개 함수 직후에 넣는다)

```java
public class Example{
    public static String 정적_공개_상수;
    
    private static String 정적_비공개_변수;
    
    private String 비공개_인스턴스_변수;
    
    public void 공개_함수(){
        비공개_함수();
    }
    
    private void 비공개_함수(){
        
    }
}
```

### 클래스는 작아야 한다!

클래스도 함수와 마찬가지로 **'작게 만들어야 한다!'** 라는 규칙이 있다.

얼마나 작아야 할까??

**함수는 4~5줄 정도**로 작아야 한다면 <br/>
**클래스는 맡은 책임이 1개일 정도로 작아야 한다!**

#### (1) 책임이 1개라는 의미

단순히 하나의 클래스가 가진 메서드 수가 적으면 괜찮은 걸까?

그렇지 않다. 메서드 수가 적어도 책임이 많을 수 있다.

```java
Version 정보를 얻는 책임, Component를 얻는 책임 등 여러 개의 책임을 지닌 클래스이다.

public class SuperDashboard extends JFrame implements MetaDataUser{
    public Component getlastFocusedComponent()
    public void setLastFocused(Component lastFocused)
    public int getMajorVersionNumber()
    public int getMinorVersionNumber()  
    public int getBuildNumber()
}
```

**클래스 이름은 해당 클래스 책임을 기술해야 한다.** <br/> 
실제로 작명은 클래스 크기를 줄이는 첫 번째 관문이다.  <br/>
예를 들어, <u>클래스 이름에 Processor, Manager, Super 등과 같이 모호한 단어가 있다면 클래스에다 여러 책임을 떠안겼다는 증거</u>다.


#### (2) 단일 책임 원칙 (SRP)

SRP (Single Responsibility Principle)
- [객체는 단 하나의 책임만 가져야 한다.](https://inpa.tistory.com/entry/OOP-%F0%9F%92%A0-%EC%95%84%EC%A3%BC-%EC%89%BD%EA%B2%8C-%EC%9D%B4%ED%95%B4%ED%95%98%EB%8A%94-SRP-%EB%8B%A8%EC%9D%BC-%EC%B1%85%EC%9E%84-%EC%9B%90%EC%B9%99)
- 클래스나 모듈을 변경할 이유가 단 하나뿐이어야 한다는 원칙.

```java
위 SuperDashboard 클래스에서 Version이라는 책임(=클래스명)을 분리 
Version 정보를 얻는 3개의 메서드를 가진 1개의 클래스를 새로 만들었다.

public class Version{
   public int getMajorVersionNumber() 
   public int getMinorVersionNumber()
   public int getBuildNumber()
}
```

#### (3) 응집도 (Cohesion)

클래스는 인스턴스 변수 수가 적어야 한다. <br/>
일반적으로 메서드가 변수를 더 많이 사용할수록 메서드와 클래스는 응집도가 더 높다. <br/>
**응집도는 높은 게 좋은 편이다.** <br/> 
왜냐면 응집도가 높다는 건 클래스에 속한 메서드와 변수가 서로 의존하며 논리적인 단위로 묶인다는 뜻이기 때문이다.

```java
응집도가 높은 클래스
- size()를 제외한 메서드들이 2개 변수를 모두 사용하므로 응집도가 높다고 할 수 있다.

public class Stack{
    private int topOfStack = 0;
    List<Integer> elements = new LinkedList<Integer>();
    
    public int siez(){
        return topOfStack;
    }
    
    public void push(int element){
        topOfStack++;
        elements.add(element);
    }
    
    public int pop() throws PoppedWhenEmpty{
        if(topOfStack == 0)
            throw new PoppedWhenEmpty();
        int element = elements.get(--topOfStack);
        elements.remove(topOfStack);
        return element;
   }
}
```

<u>'함수를 작게, 매개변수 목록을 짧게'라는 전략을 따르다 보면</u> 때때로 **일부 메서드만 사용하는 인스턴스 변수가 아주 많아진다.** <br/> 

즉, 응집도가 낮아지고 있는 것이며, 이는 새로운 클래스로 쪼개야 한다는 신호다!

응집도가 높아지도록 변수와 메서드를 적절히 분리해 새로운 클래스 2~3개로 쪼개주면 좋다.