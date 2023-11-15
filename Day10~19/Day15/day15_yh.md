# 클린코드 15일차

## 10장 클래스 (2)

### 클래스는 작아야 한다!

#### (4) 응집도를 유지하면 작은 클래스 여럿이 나온다

큰 함수를 작은 함수 여럿으로 나누기만 해도 클래스 수가 많아진다. 

예를 들어, <br/>
변수가 아주 많은 큰 함수에서 일부를 작은 함수로 빼내고 싶다. <br/>
근데 빼내려는 코드가 큰 함수에 정의된 변수 4개를 사용한다. <br/>
그러면 파라미터 4개를 받는 새 함수로 빼면 될까??

<u>차라리 그 변수 4개를 로컬 &rightarrow; 인스턴스 변수로 승격</u>시키자. <br/>
그러면 새 함수는 파라미터가 전혀 필요 없다! (애초에 파라미터가 4개인 함수는 clean하지 못하다)

다만 이러다 보면 다른 메서드와 관련 없는 인스턴스 변수가 늘어나게 되고, 클래스는 점차 응집도가 낮아진다. <br/>
**이럴 때 몇몇 함수에 대해 독자적인 클래스로 분리**해주면 좋다. 

> 예시 코드는 책을 참조 (179~184pg)

### 변경하기 쉬운 클래스 ★

해당 장과 예시에 대해서는 아주 자세히 공부를 했는데, 이는 실제로 SK매직에서 설계했던 '동적 SQL 생성 클래스'가 생각났기 때문이다. 
예시에 나온 것처럼 추상화를 이용했다면 변경에 용이한 클래스가 되었을 거 같다는 아쉬움이 든다. 
**시간이 난다면 DynamicQueryUtil 클래스를 리팩토링 해보도록 하자.**

```java
변경이 필요해 손대야 하는 클래스

public class Sql{
    public Sql(String table, Column[] columns)
        
    // 공개 메서드
    public String create()
    public String insert(Object[] fields)
    public String selectAll()
    public String findByKey(String keyColumn, String keyValue)
    public String select(Column column, String pattern)
    public String select(Criteria criteria)
    public String preparedInsert()
    
    // 비공개 메서드
    private String columnList(Column[] columns)
    private String valuesList(Object[] fields, final Column[] columns)
    private String selectWithCriteria(String criteria)
    private placeholderList(Column[] columns)
}
```

현재는 select문만 만들어주는 Sql 클래스이다. 
이대로 사용한다면 문제가 없겠지만, update문을 추가하는 등 클래스에 손을 대야 하는 상황이 온다면 위와 같은 클래스의 형태는 **변경이 쉽지 않은 형태**다.

위 클래스를 아래와 같은 형태로 바꿔준다면 **객체 지향 설계 원칙인 SRP와 OCP를 만족**하게 된다!

변경된 설계 방식은
- 기존 Sql 클래스를 추상화
- 공개 인터페이스를 각각 Sql 클래스에서 파생하는 클래스로 변경
- 비공개 메서드는 해당 파생 클래스(사용하는)로 옮겼다 
- 모든 파생 클래스가 공통으로 사용하는 비공개 메서드는 Where와 ColumnList라는 두 유틸리티 클래스에 넣었다

```java
기존 Sql 클래스를 추상화

abstract public class Sql{
    public Sql(String table, Column[] columns)
    abstract public String generate();
}
```

```java
공개 인터페이스를 각각 Sql 클래스에서 파생하는 클래스로 변경

public class CreateSql extends Sql{
    public CreateSql(String table, Column[] columns)
    @Override public String generate()
}

public class SelectSql extends Sql{
    public SelectSql(String table, Column[] columns)
    @Override public String generate()
}

public class InsertSql extends Sql{
    public InsertSql(String table, Column[] columns)
    @Override public String generate()
    // 비공개 메서드는 해당 파생 클래스(사용하는)로 옮겼다 
    private String valuesList(Object[] fields, final Column[] columns)
}


★이러한 클래스 설계의 장점은 기존 코드를 거의 변경할 필요 없이 새 기능을 추가할 수 있다는 것이다.
만약 update문을 생성하는 기능을 추가하고 싶다면 아래와 같이만 하면 된다.

public class UpdateSql extends Sql{
    구현부...
}
```

```java
모든 파생 클래스가 공통으로 사용하는 비공개 메서드는 Where와 ColumnList라는 두 유틸리티 클래스에 넣었다

public class Where{
    public Where(String criteria)
    public String generate()
}

public class ColumnList{
    public ColumnList(Column[] columns)
    public String generate()
}
```

새 기능을 수정하거나 기존 기능을 변경할 때 건드릴 코드가 최소인 시스템 구조가 바람직하다. <br/>
이상적인 시스템이라면 새 기능을 추가할 때 시스템을 확장할 뿐 기존 코드를 변경하지는 않는다.

#### 변경으로부터 격리

객체 지향 프로그래밍 입문에서 구체적인(concrete) 클래스와 추상(abstract) 클래스가 있다고 배웠다.

**상세한 구현에 의존하는 코드는 변경이 어렵다.**

예를 들어, Portfolio 클래스를 만들 때 TokyoStockExchange라는 외부 API를 사용해 포트폴리오 수익을 계산한다고 해보자. 
TokyoStockExchange를 Portfolio에서 직접 호출하면 훗날 **API 변경도 어렵고, <u>테스트 코드를 짜기도 어렵다.</u>** 
이는 인터페이스를 이용하여 해결할 수 있다.

```java
public interface StockExchange{
    Money currentPrice(String symbol); // 해당 주식의 수익을 리턴하는 함수
}
```
```java
public Portfolio{
    private StockExchange exchange;
    public Portfolio(StockExchange exchange){
        this.exchage = exchange;
    }
    // ...
}
```

이렇게 개선한 Portfolio 클래스는 TokyoStockExchange라는 상세한 구현 클래스가 아니라 StockExchange 인터페이스에 의존한다.
- 추상 : StockExchange 인터페이스에는 주식 기호를 받아 현재 주가를 얻는다는 개념만 
- 구현 : TokyoStockExchange 클래스에는 실제로 주가를 얻어오는 출처나 얻어오는 방식 등의 구체적인 구현을 