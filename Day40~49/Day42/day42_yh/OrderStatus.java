package study.my.java.whiteship.effective_java.chapter01.item01.lecture06;

// OrderStatus : 주문의 상태를 나타내는 상수값들을 정의해보자.
public enum OrderStatus {

    PREPARING(0, "출고중"),
    // ★열거 타입은 인스턴스가 하나만 만들어짐을 보장한다.
    // - 즉, OrderStatus의 PREPARING/SHIPPED/DELIVERING/DELIVERED이란 인스턴스가 JVM 내에서 딱 하나만 만들어짐을 보장한다.
    // - 그래서 싱글톤 패턴을 구현할 때 사용하기도 한다.


    // 질문2) enum은 자바의 클래스처럼 생성자, 메서드, 필드를 가질 수 있는가?
    // ★정말 기초적인 질문이다. 당연히 Enum도 클래스기 때문에 가질 수 있다.
    SHIPPED(1, "출고완료"), DELIVERING(2, "배송중"), DELIVERED(3, "배송완료");
    // Enum 상수는 enum 정의 내부에서 미리 정의된 상수 "객체"들
    // 이러한 상수들은 해당 "enum 타입의 인스턴스"
    // 예를 들어, ★저 객체 이름 그대로가 아니라 따로 값을 갖고 있게 하고 싶다면.. (ex. DB에 넣을 때 SHIPPED라는 이름이 아니라 숫자 20으로 넣고 싶다면)
    // ★아래의 생성자가 필요하다.

    private int number;
    private String name;

    // Enum 생성자
    OrderStatus(int number, String name){ // ★생성자 해석을 해보자 : PREPARING(0) -> 0이라는 숫자를 파라미터로 줬으므로 number라는 필드 값으로 0을 가진 PREPARING "객체"가 생성되는 것!!
        this.number = number;
        this.name = name;
    }

}
