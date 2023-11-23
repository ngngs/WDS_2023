# 22일차

### 대표적인 서버리스 서비스

- AWS Lambda, AWS Fargate
- Amazon S3, Daynamo DB, Amazon Aurora Severless
- Amazon SNS, Amazon SQS, API Gateway

> **AWS Fargate**
서버리스 컨테이너 서비스, ECS, EKS와 연동 가능
ECS, EKS에서 Fargate 를 통해 프로비저닝 된 컨테이너 클러스터를 사용하여 Auto Scaling, 로드 밸런싱 수행 가능
> 

### Elastic Beanstalk

- 웹 애플리케이션 및 서비스를 자동 배포 및 운영하는 서비스
- 사용자는 애플리케이션 코드만 업로드하면 된다.

### Elastic Beanstalk 워크플로우

1. 사용자가 애플리케이션을 생성
2. 애플리케이션을 Elastic Beanstalk에 업로드
3. Elastic Beanstalk이 애플리케이션에 맞는 인프라를 자동 구성해 배포
    - 웹 애플리케이션에 필요한 EC2, Security Group, public IP, Auto Scaling Group 등
4. 사용자가 새로운 버전의 애플리케이션을 업로드하면 Elastic Beanstalk이 다시 환경을 구성해 배포