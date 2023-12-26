package study.my.java.whiteship.effective_java.chapter01.item01.lecture08;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void staticMethod(){
        System.out.println("정적 메서드입니다.");
    }

    public void instanceMethod(){
        System.out.println("인스턴스 메서드입니다.");
    }

    public static void main(String[] args) {
        // cf. 인터페이스가 field를 가질 수 있었구나..?
        String test = HelloService.test;
        System.out.println("test = " + test);

        // ★퀴즈 1
        // 내림차순으로 정렬해주는 Comparator를 선언하고, 숫자 List를 정렬하는 코드를 작성해보라
        Comparator<Integer> comparator = (num1, num2) -> num2 - num1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(10);
        list.add(100);

        list.sort(comparator);

        System.out.println("list = " + list);

        // ★퀴즈 2
        // 아마 퀴즈 1을 구현하셨다면 위 코드와 같을 겁니다.
        // 이제 Comparator를 ★절대 손대지 않고, 오름차순(현재의 역방향)으로 정렬하게끔 바꿔보세요.
        list.sort(comparator.reversed()); // ★★★ 이 reversed()를 생각했다면 공부를 잘했거나, 자바 8 강의를 들었거나 ㅋㅋ
        System.out.println("list = " + list);

        // ★Comparator라는 인터페이스에 reversed()라는 default 메서드가 있다~!
        // 이렇듯 자바 8부터 인터페이스에 default, static 메서드를 정의할 수 있음으로써 API의 기능이 풍부해졌다!!

        Main main = new Main();
        main.instanceMethod();
        Main.staticMethod();
    }
}
