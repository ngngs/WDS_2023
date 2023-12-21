import class1.Student;

public class day43_gs {
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

        // 배열 사용하기
        // Student 변수를 2개 보관할 수 있는 사이즈 2의 배열
        // 배열에 참조값을 보관
        Student[] students = new Student[2];
        
        // 배열에 참조값 대입
        // 자바에서 `대입`은 항상 변수에 들어있는 값을 복사한다
        // 즉, 아까 봤던 주소참조값이 저장된다
        students[0] = student1;
        students[1] = student2;

        System.out.println("이름 : " + students[0].name + " 나이 : " + students[0].age + " 성적 :" + students[0].grade);
        System.out.println("이름 : " + students[1].name + " 나이 : " + students[1].age + " 성적 :" + students[1].grade);

    }
}
