import class1.Student;

public class day47_gs {
    public static void main(String[] args) {
        // 자바는 항상 변수의 값을 복사해서 대입

        // 기본형 대입은 실제 사용값이 바로 복사해서 대입됨
        int a = 10;
        int b = a;

        // 참조형 대입은 실제 사용 객체가 아니라 객체의 위치를 가르키는 참조값만 복사된다
        // 쉽게 이야기하면 실제 건물이 복사되는게 아닌 건물 주소가 복사된거임
        Student s1 = new Student();
        Student s2 = s1;


        // 기본형 vs 참조형 3
        // 메서드 호출
        Data dataA = new Data();
        dataA.value = 10;

        System.out.println("메서드 호출 전 :" + dataA.value);

        changeReference(dataA);

        System.out.println("메서드 호출 후 :" + dataA.value);
    }

    static void changeReference(Data data){
        data.value = 20;
    }
}
