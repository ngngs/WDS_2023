package study.my.java.whiteship.effective_java.chapter01.item01.lecture08;

public interface HelloService {

    String test = "인터페이스의 field"; // 인터페이스 field도 가질 수 있네..?

    // 자바 8 이전에는 인터페이스에서 '메서드의 선언'만 가능하고, '메서드의 구현'은 불가능했다.
    String hello();

    // 자바 8부터는 '구현'도 가능해졌다.
    // 2가지 (default / static)

    // 차이는 다음과 같다.
    // 1. default 메서드 - ★즉, 인스턴스만 호출할 수 있는 인스턴스 메서드를 만들 거냐 (★아니 근데 인스턴스는 인스턴스 메서드만 쓸수 있네?? 정적 메서드도 쓸 수 있을 줄 알았는데 아니구나...★ 정적 메서드는 인스턴스가 못 쓴다는 걸 알고 있었는데)
    default String hi(){
        return "hi";
    }

    // 2. static 메서드 - ★인스턴스를 만들지 않아도 호출할 수 있는 정적 메서드를 만들 거냐의 차이
    static String hihi(){
        return "hihi";
    }
}
