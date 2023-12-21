package study.my.java.whiteship.effective_java.chapter01.item01.lecture06;

import my.java.백기선.이펙티브자바.아이템1_생성자대신정적팩터리메서드를고려하라.정적팩터리메서드의장점1.Product;

import java.util.Arrays;
import java.util.EnumSet;

public class Order {

    private boolean prime;

    private boolean urgent;

    private Product product;

    // Enum을 썼을 때의 장점은..
    // 이 orderStatus라는 필드가 가질 수 있는 값을 제한할 수, 정할 수 있다는 것이다.
    // 왜?? Enum은 말 그대로 상수들을 열거한 타입이니까
    // 즉, ★특정한 변수가 가질 수 있는 값을 제한할 수 있다. 타입-세이프티(Type-Safety)를 보장할 수 있다.★

    // 왜냐하면 예를 들어, orderStatus라는 변수에 값을 설정할 때 딱 정해진 값(OrderStatus.PREPARING 이라는 인스턴스)만 줄 수 있기 때문이다.
    private OrderStatus orderStatus = OrderStatus.PREPARING;
    private OrderStatus orderStatus2;

    // (1) 반대로 Enum을 안 썼을 땐 그동안 어떻게 표현했을까??
    // 0 - 주문 받음
    // 1 - 준비중
    // 2 - 배송 중
    // 3 - 배송 완료
    // 이렇게 주석으로 표현을 하든가
    private int status;

    // (2) 혹은 상수 필드를 선언해서 사용을 해왔다.
    private final int PREPARING = 0;
    private final int SHIPPED = 1;

    public static void main(String[] args) {
        // 질문1) 특정 enum 타입이 가질 수 있는 모든 값을 순회하며 출력하라.
        // values() 메서드를 알고 있는지 물어보는 질문
        OrderStatus[] values = OrderStatus.values();
        for (OrderStatus os : values) {
            System.out.println("os = " + os);
        }

        // 또다른 방법
        // ★이게 지금 '배열' 형태니까.. '배열을 Stream으로 만들어보자' 이거지!! : Arrays.stream(int[] array)
        Arrays.stream(OrderStatus.values()).forEach(System.out::println);


        // 질문3) enum의 값은 == 연산자로 동일성을 비교할 수 있는가?
        // ★당연히 O. 이는 Enum 상수가 미리 정의된 상수 객체이기 때문에 참조 비교가 가능하기 때문
        // ★★★★★ 또한, equals()보다 == 을 쓰는 것이 매우 바람직하다.
        // 왜냐하면 equals()는 NullPointerException이 발생할 수 있기 때문이다!
        // == 은 true or false 뿐인데 반해서

        // 예를 들어
        Order order = new Order();
        if(order.orderStatus2 == OrderStatus.DELIVERING){
            System.out.println("true = " + true);
        }

//        if(order.orderStatus2.equals(OrderStatus.DELIVERING)){ // NullPointerException 발생
//            System.out.println("true = " + true);
//        }


        // 과제) 왜 Enum을 key로 사용할 때? EnumMap과 EnumSet을 사용하면 좋은지 설명하라. 일반적인 Map, Set말고
        EnumSet enumSet = EnumSet.of(OrderStatus.SHIPPED, OrderStatus.DELIVERING, OrderStatus.DELIVERED);
        System.out.println("enumSet = " + enumSet);
        enumSet.add(""); // ★혹시 이러한 Type-Safety를 기대할 수 있어서 좋은건가???
    }

    public static Order primeOrder(Product product) {
        Order order = new Order();

        order.prime = true;
        order.product = product;

        return order;
    }

    public static Order urgentOrder(Product product){
        Order order = new Order();

        order.urgent = true;
        order.product = product;

        return order;
    }
}
