package study.my.java.whiteship.effective_java.chapter01.item01.lecture07;

public class 분리전_Character {

    private char value;

    private String color;

    private String fontFamily;

    private Integer fontSize;

    분리전_Character(char value, String color, String fontFamily, Integer fontSize){
        this.value = value;
        this.color = color;
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
    }
}
