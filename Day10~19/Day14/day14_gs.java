public class day14_gs {
    public static void main(String[] args) {
        // 13 자바
        // 오버로딩 vs 오버라이딩
        // 오버로딩(이름은 같으나 인자의 수나 자료가 다른 메소드) vs 오버라이딩(상위클래스를 재정의)

        // 13.1 상속 관점에서 생성자를 private으로 선언하면 어떤 효과가 있을까?
        // 답 : A의 내부 클래스만이 private 생성자에 접근 가능하다

        // 13.2 finally블록은 try-catch-finally의 try블록 안에 return문을 넣으면 실행이 될까?
        // 답 : try/catch 블록 수행 중에 가성 머신이 종료되거나 스레드가 죽지 않는다면 실행된다

        // 13.3 final, finally, finalize 의 차이는?
        // 답 : final(변수나 메서드를 상수로 선언), finally(항상 실행되는 try/catch블록), finalize(gc가 더 이상 참조가 존재하지 않는 객체를 메모리에서 삭제하겠다고 결정하면 호출)

        // 13.5 TreeMap, HashMap, LinkedHashMap의 차이를 설명하라. 언제 사용하는 게 좋은지 예를 들어라
        // 답 : 세 가지 클래스는 공통적으로 키와 값을 갖지만 시간 복잡도와 키가 놓이는 순서가 다르다
        // HashMap은 검색과 삽입 O(1)이다. 그렇지만 키를 기준으로 순회할 때 키의 순서는 무작위다
        // TreeMap은 검색과 삽입에 O(logN) 시간이다. 키는 정렬되어 있다.
        // LinkedHashMap은 검색과 삽입에 O(1) 시간이 소요된다. 키;는 삽입한 순서대로 정렬되어있고 양방향 연결 버킷으로 구현되어 있다.


    }
}
