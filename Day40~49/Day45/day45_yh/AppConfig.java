package study.my.java.whiteship.effective_java.chapter01.item01.lecture09;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

//    @Bean
//    public HelloService helloService{
//        return new ChineseHelloService();
//    }

    // 설명
    // 현재 @Configuration 애노테이션을 적용한 클래스를 정의하고
    // 그 클래스 안에 @Bean 애노테이션으로 서비스 구현체를 등록한 상태.
    // 이런 게 바로 서비스 제공자 '등록' API라고 볼 수 있는 것. (사실 잘 이해는 되지 않는다.)
    // (아마도.. 말 그대로 ChineseHelloService라는 서비스를 등록하는 API를 뜻하는 게 아닐까?? 그게 바로 @Configuration과 @Bean ??)
}
