public class day48_gs {
    // 참조형과 메서드 호출 - 활용
    public static void main(String[] args) {
        Student student1 = new Student();
        // student1.name = "학생1";
        // student1.age = 15;
        // student1.grade = 90;
        //
        Student student2 = new Student();
        // student2.name = "학생2";
        // student2.age = 16;
        // student2.grade = 70;

        // System.out.println("이름 : " + student1.name + " 나이 : " + student1.age + " 성적 :" + student1.grade);
        // System.out.println("이름 : " + student2.name + " 나이 : " + student2.age + " 성적 :" + student2.grade);

        // 중복된 작업은 메소드로 해결할 수 있다.(name, age,grade를 계속 넣는 작업)
        initStudent(student1, "학생1", 15, 90);
        initStudent(student2, "학생2", 16, 99);
        printStudent(student1);
        printStudent(student2);

    }
}
