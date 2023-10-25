# 클린코드 2일차

## 2장 의미 있는 이름

개요

- 변수명, 함수명, 클래스명, 파일명 등 **이름을 잘 지으면 여러모로 편하다**
- 이름을 잘 짓는 몇 가지 규칙을 소개한다

## 이름을 잘 짓는 몇 가지 규칙

(1) 의도를 분명히 밝혀라

d는 아무런 의미도 없다

```java
int d; // 경과 시간 (단위: 날짜)
```

위처럼 주석으로 설명을 덧붙이는 것보단 아래처럼 이름이 길더라도 의미를 한눈에 알 수 있는 게 훨씬 좋다

```java
int elapsedTimeInDays;
int daySinceCreation;
int daysSinceModification;
int fileAgeInDays;
```

(2) 그릇된 정보를 피하라

예를 들어, 그룹/묶음에 대한 표현을 할 때 실제로 List 자료 구조에 담긴 것이 아니라면 List라는 표현을 쓰지 말 것.

```java
// 실제로 List에 담긴 게 아니라면 안 좋은 이름이다
accountList (X)

// 대안
accountGroup (O)
bunchOfAccounts (O)
Accounts (O)
```

(3) 검색하기 쉬운 이름을 사용

숫자나 짧은 단어는 검색(Ctrl + H)하면 검색 결과가 너무 많이 나오게 된다. 단, for문에 쓰이는 i, j, k 정도는 괜찮다.

```java
MAX_CLASSES_PER_STUDENT (O)
WORK_DAYS_PER_WEEK (O)

e (X) // 짧은 단어
7 (X) // 단순한 숫자
```

- 실제 코드 예시
  - **4, 5처럼 흔히 상수로 쓸 법한 것도 따로 변수명을 부여**하는 것이 좋다는 게 포인트!
  - 검색도 쉬워지고, **처음 코드를 보는 사람도 해당 숫자의 의미도 확실히 이해할 수 있다.**

```java
// 변경 전
for(int j=0; j<34; j++){
    s += (t[j] * 4) / 5;
}

// 변경 후
// t -> taskEstimate
// 4 -> realDaysPerIdealDay
// 5 -> realDaysPerIdealDay
// s -> sum
int realDaysPerIdealDay = 4;
const int WORK_DAYS_PER_WEEK = 5;
int sum = 0;
for(int j=0; j < NUMBER_OF_TASKS; j++){
    int realTaskDays = taskEstimate[j] * realDaysPerIdealDay;
    int realTaskWeeks = (realTaskDays / WORK_DAYS_PER_WEEK);
    sum += realTaskWeeks;
}
```

(4) 클래스 이름

클래스 이름과 객체 이름은 **명사나 명사구가 적합 (동사는 사용 X)**

```java
// 좋은 예
Customer
WikiPage
Account
AddressParser

// 피할 단어 (아직 정확한 이유는 모르겠음)
Manager
Processor
Data
Info
```

(5) 메서드 이름

메서드 이름은 **동사나 동사구가 적합**

```java
// 좋은 예
postPayment
deletePage
save

// javabean 표준
getXxx
setXxx
isXxx
```

생성자를 overload할 경우 메서드 이름 짓는 법

- 파라미터를 설명하는 이름을 사용
- 정적 팩토리 메서드를 사용
  - 정적 팩토리 메서드(Static Factory Method)는 왜 사용할까?
  - https://tecoble.techcourse.co.kr/post/2020-05-26-static-factory-method/

```java
//
Complex fulcrumPoint = new Complex(23.0);

// 좋은 예
// FromRealNumber
// (1) 파라미터를 설명하는 이름을 사용
// (2) static method 사용
Complex fulcrumPoint = Complex.FromRealNumber(23.0);
```

(6) 한 개념에 한 단어를 사용

예시

- "얻다" 라는 행위를 하는 메서드의 이름을 지을 때
- fetch / retrieve / get 섞어 쓰면 혼란스럽다.

(7) 의미 있는 맥락을 추가하면 좋다

1. 접두어를 붙이면 맥락이 더 분명해져서 좋다

```java
// 대부분의 단어들은 맥락을 파악하기 어렵다
firstName
lastName
state

// 이때 접두어 "addr"를 붙여주면 의미가 확 산다
addrFirstName
addrLastName
addrState
```

2. 아예 클래스(Address)를 생성하면 더 좋다.

```java
// 이러면 Address 클래스의 field라서 훨씬 더 명확하다
public class Address{
    private String firstName;
    private String lastName;
    private String state;
}
```
