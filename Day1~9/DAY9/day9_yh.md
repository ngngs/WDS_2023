# 클린코드 9일차

## 7장 오류 처리

(1) try-catch-finally 문부터 작성하라

(2) unchecked 예외를 사용하라

과거에는 checked 예외(=컴파일러가 체크하는 예외)가 멋진 아이디어라고 여겨졌다. <br/>
그러나 checked 예외는 OCP(open Closed Principle)를 위반하기 때문에 unchecked 예외를 사용하도록 하자.

OCP 위반 예시
https://cleancodes.tistory.com/5


checked 예외가 캡슐화를 깨버리는 현상
- 만약 ccc() 메서드에서 checked Exception을 throws 하게 된다면 이를 사용하는 메서드에도 연쇄적으로 throws 하게 되는 결과를 낳는다.
  
- 즉, <u>예외는 ccc() 내부 로직때문에 발생하는 건데 이와 전혀 상관없는 aaa(), bbb()에서도 해당 예외를 사용하게 됨으로써 캡슐화가 깨지게 되는 것이다.</u>

```java
public class Example{
    public void aaa(){
        bbb();
    }
    
    public void bbb(){ 
        ccc();
    }
    
    public void ccc() throws Exception{ // 에잉 쯧
        
    }
}
```

(3) 예외에 의미를 제공하라

오류 메시지에 정보를 담아 예외와 함께 던지자. <br/>
실패한 연산 이름과 실패 유형도 언급하자.

(4) 호출자를 고려해 예외 클래스를 정의하라

(5) 정상 흐름을 정의하라

(6) null을 리턴하지 마라

오류 처리를 논하느 ㄴ장이라면 우리가 흔히 저지르는 바람에 오류를 유발하는 행위도 언급해야 한다고 생각한다.

그중 첫째가 null을 리턴하는 습관이다.

메서드에서 null을 리턴하고픈 유혹이 든다면 그 대신 예외를 던지거나 특수 사례 객체(Special Case Pattern)를 리턴한다.

많은 경우 특수 사례 객체가 손쉬운 해결책이다.

다음과 같은 코드를 생각해보자.

(7) null을 전달하지 마라 

null을 리턴하는 것도 나쁘지만 null을 전달하는 건 더 나쁘다.

단순히 NullPointerException이 문제가 아니라 이 예외를 처리하는 로직이 추가적으로 필요하게 된다는 점이 문제다.

또 다른 대안은 assert문을 이용하는 방법이 있다.

```java
assert
```