# 클린코드 31일차

## 17장 냄새와 휴리스틱 (2)

### 이어서

### 일반

#### G18 : 부적절한 static 함수

`Math.max(double a, double b)`는 좋은 static 메서드다. 특정 인스턴스와 관련된 기능이 아니기 때문이다. `new Math().max(a,b)`라 하면 오히려 우습다.

그러나 재정의할 가능성이 있다면 static으로 정의하면 안 된다.

일반적으로 static 함수보다 인스턴스 함수가 더 좋다. **반드시 static 함수로 정의해야겠다면 재정의할 가능성은 없는지 꼼꼼히 따져보도록 하자.**

#### G28 : 조건을 캡슐화하라

조건의 의도를 분명히 밝히는 함수로 표현하자. 일반적인 부울 논리는 이해하기 어렵기 때문이다.

즉, `if(timer.hasExpired() && !timer.isRecurrent())`가 아니라 

`if(shouldBeDeleted(timer))`라는 코드가 좋다.

#### G29 : 부정 조건은 피하라
마찬가지로 부정 조건은 이해하기 어려우므로 긍정 조건으로 표현하는 것이 좋다.

```java
긍정 조건
if(buffer.shouldCompact())
```

```java
부정 조건
if(!buffer.shouldNotCompact())
```

#### G30 : 함수는 1가지만 해야 한다.

나도 이론적으로는 함수는 1가지 일만 할 수 있게 하는 것이 좋다고 생각하나, 현실적으로 어려울 때가 많다. **이는 이 책 clean code와 관련된 아래 영상을 보고 느낀 점이다.**

코딩애플 - [코딩 책 한 권만 읽으면 이렇게 됩니다](https://www.youtube.com/watch?v=th7n1rmlO4I)
 
**'함수가 1가지 일만 하게끔'** 코드를 짜다 보면 하나의 함수가 4~5줄 이내로 짧고 이뻐보일 순 있지만, 가독성 측면에서 굉장히 불리하다는 걸 느끼고 있다. 
또한, 코드의 재사용성 측면을 고려한다면 단순히 함수를 여러 개로 늘리는 것보단 '일정 기능을 유지한 함수 1개를 재사용하는 것이 더 좋지 않나' 라는 생각이 들고 있다.


#### G31 : 숨겨진 시간적인 결합
때로는 시간적인 결합이 필요한데, 이때 그걸 명백히 드러내는 것이 좋다.

```java
예를 들어, 단순히 이렇게 짜면 함수 호출 순서가 명확하지 않아 순서를 강제할 수 없다.

public void dive(String reason){
    saturateGradient();
    reticulateSplines();
    diveForMoog(reason);
}
```

```java
따라서 아래처럼 파라미터를 적절히 사용해준다면 순서를 강제해줄 수 있다. 

public void dive(String reason){
    Gradient gradient = saturateGradient();
    List<Spline> splines = reticulateSplines(gradient);
    diveForMoog(splines, reason);
}
```