package study.my.java.whiteship.effective_java.chapter01.item01.lecture09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        HelloService helloService = applicationContext.getBean(HelloService.class);

        // 위처럼 applicationContext에서 getBean, 즉 Bean을 얻는 이러한 메서드
        // 이런 걸 서비스 '접근' API라고 한다.
        // 더 쉽게는 @Autowired를 이용하여 Bean을 주입(=접근) 받는 방법도 있다.

        System.out.println(helloService.hello());
    }
}
