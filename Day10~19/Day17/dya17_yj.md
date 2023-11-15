# 17일차

### CIDR

참고: [https://inpa.tistory.com/entry/WEB-🌐-CIDR-이-무얼-말하는거야-⇛-개념-정리-계산법#cidr_classless_inter-domain_routing](https://inpa.tistory.com/entry/WEB-%F0%9F%8C%90-CIDR-%EC%9D%B4-%EB%AC%B4%EC%96%BC-%EB%A7%90%ED%95%98%EB%8A%94%EA%B1%B0%EC%95%BC-%E2%87%9B-%EA%B0%9C%EB%85%90-%EC%A0%95%EB%A6%AC-%EA%B3%84%EC%82%B0%EB%B2%95#cidr_classless_inter-domain_routing)

- 서브네팅, 슈퍼네팅 같이 IP를 나누고 합치는 기법
- IP 주소 범위와 서브넷 마스크를 한번에 표시

### VPC

- AWS private network
    - 따라서 AWS의 public Service는 VPC 외부에 위치한다.

### Custom 네트워크 구성 순서

1. VPC 생성
    - 특정 리전에 생성
    - CIDR 블록으로 IPv4 주소 범위를 지정한다.
    - VPC를 생성하면 CIDR 범위 수정은 불가, 새로운 CIDR 블록 추가 가능
    - VPC를 생성하면, NACL과 routing table 이 기본적으로 생성된다.
2. Subnet 생성
    - 특정 가용영역에 서브넷 생성 (리전 내 여러 가용 영역 존재하기 때문에)
    - CIDR 블록으로 IP 주소 범위를 지정한다.
    - VPC 내 서브넷끼리 IP 주소 범위가 중첩될 수 없다.
    - 서브넷을 생성하면 AWS는 네트워킹을 목적으로 처음 4개 IP 주소, 마지막 1개 IP 주소를 예약한다.
3. Routing Table 생성
    - Destination(대상주소)에서 Target(목적지)으로 트래픽을 전송할 라우팅 규칙을 지정
    - Destination : IP 주소 범위,
    - Target : 게이트웨이, 인스턴스, 네트워크 인터페이스, 로컬, 등
4. Internet Gateway 생성
    - VPC와 인터넷 간 통신을 가능하게 한다.
    - 퍼블릭 IPv4가 할당된 인스턴스에 대해 1:1 NAT(네트워크 주소 변환)를 수행
    - 송신전용(egress-only) 인터넷 게이트웨이 : VPC에서 인터넷 외부로 트래픽만 허용
5. EC2 Instance 생성

---

### Oracle - Autonomous transaction

메인 프로시저에서 다른 프로시저나 함수를 호출할 때 서브 프로시저에서 커밋을 수행하면 메인 프로시저의 작업도 커밋된다.

서브 프로시저의 커밋이 메인 프로시저에 영향을 주지 않기 위한 방법으로 **AUTONOMOUS TRANSACTION** 이 있다.  

```jsx
// 서브 프로시저에서 아래 코드를 명시
PRAGMA AUTONOMOUS_TRANSACTION
```

- 해당 블록에 고유한 트랜잭션을 생성
- 부모 트랜잭션의 커밋/롤백에 영향을 받지 않는다.
- 부모 프로시저 안에서 로그를 남기는 프로시저를 호출하는 경우, 로그 프로시저에서 로그를 INSERT/UPDATE 하고 COMMIT을 수행할 때 사용한다.