package study.my.java.whiteship.effective_java.chapter01.item02.lecture03;

public class Calzone extends Pizza{
    private final boolean sauceInside;

    // Calzone의 Builder
    public static class Builder extends Pizza.Builder<Builder>{ // 부모인 Pizza의 Builder를 상속받고 있다.
        private boolean sauceInside = false; // 기본값
        public Builder sauceInside(){
            sauceInside = true;
            return this;
        }
        @Override
        Calzone build() {
            return new Calzone(this); // 현재 Builder 클래스 내에 있으므로 this는 Builder이다.
        }
        @Override
        protected Builder self() {
            return this;
        }
    }
    // build() 메서드를 위해 필요한 생성자
    private Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    @Override
    public String toString(){
        return String.format("%s로 토핑한 칼초네 피자 (소스는 %s에)", toppings, sauceInside ? "안" : "바깥");
    }
}
