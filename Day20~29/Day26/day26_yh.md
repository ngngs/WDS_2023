# 클린코드 26일차

## 15장 JUnit 들여다보기 (1)


### 개요

이 장에서는 JUnit 프레임워크에서 가져온 코드를 평가한다.

### JUnit 프레임워크

JUnit의 시작은 켄트 벡과 에릭 감마, 두 사람이 함께 Atlanta행 비행기를 타고 가다 만든 프레임워크다...! <br/>
(TMI : 비행기에서 3시간 정도만에 JUnit 기초를 구현했다고 한다..;;)

문자열 비교 오류를 파악할 때 유용한 ComparisonCompactor라는 모듈에 대해 평가하고 리팩토링 하는 시간을 가져보겠다.

#### (1) ComparisonCompactor 간단 설명
두 문자열을 받아 차이를 리턴한다. <br/>
예를 들어, ABCDE와 ABXDE를 받으면 &rightarrow; <...B[X]D...> 를 반환한다.

#### (2) ComparisonCompactor 리팩토링

1. 조건문 캡슐화
```java
리팩토링 전

public String compact(String message){
    if(expected == null || actual == null || areStringsEqual())
        return Assert.format(message, expected, actual);
}
```

`expected == null || actual == null || areStringsEqual()` 처럼 길고 긴 조건문을 따로 메서드로 뽑아줌으로써
- (1) 조건문에 이름을 붙일 수 있어 의도 표현이 명확하고
- (2) 조건문 캡슐화의 이점도 가질 수 있다.
```java
리팩토링 후

public String compact(String message){
    if(shouldNotCompact())
        return Assert.format(message, expected, actual);
}

private boolean shouldNotCompact(){
    return expected == null || actual == null || areStringsEqual(); // return 타입은 boolean, 조건문 그대로 return
}
```

