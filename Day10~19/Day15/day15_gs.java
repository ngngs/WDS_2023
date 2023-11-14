public class day15_gs {
    public static void main(String[] args) {
        // 14 데이터베이스
        // 비정규화 vs 정규화 데이터베이스
        /*
         * 정규화 : 중복을 최소화하도록 설계된 데이터베이스
         * 비정규화 : 데이터베이스를 읽는 시간을 최적화하도록 설계된 데이터베이스
         */

         // 문제1. 학생등록, 모든 학생의 목록을 뽑고 각 학생이 얼마나 많은 강의를 수강하고 있는 지 확인하는 질의문을 작성하라
         SELECT max(StudentName) as [StudentName], Students.StudentID, count(StudentCourses.CourseID) as [Count]
         FROM Students LEFT JOIN StudentCourses
         ON Students.StudentID = StudentCourses.StudentID
         GROUP BY Students.StudentID

         // 소규모 데이터베이스 설계
         // 1단계 모호성 처리 : 아파트 임대 대행 업체가 사용할 시스템을 설계한다고 가정하자. 이 업체의 대리점이 몇 개인지 정의해야한다.
         // 2단계 핵심 객체 정의 : 이 시스템의 핵심 객체(CORE OBJECT)가 무엇인지 살펴봐야한다. 보통 핵심 객체 하나당 하나의 테이블을 사용한다
         // 3단계 관계분석 : 테이블끼리 어떤 관계가 있는가. 다대다? 일대다?
         // 4단계 행위조사 : 흔하게 수행되는 작업을 살펴본다. 

         // 대규모 데이터 베이스 설계
         // 대규모 데이터베이스는 반드시 JOIN에서 많은 시간이 걸린다는 것을 가정해야한다. 필요시 역정규화를 고려해야한다.


         // 15 스레드와 락
         // 자바의 스레드
         /*
          * 자바의 모든 스레드는 java.lang.Thread 클래스 객체에 의해 생성된다
          * main() 메소드를 실행하는 하나의 사용자 스레드(user thread)가 자동으로 만들어진다. 이 스레드를 주 스레드(main thread)라고 부른다

          * 자바에서 스레드를 구현하는 방법은 2가지다.
                (java.lang.Runnable 인터페이스 구현하기) or (java.lang.Thread 클래스 상속받기)
          *
          * Thread 상속 vs Runnable 인터페이스 구현
          * Thread 상속보다 Runnable 인터페이스를 구현하기를 선호하는 이유는 두 가지다.
          * 1. 자바는 다중 상속을 지원하지 않는다. 따라서 Thread클래스를 상속하면 하위 클래스는 다른 클래스를 상속할 수 없다
          * 2. Thread 클래스의 모든 것을 상속받는 것이 부담스럽다면 Runnable를 이용한다 
          */

          // 문제1. 문맥전환(context switch)에 소요되는 시간을 측정하는 방법을 이야기하라
          /*
           * 정답
           * 1. B는 A의 데이터를 기다리며 블록된다
           * 2. A는 시작 시간을 기록한다
           * 3. A가 B에게 토큰을 보낸다
           * 4. A는 B가 보내는 응답 토큰을 읽으려 한다. 그 순간 문맥전환이 발생한다
           * 5. B가 스케줄링되고 토큰을 수신한다
           * 6. B가 응답 토큰을 A에게 보낸다
           * 7. B는 A가 보내는 응답 토큰을 읽으려한다. 그 순간 문맥전환이 발생한다
           * 8. A가 스케줄링되어 토큰을 받는다
           * 9. A가 종료 시간을 기록한다
           */
    }
}
