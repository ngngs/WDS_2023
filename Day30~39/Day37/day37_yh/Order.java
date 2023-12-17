package my.java.백기선.이펙티브자바.아이템1_생성자대신정적팩터리메서드를고려하라.정적팩터리메서드의장점1;

public class Order {

    private boolean prime;

    private boolean urgent;

    private Product product;

    // Java 기본 상식
    // - 생성자를 따로 만들지 않아도 컴파일러가 자동으로 default 생성자를 만들어준다.
    // - 다만, 아래처럼 내가 직접 파라미터가 0개가 아닌 생성자를 선언한다면 컴파일러가 자동으로 default 생성자를 만들지 X
//    public Order(){
//
//    }

    // (1)prime order와 (2)urgent order에 대한 각각의 생성자를 만들고 싶었으나
    // Order 생성자의 경우 메서드 시그니처가 같아서 컴파일 에러가 나고 있는 상태!!
//    public Order(Product product, boolean prime){
//        this.product = product;
//        this.prime = prime;
//    }
//
//    public Order(Product product, boolean urgent){
//        this.product = product;
//        this.urgent = urgent;
//    }

    // 장점 1. 이름을 가질 수 있다.
    // 정적 팩토리 메서드를 이용한다면 (1)prime order와 (2)urgent order에 대한 각각의 생성자를 만들 수 있다!
    public static Order primeOrder(Product product){
        Order order = new Order(); // 이 메서드가 실행될 때, 생성자를 통해 생성을 한 다음
        
        order.prime = true; // prime 오더이므로 true
        order.product = product; // 파라미터로 받은 product를 설정
        
        return order; // 설정 및 생성을 끝낸 Order 인스턴스를 리턴
    }

    public static Order urgentOrder(Product product){
        Order order = new Order();

        order.urgent = true; // urgent 오더이므로
        order.product = product; // 파라미터로 받은 product를 설정

        return order;
    }
}
