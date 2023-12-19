public class day40_gs {
    // 김영한의 실전 자바 https://www.inflearn.com/course/lecture?courseSlug=%EA%B9%80%EC%98%81%ED%95%9C%EC%9D%98-%EC%8B%A4%EC%A0%84-%EC%9E%90%EB%B0%94-%EA%B8%B0%EB%B3%B8%ED%8E%B8&unitId=194628&tab=curriculum

    // 자바를 쓰는 이유? 객체 지향 프로그래밍
    // 객체 지향 프로그래밍 -> 대규모 소프트웨어에 적합(코드재사용성 / 모듈화 / 확장성과 유연성 / 추상화를 통한 복잡도 관리 / 유지 보수)
    
    // 프로젝트 환경 구성 : OpenJDK 21
    
    // 클래스는 왜 필요한가?

    //     문제: 학생 정보 출력 프로그램 만들기
    //     당신은 두 명의 학생 정보를 출력하는 프로그램을 작성해야 한다. 각 학생은 이름, 나이, 성적을 가지고 있다.
    //     요구 사항:
    //          1. 첫 번째 학생의 이름은 "학생1", 나이는 15, 성적은 90입니다.
    //          2. 두 번째 학생의 이름은 "학생2", 나이는 16, 성적은 80입니다.
    //          3. 각 학생의 정보를 다음과 같은 형식으로 출력해야 합니다: "이름: [이름] 나이: [나이] 성적: [성적]"
    //          4. 변수를 사용해서 학생 정보를 저장하고 변수를 사용해서 학생 정보를 출력해야 합니다

    public static void main(String[] args) {
        String student1Name = "학생1";
        int student1Age = 15;
        int student1Grade = 90;

        String student2Name = "학생2";
        int student2Age = 16;
        int student2Grade = 70;

        // 줄바꿈 단축키 : ALT + SHIFT + 방향키
        // 줄 복사 : Ctrl + D
        System.out.println("이름 : " + student1Name + " 나이 : " + student1Age + " 성적 : " + student1Grade);
        System.out.println("이름 : " + student2Name + " 나이 : " + student2Age + " 성적 : " + student2Grade);

        // 변수 이름을 통일 시키기 위해 `배열`을 사용하자

    }

    public static void main2(String[] args) {
        // 변수 이름을 통일 시키기 위해 `배열`을 사용하자

        String[] studentNames = {"학생1", "학생2"};
        int[] studentAges = {15, 16};
        int[] studentGrades = {90, 80};

        for (int i = 0; i < studentNames.length; i++){
            System.out.println("이름 : " + studentNames[i] + " 나이 : " + studentAges[i] + " 성적 : " + studentGrades[i]);
        }


        // `배열`의 한계 : 수정 시 정확한 위치에 데이터를 삭제하거나 삽입해야한다.
        // 지금처럼 이름, 나이, 성적을 따로 관리하기 좋은 방식이 아니다
        // 학생 별로 본인의 이름, 나이, 성적을 관리하는 것이 좋은 방식 -> 클래스 도입

    }
}
