# 21일차

### ECS (Elastic Contrainer Service)

- Docker 컨테이너를 지원하는 컨테이너 관리 서비스
- Amazon EC2 인스턴스의 관리형 클러스터 생성해 사용한다.
    1. 클러스터 생성
    2. 태스크 정의
    3. 서비스 생성 

**ECS 시작 유형**

- Fargate 시작유형
    - 서버리스 방식으로 Amazon ECS 워크로드를 호스팅, 사용자가 관리 X
- ECS 시작유형
    - 사용자가 직접 Amazon ECS 클러스터를 등록하고 관리, EC2 인스턴스에서 컨테이너화 된 애플리케이션을 실행
- ECS Anywhere
    - 온프레미스 서버나 가상머신에 컨테이너화 된 애플리케이션을 실행하며 Amazon ECS 클러스터에 등록

### EKS (Elastic Kubernetes Service)

- AWS에서 Kubernetes를 실행하는 서비스

**배포 옵션** 

- AWS EKS : AWS 클라우드에 Kubernetes 클러스터를 배포하는 옵션
    - 노드 : 애플리케이션을 동작하기 위한 가상머신
    - 컨트롤 플레인 : 노드들을 관리
- Amazon EKS Anywhere : 온프레미스에 Kubernetes 클러스터를 생성, 운영할 수 있게 해주는 배포 옵션

**노드 유형**

- EKS managed node groups
    - EKS 에서 자동으로 EKS 클러스터의 노드(AWS EC2 인스턴스)를 생성,관리
    - 보안, 업데이트 등 일부분만 사용자가 관리
    - 모든 관리형 노드는 Amazon EKS에서 관리하는 Amazon EC2 Auto Scaling 그룹의 일부로 프로비저닝 된다.
    - 관리형 노드 그룹을 생성 시, 온디맨드 or 스팟 용량 유형 선택 가능
- Self managed nodes
    - 사용자가 직접 EKS 클러스터의 노드(Amazon EC2 인스턴스)를 생성, 관리
    - 온디맨드 or 스팟 용량 유형 선택 가능
- AWS Fargate
    - 노드 관리를 AWS에서 담당
    - AWS에서 EKS의 모든 환경을 자동으로 관리