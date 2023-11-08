// 07. 객체 지향 설계

// 문제의도 : 유지보수가 가능한 객체 지향적 코드를 만드는 방법을 이해하고 있는가

// 접근법
// 1단계. 모호성의 해소
/*
* 누가, 그것을, 어떻게 사용할 것인가 정의해야한다.
* 예) 목적에 따라 어떤 설계를 할 지 바뀐다.
*/

// 2단계. 핵심 객체의 설계
/*
* 시스템에 넣을 '핵심 객체'(core object)가 무엇인가
* 예) 식당을 설계한다고 가정하자. 핵심 객체는 Table, Guest, Party, Order, Meal, Employee, Server, Host
*/

// 3단계. 관계 분석
/*
* 객체 사이의 관계를 분석.
* 1) 어떤 객체가 어떤 객체에 속해 있는가? (member)
* 2) 다른 객체로부터 상속받아야 하는가? (inherit)
* 3) 관계는 다-대-다(many-to-many)인가 아니면 일-대-다(one-to-many)인가?
* 
* 예) Party는 Guests 배열을 갖어야한다
    Server와 Host는 Employee를 상속받아야한다
    각 Table은 Party를 하나만 가질 수 있지만, 각 Party는 Tables를 여러개 가질 수 있다
    Restaurant에는 Host가 한 멸 뿐이다
*/

// 4. 행동 분석
/*
 * 객체가 수행해야 하는 핵심 행동(core action)들에 대해 생각해보자
 * 한 Party가 Restaurant에 입장하고, 한 Guest가 Host에게 Table을 부탁한다
 * Host는 Reservation을 살펴보고 자리가 있다면 배정하고 없다면 Reservation에 추가한다
 */

 // 5. 디자인패턴
 /*
  * 1) 싱글톤 패턴 : 어떤 클래스가 오직 하나의 객체만을 갖을 때, 전역 객체 시 유용
  */

// 예) Restaurant 클래스는 하나의 객체만 갖는다
public class Restaurant {
    private static Restaurant _instance = null;
    protected Restaurant() {...}
    public static Restaurant getInstance() {
        if (_instance == null){
            _instance = new Restaurant();
        }
        return _instance
    }
}

/*
 * 2) 팩토리 메서드
 * 어떤 클래스의 객체를 생성하기 위한 인터페이스를 제공하되, 하위 클래스에서 어떤 클래스를 생성할 지 결정할 수 있도록 도와준다
 * Factory 메서드 자체에 대한 구현은 제공하지 않고 객체 생성 클래스를 abstract로 선언하고 놔둔다
 */