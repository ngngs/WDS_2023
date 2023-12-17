package my.java.백기선.이펙티브자바.아이템1_생성자대신정적팩터리메서드를고려하라.정적팩터리메서드의장점345;

public class KoreanHelloService implements HelloService {
    @Override
    public String hello() {
        return "안녕하세요";
    }
}
