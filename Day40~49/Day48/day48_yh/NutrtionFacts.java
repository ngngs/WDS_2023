package study.my.java.whiteship.effective_java.chapter01.item02.lecture02;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder(builderClassName = "YongBuilder")
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class NutrtionFacts {
    private final int servingSize;  // (mL, 1회 제공량) 필수
    private final int servings;     // (회, 총 n회 제공량) 필수
    private final int calories;     // (1회 제공량당) 선택
    private final int fat;          // (g/1회 제공량) 선택
    private final int sodium;       // (mg/1회 제공량) 선택
    private final int carbohydrate; // (g/1회 제공량) 선택

    public static void main(String[] args) {
        NutrtionFacts nutrtionFacts = NutrtionFacts.builder() // 롬복이 제공하는 Annotation Processor가 만들어 준 것이다. (ref. 강의 : 더 자바, 코드를 조작하는 방법)
                .calories(150)
                .build();
        // 컴파일하는 시점에 @Builder라는 어노테이션을 읽어들여 코드를 조작할 수 있는 기능을 제공한다.
        // 그 기능을 Annotation Processor라고 부르며, 자바가 제공한다?
        // 정리하면, 컴파일하는 시점에 롬복이 @Builder를 읽어들여 NutrtionFacts 클래스를 조작하고, Builder와 관련된 코드를 생성하기 때문에 우리가 빌더를 사용할 수 있는 것이다.


        // 단점.
        // 1. 모든 파라미터를 받는 생성자도 생긴다. (그나마 극복 가능한 단점)
        NutrtionFacts nutrtionFacts1 = new NutrtionFacts(1, 2, 3, 4, 5, 6);

        // 2. 필수 값을 지정하기 어렵다. (극복하기 어려운 단점)
//        NutrtionFacts nutrtionFacts2 = new NutrtionFactsBuilder()
//                .servingSize(1)
//                .servings(2)
//                .calories(3)
//                .build();
    }
}
