# 클린코드 27일차

## 15장 JUnit 들여다보기 (2)

### 이어서 

#### (2) ComparisonCompactor 리팩토링

코드를 리팩토링 하다 보면 원래 했던 변경을 되돌리는 경우가 흔하다. 
**리팩토링은 코드가 어느 수준에 이를 때까지 수많은 시행착오를 반복하는 작업**이기 때문이다.

1. shouldNotCompacted 조건

```java
public String formatCompactedComparison(String message){
    String compactExpected = expected;
    String compactActual = actual;
    if(shouldBeCompacted()){
        ...
    }
}

// 캡슐화한 조건문 1
private boolean shouldBeCompacted(){
    return !shouldNotBeCompacted();
}

// 캡슐화한 조건문 2
private boolean shouldNotBeCompacted(){
    return expected == null || actual == null || expected.equals(actual);
}
```