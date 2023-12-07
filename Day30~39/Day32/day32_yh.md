# 클린코드 32일차

## 17장 냄새와 휴리스틱 (3)

### 자바

#### J1 : 긴 import 목록을 피하고 와일드카드를 사용하라

`import java.util.*;`

개인적인 생각이지만 요즘은 이클립스나 인텔리제이 같은 IDE가 import 영역을 자동으로 가려주고, 필요할 때만 확장해볼 수 있어서 굳이..라는 생각이 들긴 한다.


#### J2 : 상수는 상속하지 않는다

**상속을 이렇게 사용하면 안 된다.** 상수를 상속받아 사용하면 해당 상수가 어느 클래스에서 왔는지 알기 어렵다. 참으로 끔찍한 관행이다.

#### J3 : 상수 대 Enum

자바 5부터는 enum을 제공한다. 

**이제 더이상 `public static final`이라는 옛날 기교를 부릴 필요가 없다!**
```java
public static final int JANUARY = 1; // no more SF(static final) plz..
public static final int FEBRUARY = 2;
```

적극적으로 enum을 사용하라. **일반 class처럼 필드/생성자/메서드를 가질 수 있기 때문에 아래 예시처럼 다양한 표현이 가능하다.**

```java
public enum MONTH{
    // Enum 인스턴스
    JANUARY(1, "1월"),  // JANUARY라는 객체
    FEBRUARY(2, "2월"); // FEBRUARY라는 객체
    
    // Enum 필드
    private int number;
    private String korName; 

    // Enum 생성자
    MONTH(int number, String korName) {
        this.number = number;
        this.korName = korName;
    }
}
```

### 테스트

#### T2 : 커버리지 도구를 사용하라!
커버리지 도구는 테스트가 빠뜨리는 공백을 알려준다. 커버리지 도구를 사용하면 테스트가 불충분한 모듈, 클래스, 함수를 찾기가 쉬워진다. 

대다수 IDE는 테스트 커버리지를 시각적으로 표현한다. (ex. 테스트되는 행은 초록색, 되지 않는 행은 붉은색)