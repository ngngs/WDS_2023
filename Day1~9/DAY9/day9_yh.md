# 클린코드 9일차

## 6장 객체와 자료 구조

### 목표
1. 객체와 자료구조의 차이 이해 (왜 사실상 정반대의 개념인지)
2. 각 방식의 장단점 파악 (절차적인 코드와 자료구조 VS 객체 지향 코드와 클래스)

### 본문 내용

(1) 자료 추상화

구현을 감추기 위해선 추상화가 필요하다. <br/>
단순히 getter(조회 함수), setter(설정 함수)로 (private)변수를 다룬다고 해서 class가 되진 않는다. <br/>
추상 인터페이스를 제공하여 사용자가 구현을 모른 채 자료의 핵심을 조작할 수 있어야 진정한 의미의 class다.

구체적인 Point 클래스
```java
public class Point{
    public double x;
    public double y;
}
```

추상적인 Point 클래스
```java
public interface Point{
    double getX();
    double getY();
    void setCartesian(double x, double y);
    
    double getR();
    double getTheta();
    void setPolar(double r, double theta);
}
```


(2) 자료/객체 비대칭

사실상 정반대의 개념
- **자료 구조**는 자료를 공개하지만, 함수는 제공하지 X
- 반면 **객체**는 추상화 뒤로 자료를 숨기고, 그 자료를 다루는 함수만 공개

그로 인한 차이점
- **절차적인 코드**는 <u>기존 자료 구조를 변경하지 않으면서 새 함수를 추가하기 쉽다.</u>
- **객체 지향 코드**는 <u>기존 함수를 변경하지 않으면서 새 클래스를 추가하기 쉽다. </u>

따라서 상황에 맞춰 절차적/객체지향적 코드를 짜는 것이 좋다.

```java
1.자료 구조
- 자료 구조(Square, Rectangle, Circle)는 함수 X, 오직 자료를 공개

public class Square {
    public Point topLeft;
    public double side;
}

public class Rectangle {
    public Point topLeft;
    public double height;
    public double width;
}

public class Circle {
    public Point center;
    public double radius;
}

public class Geometry {
    public final double PI = 3.141592...;

    public double area(Object shape) throws NoSuchShapeException {
        if (shape instanceof Square) {
            Square s = (Square) shape;
            return s.side * s.side;
        } else if (shape instanceof Rectangle) {
            Rectangle r = (Rectangle) shape;
            return r.height * r.width;
        } else if (shape instanceof Circle){
            Circle c = (Circle) shape;
            return PI * c.radius * c.radius;
        }
    }
}
```

```java
2.객체

public class Square implements Shape{
    private Point topLeft;
    private double side;
    
    public double area(){
        return side * side;
    }
}

public class Rectangle implements Shaep{
    private Point topLeft;
    private double height;
    private double width;
    
    public double area(){
        return height * width;
    }
}

public class Circle implements Shape{
    private Point center;
    private double radius;
    public final double PI = 3.141592...;
    
    public double area(){
        return PI * radius * radius;
    }
}
```


(3) 자료 전달 객체 (ex. DTO)

자료 구조체의 전형적인 형태는 공개 변수만 있고 함수가 없는 클래스다.

이런 자료 구조체를 때로는 DTO(자료 전달 객체, Data Transfer Object)라고 한다.

```java
예시

@Getter
public class Address{
    private String street;
    private String streetExtra;
    ...
    
    public Address(String street, String streetExtra){
        this.street = street;
        this.streetExtra = streetExtra;
    }
}
```