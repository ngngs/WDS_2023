package my.java.백기선.이펙티브자바.아이템1_생성자대신정적팩터리메서드를고려하라.정적팩터리메서드의장점2;

public class Main {
    public static void main(String[] args) {
//        Settings settings1 = new Settings();
        Settings settings2 = Settings.newInstance();
        Settings settings3 = Settings.newInstance();

        // 주소 값이 서로 같다.
        System.out.println("settings2 = " + settings2);
        System.out.println("settings3 = " + settings3);

        // Boolean.valueOf
        // 정적 팩토리 메서드를 사용한 흔한 예시로 Boolean 클래스의 valueOf라는 메서드가 있다.
        Boolean.valueOf(true);

        // 아래 이미지 꼭 캡쳐!!!!!!!!!!
//        @HotSpotIntrinsicCandidate
//        public static Boolean valueOf(boolean b) {
//            return (b ? TRUE : FALSE);
//        }

//        public static final Boolean TRUE = new Boolean(true);
//
//        /**
//         * The {@code Boolean} object corresponding to the primitive
//         * value {@code false}.
//         */
//        public static final Boolean FALSE = new Boolean(false);
    }
}
