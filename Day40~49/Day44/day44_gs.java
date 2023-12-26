package class1;

public class ClassStart5 {
    public static void main(String[] args) {
        Student student1;
        student1 = new Student();

        student1.name = "학생1";
        student1.age = 15;
        student1.grade = 90;

        Student student2 = new Student();
        student2.name = "학생2";
        student2.age = 16;
        student2.grade = 80;
        
        // 리팩토링을 해보자
        Student[] students = {student1, student2};

        for (int i = 0; i < students.length; i++){
            System.out.println("이름 : " + students[i].name + " 나이 : " + students[i].age + " 성적 :" + students[i].grade);
        }

        // for 문을 최적화 하자 (enhanced for)
        // iter을 누르면 향상된 for문 자동 완성
        for (Student student : students) {
            System.out.println("이름 : " + student.name + " 나이 : " + student.age + " 성적 :" + student.grade);
        }

    }
}
