# 클린코드 3일차

## 2장 의미 있는 이름 (2)

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
