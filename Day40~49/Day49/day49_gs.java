import class1.ref.InitData;

public class day49_gs {
    String name; // 멤버변수
    public static void main(String[] args) {
        // 변수와 초기화
        // 멤버변수(필드) : 클래스에 선언
        // 지역변수 : 메서드에 선언, 매개변수도 지역 변수의 한 종류
        String inName; // 지역변수(클래스 안에 선언)

        // 클래스가 끝나면 지역 변수는 제거된다
        
        // 멤버변수 : 자동초기화(숫자 = 0, boolean = false, 참조형 = null)
        // 지역변수 : 수동초기화(지역변수는 항상 직접 초기화해야 함)
        InitData data = new InitData();
        System.out.println("value1 = " + data.value1); // 0
        System.out.println("value2 = " + data.value2); // 10
    }
}
