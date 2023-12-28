package study.my.java.whiteship.effective_java.chapter01.item02.lecture03;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// 코드 2-4 계층적으로 설계된 클래스와 잘 어울리는 빌더 패턴 (19쪽)

// 참고 : 여기서 사용한 '시뮬레이트한 셀프 타입(simulated self-type)' 관용구는
// 빌더뿐 아니라 임의의 유동적인 계층구조를 허용한다.
public abstract class Pizza {
    public enum Topping{ HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }
    final Set<Topping> toppings;

    // 추상 클래스인 Pizza의 Builder
    abstract static class Builder<T extends Builder<T>>{
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class); // 이게 무슨 코드지..?
        public T addTopping(Topping topping){
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // 하위 클래스는 이 메서드를 재정의(overriding)하여
        // "this"를 반환하도록 해야 한다.
        protected abstract T self();
    }
    // 위 Builder를 이용하는 생성자
    Pizza(Builder<?> builder){ // 파라미터로 Builder를 받는다.
        toppings = builder.toppings.clone();
    }
}
