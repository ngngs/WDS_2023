# 19일차

### VPC 엔드포인트

VPC 내 리소스와 public AWS Service(S3, Dynamo DB 만)를 연결할 때 일반적으로 인터넷을 통해서 연결한다. 

1. VPC 내 서비스에서 서브넷에 연결된 Routing Table에서 IGW 로 라우팅
2. IGW에서 인터넷으로 라우팅
3. 인터넷을 통해서 public AWS Serivce에 연결 

VPC 엔드포인트를 사용하면 인터넷을 통하지 않고 public AWS Service와 private 연결할 수 있다. 

1. VPC 내 서비스에서 서브넷에 연결된 Routing Table에서 VCP 엔드포인트로  라우팅
2. VPC 엔드포인트에서 public AWS service로 연결

### 여러 AWS 계정과 private 연결을 구성하는 방법

VPC peering은 두 VPC를 연결하는 서비스이다. 따라서 연결해야 하는 고객이 많거나 IP가 겹치는 경우 문제가 발생한다. 이를 해결하기 위해 VPC Endpoint를 사용한다. 

여러 Customer Server ↔ 한 Provider application

1. Provider의 애플리케이션 앞에 Network Load Balancer 또는 Gateway Load Balancer 생성
2. 생성한 NLB/GLB를 VCP endpoint로 구성
3. Customer의 서버 앞에 VPC Interface endpoint 구성 
4. Customer의 VPC Interface endpoint와 Provider의 VPC endpoint를 연결

이렇게 인터넷을 통하지 않고 private 연결이 가능하다. 단, 엔드포인트 연결을 위해 Provider와 Customer의 리전이 동일해야 한다.