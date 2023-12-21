package study.my.java.whiteship.effective_java.chapter01.item01.lecture07;

public class Client {

    // 3. 그래서 필요할 때마다 그 Factory에서 꺼내다가 쓰는 디자인 패턴
    public static void main(String[] args) {
        // 설명
        // 각 Character를 만드려고 함.
        // (1) 자주 바뀌는 value, color는 저렇게 평범하게 값을 줬지만
        // (2) 자주 바뀌지 않는 Font 부분에 대해서는 FontFactory를 이용하여 Font 객체를 불러옴
        // (3) ★★결과적으로 3개가 모두 같은 Font 객체를 이용하게 되겠죠??
        //        즉, 객체 개수가 줄어든 만큼 메모리 사용량을 확 줄이는 Flyweight(가벼운 체급) 패턴
        // ★이게 바로 Flyweight 패턴!!
        분리후_Character c1 = new 분리후_Character('가', "black", FontFactory.getFont("나눔고딕:12"));
        분리후_Character c2 = new 분리후_Character('나', "red", FontFactory.getFont("나눔고딕:12"));
        분리후_Character c3 = new 분리후_Character('다', "blue", FontFactory.getFont("나눔고딕:12"));

    }
}
