package study.my.java.whiteship.effective_java.chapter01.item01.lecture07;

public class 분리후_Character {
    private char value;

    private String color;

    // 1. 자주 변하는 속성과 변하지 않는 속성을 분리
    // 각각의 글자를 의미하는 Character를 볼 때 예를 들어, 값(value)과 색깔(color)은 자주 변하는 속성이라 볼 수 있다.
    // 반면 글꼴(fontFamily), 글자크기(fontSize)는 자주 변하지 않는 값이다.
    // ★따라서 이들을 '분리'하여 Font라는 새로운 class를 생성하였다.
    private Font font;

    분리후_Character(char value, String color, Font font){
        this.value = value;
        this.color = color;
        this.font = font;
    }
}
