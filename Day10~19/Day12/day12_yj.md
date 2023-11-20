# 12일차

## 보안 서비스

### Secret Manager

- 자격증명을 저장, 검색, 액세스 제어, 교체, 감사 및 모니터링하는 서비스
- 자격증명을 자동으로 교체, 관리하는 기능을 지원

1. 사용자는 자격증명을 요청 → Secret Manager
2. Sercret Manger는 자격증명을 반환
3. 사용자는 해당 자격증명을 사용해 다른 애플리케이션/서비스를 사용

**보안 방법**

- 사용자가 소유하는 AWS KMS의 암호화 키를 사용해 자격증명을 암호화
- 사용자의 IAM 정책을 사용해 자격증명에 대한 액세스 제어
- 사용자가 자격증명 검색 시 Sercret Manager가 저장된 자격증명을 복호화 > TLS를 통한 안전한 전송

### AWS Shield

- AWS 애플리케이션을 DDoS 공격으로부터 보호하는 서비스

**유형**

- Shield Standard : 무료, 모든 AWS 사용자에게 기본 적용
- Shield Advanced : 유료, 보다 많은 보호 기능 제공

### AWS WAF

- Web Application Firewall
- 웹 애플리케이션 보호 방화벽
- HTTP 에서 동작 (OSI 7계층, 애플리케이션 계층)
- AWS Application Load Balancer, API Gateway, CloudFront에 적용 가능하다.
- Web ACL (Access Control List)를 설정해서 방화벽을 설정할 수 있다.
    - 악성 IP 주소 차단
    - 특정 국가의 액세스 제어
    - SQL Injection, XSS 방어
    - 속도기반규칙을 통한 DDoS 방어

*cf) AWS Firewall Manager : 애플리케이션이나 계정의 방화벽 규칙을 중앙집중식으로 구성 및 관리할 수 있는 서비스

### 기타 서비스

- AWS GuardDuty : AWS 계정 및 워크로드에서 악의적인 행동을 모니터링하는 위협 탐지 서비스, only 탐지만 가능
- AWS Macie : AWS 서비스에 존재하는 민감한 데이터를 식별하고 사용자에게 알리는 서비스
    - EX) S3 내 민감한 데이터를 식별
- Amazon Inspector : EC2 및 컨테이너 워크로드에서 소프트웨어의 취약성이나 의도하지 않은 네트워크 노출을 지속적으로 스캔하는 취약성 관리 서비스