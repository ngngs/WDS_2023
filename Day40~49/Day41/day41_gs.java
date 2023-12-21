import class1.Student;

public class day41_gs {
    public static void main(String[] args) {
        Student student1;
        // new : Student 클래스를 기반으로 새로운 객체를 생성하라(메모리에 실제 생성)
        // 설계도를 보니 String name, int age, int grade 만큼의 메모리 공간을 확보한다
        // 그래서 객체에 쓸 데 없는거 많이 넣으면 메모리 낭비군
        // 생성된 객체의 직접 주소가 아닌 참조값을 반환한다
        student1 = new Student();

        // 주소참조값 출력하기
        System.out.println(student1);
        // student1 = x2f4d3709 (이런식으로 주소참조값을 반환하고 있는거임!)

        student1.name = "학생1";
        student1.age = 15;
        student1.grade = 90;

        Student student2 = new Student();
        student2.name = "학생2";
        student2.age = 16;
        student2.grade = 80;

        System.out.println("이름 : " + student1.name + " 나이 : " + student1.age + " 성적 :" + student1.grade);
        System.out.println("이름 : " + student2.name + " 나이 : " + student2.age + " 성적 :" + student2.grade);
    
        // int는 정수타입, String은 문자타입, 학생(Student)이라는 타입을 만들면 되지 않을까?
        // 이 설계도가 바로 `클래스`다. 클래스를 사용해 실제 메모리에 만들어진 클래스를 `객체` 또는 `인스턴스`라고 한다
    
        // 정리 : 클래스(설계도), 이 클래스를 실제 메모리에 올리는 걸 `객체` 또는 `인스턴스`라고 함
        // 클래스는 붕어빵 틀, 실제로 나오는 건 붕어빵(객체)
    }
}
