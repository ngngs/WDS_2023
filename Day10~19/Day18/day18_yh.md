# 클린코드 18일차

## 12장 창발성

### 개요

켄트 벡이 제시한 '단순한 설계' 규칙 4가지가 소프트웨어 설계 품질을 크게 높여줄 수 있다.

1. 모든 테스트를 실행한다.
2. 중복을 없앤다.
3. 프로그래머 의도를 표현한다.
4. 클래스와 메서드 수를 최소로 줄인다.

### 단순한 설계 규칙 1 : 모든 테스트를 실행하라

테스트 케이스를 많이 작성할수록 개발자는 DIP와 같은 원칙을 적용하고 
의존성 주입(DI, Dependency Injection), 인터페이스, 추상화 등과 같은 도구를 사용해 결합도를 낮출 수 있다. 이에 따라 설계 품질이 높아진다. 

### 단순한 설계 규칙 2~4 : 리팩터링

#### (1) 중복을 없애라

##### TEMPLATE METHOD 패턴을 통해 '고차원 중복'을 제거한 예시

아래 예시는 미국인지 유럽연합인지만 제외하면 나머지 부분은 상당히 중복된 코드이다.

```java
public class VacationPolicy{
    public void accrueUSDivisionVacation(){
        지금까지 근무한 시간을 바탕으로 휴가 일수를 계산하는 코드
        ...
        휴가 일수가 미국 최소 법정 일수를 만족하는지 확인하는 코드
        ...
        휴가 일수를 급여 대장에 적용하는 코드
    }

    public void accrueEUDivisionVacation(){
        지금까지 근무한 시간을 바탕으로 휴가 일수를 계산하는 코드
        ...
        휴가 일수가 유럽연합 최소 법정 일수를 만족하는지 확인하는 코드
        ...
        휴가 일수를 급여 대장에 적용하는 코드
    }
}
```

중복을 제거한 코드

```java
1. 기존 VacationPolicy 클래스를 추상화

abstract public class VacationPolicy {
    public void accrueVacation() {
        calculateBaseVacationHours(); // 지금까지 근무한 시간을 바탕으로 휴가 일수를 계산하는 코드
        alterForLegalMinimums();      // 휴가 일수가 OO 최소 법정 일수를 만족하는지 확인하는 코드
        applyToPayroll();             // 휴가 일수를 급여 대장에 적용하는 코드
    }

    2. 중복되는 코드는 구현하고, 중복되지 않은 코드는 추상화
    private void calculateBaseVacationHours() { /* ... */ };
    abstract protected void alterForLegalMinimums();
    private void applyToPayroll() { /* ... */ };
}
```

```java
3. 서로 다른 코드 부분만 @Override로 해결 

public class USVacationPolicy extends VacationPolicy {
    @Override
    protected void alterForLegalMinimums() {
        // 미국 최소 법정 일수 관련 코드
    }
}

public class EUVacationPolicy extends VacationPolicy {
    @Override
    protected void alterForLegalMinimums() {
        // 유럽연합 최소 법정 일수 관련 코드
    }
}
```


#### (2) 프로그래머 의도를 표현하라

코드는 개발자의 의도를 분명히 표현해야 한다. 그렇지 않으면 유지보수 개발자가 코드를 이해하는데 걸리는 시간이 점점 늘어나고, 복잡해지기 때문이다.

1. 좋은 이름을 선택한다. 이름과 기능이 완전히 딴판인 클래스나 함수를 만들어선 안된다.
2. 함수와 클래스 크기를 가능한 줄인다. 크기가 작아야 구현도 이해도 쉽다.
3. 표준 명칭을 사용한다. (ex. 디자인 패턴을 사용했다면 클래스 이름에 패턴 이름을 넣어라)
4. 단위 테스트 케이스를 꼼꼼히 작성한다.

#### (3) 클래스와 메서드 수를 최소로 줄여라 