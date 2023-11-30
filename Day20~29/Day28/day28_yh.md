# 클린코드 28일차

## 16장 SerialDate 리팩토링 (1)

### 개요

날짜를 표현하는 여러 자바 클래스 중 데이비드가 만든 SerialDate 클래스에 대해 알아보고 클린 코드 과정을 거쳐보자.

### SerialDate 소개
SerialDate는 날짜를 표현하는 자바 클래스 

알다시피 자바는 이미 java.util.Date, java.util.Calendar 등 날짜 클래스를 제공 중

SerialDate를 따로 만든 이유는 (책 p.449 참조)
- 요구사항 1 : 최소한 엑셀에서 제공하는 날짜 기능 제공
- 요구사항 2 : 불변 클래스
- java.util.Date는 1000분의 1초의 정밀도로 시각을 표현할 정도로 너무 정밀한 '시간 기반 Date 클래스'
- 하루 중 시각, 시간대에 무관하게 특정 날짜만 표현하기 위해 만듦. (ex. 2015년 1월 21일)

### 둘째, 고쳐보자

1. 라인선스 정보, 저작권, 작성자, 변경 이력
- 법적인 정보는 필요하므로 라이선스 정보와 저작권 주석 정보는 보존
- 변경 이력 주석은 삭제 (이제는 형상관리 툴 이용)
- Javadoc 주석 안에서 HTML 등 여러 언어가 섞이지 않게 간소화

2. 클래스
- 클래스 이름 변경 : SerialDate &rightarrow; DayDate
  - 추상 클래스인 점을 고려하면 구현체 이름 같은 SerialDate보단 DayDate가 낫다. (Date가 가장 좋으나 이미 java.util.Date가 있으므로..)
- MonthConstants(상수 클래스)를 상속하는 부분
  - 상속을 제거하고, **Month 라는 Enum 클래스를 새로 만들어 이를 사용하는 것으로 변경** 

```java
public static enum Month{
    JANUARY(1),
    FEBRUARY(2),
    MARCH(3),
    APRIL(4),
    MAY(5),
    JUNE(6),
    JULY(7),
    AUGUST(8),
    SEPTEMBER(9),
    OCTOBER(10),
    NOVEMBER(11),
    DECEMBER(12);
}
```

cf. MonthConstants 클래스 방식은 Java에 ENUM 클래스가 생기기 전에 사용하던 전형적인 '상수 클래스' 방식
- **재밌는 건 내가 현재 일하고 있는 회사에서도 이와 같은 방식으로 Constants를 선언하고 사용하고 있다는 것**이다.
- 조금 다른 점은 class가 아니라 interface이고, interface 내부에 inner class를 선언한 다음 그 안에 static final 상수를 선언하여 사용 중.
  - interface명 : 업무 모듈명
  - inner class명 : 상세 업무명

[과거의 상수 클래스 방식과 현재 ENUM 클래스 방식에 대해 더 궁금하다면](https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EC%97%B4%EA%B1%B0%ED%98%95Enum-%ED%83%80%EC%9E%85-%EB%AC%B8%EB%B2%95-%ED%99%9C%EC%9A%A9-%EC%A0%95%EB%A6%AC)