package study.my.java.whiteship.effective_java.chapter01.item02.lecture03;

import java.util.Objects;

public class NyPizza extends Pizza{
    private enum Size{ SMALL, MEDIUM, LARGE }
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder>{
        private final Size size;
        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }
        @Override
        NyPizza build() {
            return new NyPizza(this);
        }
        @Override
        protected Builder self() {
            return this;
        }
    }
    // build() 메서드를 위해 필요한 생성자
    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
    @Override
    public String toString(){
        return toppings + "로 토핑한 뉴욕피자";
    }
}
