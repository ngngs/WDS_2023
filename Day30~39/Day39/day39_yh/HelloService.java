package my.java.백기선.이펙티브자바.아이템1_생성자대신정적팩터리메서드를고려하라.정적팩터리메서드의장점345;

public interface HelloService {
    String hello();

    // 책 p.10 설명
    // 자바 8 이전에는 인터페이스에 static 메서드를 선언할 수 없었기에 HelloServiceFactory 같은 곳에 이러한 정적 팩토리 메서드를 구현했지만
    // 이제는 인터페이스에 '정적 팩토리 메서드'를 둘 수 있다!!
    public static HelloService of(String lang){ // cf. 인터페이스에선 '접근지시자'가 따로 없으면 public으로 간주한다.
        if(lang.equals("ko")){                  //     클래스에서 default(= package-private)로 간주하는 것과 조금 다르다.
            return new KoreanHelloService();
        }else{
            return new EnglishHelloService();
        }
    }
}
