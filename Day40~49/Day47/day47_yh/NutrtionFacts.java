package study.my.java.whiteship.effective_java.chapter01.item02.lecture01;

public class NutrtionFacts {
    private final int servingSize;  // (mL, 1회 제공량) 필수
    private final int servings;     // (회, 총 n회 제공량) 필수
    private final int calories;     // (1회 제공량당) 선택
    private final int fat;          // (g/1회 제공량) 선택
    private final int sodium;       // (mg/1회 제공량) 선택
    private final int carbohydrate; // (g/1회 제공량) 선택

    public NutrtionFacts(int servingSize, int servings){
        this(servingSize, servings, 0); // 매개변수가 적은 쪽(2개)에서 많은 쪽(3개) 생성자를 호출
    }

    public NutrtionFacts(int servingSize, int servings, int calories){
        this(servingSize, servings, calories, 0); // 마찬가지로 3개짜리에서 4개짜리 생성자를 호출
    }

    public NutrtionFacts(int servingSize, int servings, int calories, int fat){
        this(servingSize, servings, calories, fat, 0); // 이런 식으로 연쇄적으로 코드를 쓰기 때문에 '생성자 체이닝' 혹은 '점층적 생성자 패턴'이라고 부른다.
    }

    public NutrtionFacts(int servingSize, int servings, int calories, int fat, int sodium){
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    // 마지막 생성자 코드
    public NutrtionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate){
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}
