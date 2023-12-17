package my.java.백기선.이펙티브자바.아이템1_생성자대신정적팩터리메서드를고려하라.정적팩터리메서드의장점345;

import java.util.Optional;
import java.util.ServiceLoader;

public class Main {

    public static void main(String[] args) {
        // 1.
        // 마치 Collection의 List나 Set처럼
        // 실제 구현체는 KoreanHelloService(ArrayList)지만, 그 놈의 타입은 HelloService(List)라는 거지.
        HelloService ko = HelloServiceFactory.of("ko");

        
        // 2.
        HelloService eng = HelloService.of("eng"); // 자바 8 이후로 인터페이스의 static method 선언이 가능해졌죠?? 즉, 인터페이스에 정적 팩토리 메서드를 선언하고, 이용한 예시입니다.

        
        // 3. (p.11) 정적 팩토리 메서드를 작성하는 시점에는 반환할 객체의 클래스가 존재하지 않아도 된다.
        // 이런 유연함은 서비스 제공자 프레임워크(service provider framework)를 만드는 근간이 된다.
        // 대표적으로 JDBC가 있다.
        
        // (1) 어떤 구현체가 올지 전혀 모르는 코드 (유연성 up)
        ServiceLoader<HelloService> loader = ServiceLoader.load(HelloService.class); // HelloService를 구현한 구현체를 가져온다. loader에는 그 구현체들이 담기게 된다.
        Optional<HelloService> optionalHelloService = loader.findFirst();
        optionalHelloService.ifPresent(helloService -> {
            System.out.println(helloService.hello());
        });

        // (2) 명확히 ChineseHelloService라는 구현체를 선택한 코드 (유연성 down)
        HelloService helloService = new KoreanHelloService(); // ★실제 예시엔 ChineseHelloService
        System.out.println(helloService.hello());

        // ★★★ (1)과 (2)의 결정적인 차이
        // ★★★ (2)는 이 클래스(Main)가 구현체(ChineseHelloService)에 의존적인 코드이고, (1)은 의존성이 전혀 없다.
        // '의존적'이라는 걸 어떻게 구분하냐면, 바로 import를 보면 된다.
        // (2)의 경우 ChineseHelloService를 import를 하게 된다.
        // 즉, ChineseHelloService라는 구현체를 콕 집어서 hello()를 실행한 것.

    }
}
