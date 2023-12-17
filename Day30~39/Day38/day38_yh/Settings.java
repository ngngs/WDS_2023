package my.java.백기선.이펙티브자바.아이템1_생성자대신정적팩터리메서드를고려하라.정적팩터리메서드의장점2;

public class Settings {

    private boolean useAutoSteering;

    private boolean useABS;

    private Difficulty difficulty;

    // 장점 2. 호출될 때마다 인스턴스를 새로 생성하지 않아도 된다. (Boolean.valueOf)

    // 생성자를 private으로 하고
    private Settings(){}

    // 생성한 인스턴스 1개를 static final
    private static final Settings SETTINGS = new Settings();

    // 결과적으로 newInstance라는 이름의 '정적 팩토리 메서드'를 통해서만 Settings 클래스의 인스턴스를 얻을 수 있는 것.
    // (심지어 지금은 싱글톤)
    public static Settings newInstance(){
        return SETTINGS;
    }

    // Boolean.valueOf - Main 클래스에서 설명
}
