# 28일차

### AWS DynamoDB

- NoSQL 데이터베이스
- 서버리스 서비스
    - AutoScaling : 사용 용량에 맞게 자동으로 확장 및 축소
- 초당 수백만개 이상의 요청 처리 가능

→ 운영 오버헤드가 적고, 빠른 응답이 필요한 데이터베이스가 필요한 경우 사용

### 사용 사례에 따른 데이터베이스

| 데이터베이스 유형 | 사용 사례 |  |
| --- | --- | --- |
| 관계형 | 기존 애플리케이션, ERP, 고객 관계 관리 (CRM), 전자 상거래 시스템 | amazon Aurora, amazon RDS, amazon Redshift |
| 키-값 | 높은 트래픽의 웹 애플리케이션, 전자 상거래 시스템, 게임 | amazon DynamoDB |
| 인메모리 | 캐싱, 세션 관리 | amazon ElastiCache, amazon Memory DB for Redis |
| 문서 | 콘텐츠 관리, 사용자 프로필 | Amazon Document DB |
| 와이드 컬럼 | 장비 관리, 경로 최적화에 사용하는대규모 산업용 앱 | amazon Keyspaces |
| 그래프 | 부정 탐지, 소셜 네트워킹, 추천 엔진 | amazon Neptune |
| 시계열 | 사물 인터넷 애플리케이션, DevOps | amazon timestream |