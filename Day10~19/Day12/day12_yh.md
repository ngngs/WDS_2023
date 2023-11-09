# 클린코드 12일차

## 9장 단위 테스트

### 테스트당 assert 하나

JUnit으로 테스트 코드르르 짤 때는 함수 1개마다 assert문을 단 1개만 사용해야 한다고 주장하는 학파가 있다. <br/>
훌륭한 지침이라고 생각되나 때로는 여러 개의 assert문을 넣어야 할 때도 있긴 있다.

#### 테스트당 개념 하나

따라서 <u>가장 좋은 규칙은 "테스트 함수 1개마다 1개의 개념만을 테스트하라"는 것</u>이다. <br/>

* addMonth() 메서드를 테스트하는 안 좋은 예시
```java
public void testAddMonths(){
    SerialDate d1 = SerialDate.createInstance(31, 5, 2004);

    SerialDate d2 = SerialDate.addMonths(1, d1);
    assertEquals(30, d2.getDayOfMonth());
    assertEquals(6, d2.getMonth());
    assertEquals(2004, d2.getYYYY());

    SerialDate d3 = SerialDate.addMonths(2, d1);
    assertEquals(31, d3.getDayOfMonth());
    assertEquals(7, d3.getMonth());
    assertEquals(2004, d3.getYYYY());
    
    SerialDate d4 = SerialDate.addMonths(1, d1);
    assertEquals(30, d4.getDayOfMonth());
    assertEquals(7, d4.getMonth());
    assertEquals(2004, d4.getYYYY());
}
```


위 테스트 메서드의 문제점은 1개의 메서드에서 여러 개의 개념을 테스트한다는 것이다.
- 31일로 끝나는 달의 마지막 날짜가 주어지는 경우
- 30일로 끝나는 달의 마지막 날짜가 주어지는 경우
- ...

### F.I.R.S.T

깨끗한 테스트 코드의 5가지 규칙

#### Fast (빠르게)

테스트 코드 수행 시간이 빨라야 한다. 느리면 테스트를 자주 안 돌리게 되기 때문이다.

#### Independent (독립적으로) ★

각 테스트는 서로 의존하면 안 된다. <br/>
즉, 한 테스트가 다음 테스트가 실행될 환경을 준비해서는 안 된다. <br/>
각 테스틑 독립적으로 그리고 어떤 순서로 실행해도 괜찮아야 한다. 

#### Repeatable (반복가능하게)
테스트는 어떤 환경에서도 반복 가능해야 한다.  <br/>
실제 환경, QA 환경, 네트워크에 연결되지 않은 노트북 환경에서도 실행할 수 있어야 한다.

#### Self-validating (자가검증하는) ★

테스트의 결과 값은 true/false인 boolean으로 내야 한다. (그래야 빠르다) <br/>
테스트 결과를 로그로 읽는 수고로움을 남겨서는 안 된다. 


#### Timely (적시에)

테스트는 적시에 작성해야 한다.<br/> 
즉, 단위 테스트는 테스트하려는 실제 코드를 구현하기 직전에 구현한다.
