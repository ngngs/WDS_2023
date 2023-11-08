# 11일차

### Kinesis

- 실시간 스트리밍 데이터를 처리, 수집, 분석하는 서비스

**종류**

- Kinesis Data Stream : 데이터 스트림을 수집, 저장하는 서비스
- Kinesis Data FireHouse : 데이터 스트림을 AWS 데이터 저장 서비스로 로드하는 서비스
- Kinesis Data Analytics  : SQL, Apache Flink로 데이터 스트림을 분석하는 서비스
- Kinesis Video Stream : 비디오 스트림 처리, 분석, 저장하는 서비스

## 그 외 서비스

### AWS API Gateway

- 개발자가 API를 생성, 게시, 유지관리, 모니터링 및 보안 유지하는 것을 지원하는 서비스

### AWS AppFlow

- SaaS 애플리케이션과 AWS 서비스 간 안전한 데이터 전송을 위한 서비스
- SaaS 애플리케이션에서 AWS 서비스 API를 별도로 구축할 필요가 없다.

## AWS 인증 서비스

### AWS Cognito

1. 애플리케이션에서 사용자 로그인 
2. 사용자 Pool에 계정 정보가 있는지 확인 > 토큰 반환
3. 토큰을 첨부해서 자격증명 pool에 권한이 있는지 확인 >  인증서 반환
4. 인증서로 해당 서비스 이용이 가능해진다.

### AWS SSO

- 하나의 계정으로 여러 애플리케이션에 로그인하는 기능
- AWS Organization, Active Directory, SAML 2.0과 통합 가능

> SSO (Single Sign On, 통합인증) :
한번의 로그인으로 컴퓨터 상의 여러 서비스를 이용 가능하게 하는 인증 기능
> 

> SAML : 인증 정보 제공자와 서비스 제공자 간의 인증 및 인가 데이터를 교환하기 위한 XML 기반의 개방형 표준 데이터 포맷
>