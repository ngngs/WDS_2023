package study.my.java.whiteship.effective_java.chapter01.item02.lecture03;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println("now = " + now);

        boolean before = now.isBefore(LocalDate.of(2023, 1, 1));
        System.out.println("before = " + before);

    }
}
