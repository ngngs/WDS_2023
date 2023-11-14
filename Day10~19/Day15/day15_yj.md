# 15일차

### DNS Resolution

1. 사용자가 웹 브라우저에 hostname (url 주소) 입력
2. 웹 브라우저가 ISP가 관리하는 DNS resolver로 라우팅
3. DNS resolver는 해당 hostname에 대한 요청을 DNS Root Name Server로 전달
4. DNS Root Name Server는 DNS resolver에게 TLD 주소를 반환
5. DNS resolver는 TLD Name server로 요청 전달
6. TLD Name Server는 DNS resolver에게 Amazon Route53 Name Server 이름을 반환
7. DNS resolver는 Route 53으로 요청 전달
8. Amazon Route53 Name Server는 hostname에 해당하는 레코드를 찾아 DNS resolver에게 웹 서버 IP 주소 반환
9. DNS resolver는 반환된 IP 주소와 TTL (캐싱 시간)을 웹 브라우저로 반환
10. 웹 브라우저는 반환된 IP 주소로 요청
11. 웹 서버는 해당하는 리소스를 웹 브라우저로 반환 → 웹 브라우저 표시

**DNS 레코드 유형**

- A : 도메인 네임을 IPv4 주소로 라우팅
- AAA : 도메인 네임을 IPv6 주소로 라우팅
- CNAME : 도메인 네임을 도메인 네임으로 라우팅
- ALIAS : 도메인 네임을 AWS 리소스로 라우팅
- MX (Mail eXchanger) : 이메일 서버 연동시 메일의 소유를 확인하기 위한 레코드
- NS (Name Server) : DNS 레코드를 가진 DNS 서버를 식별하기 위한 레코드
- SOA (Start Of Authority) : 도메인의 정보와 권한을 가진 레코드

---

## PL/SQL 형식 파라미터 모드 중 NOCOPY

참고: [https://www.dba-oracle.com/t_pl_sql_nocopy_data_structures.html](https://www.dba-oracle.com/t_pl_sql_nocopy_data_structures.html)

프로시저와 함수 간에 매개변수 값을 전달하는 두가지 방법이 있다. 

- IN 모드 : 매개변수의 참조값을 전달
- OUT, IN OUT 모드 : 형식 매개변수에 실제 값을 복사, 프로시저 내부에서 매개변수에 변경사항이 발생해도 외부 변수 값에 영향을 주지 않음, 프로시저가 예외없이 완료된 경우 결과값을 형식 매개변수에 다시 복사

### NOCOPY

- 값 복사 대신 참조로 OUT, IN OUT 매개변수에 전달 가능
- 대규모 컬렉션이나 테이블을 OUT, IN OUT 매개변수로 전달할 경우 값을 복사하여 불필요한 CPU, 메모리가 낭비 될 수 있다. 이를 NOCOPY 옵션을 통해 해결 할 수 있다.
- 예외처리 주의
    - 프로시저 내부에서 매개변수에 대해 수행하는 모든 수정 사항이 실제 매개변수에 반영된다. 즉, 실행을 취소할 수 있는 방법이 없다.
    - 프로시저가 예외가 발생해 종료되는 경우, 해당 변수값이 더이상 유효하지 않을 수 있다.