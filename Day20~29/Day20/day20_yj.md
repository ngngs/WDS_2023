# 20일차

### AWS 서비스 간 데이터 전송 비용

동일한 서비스일 경우)

비용 : 동일 가용영역 내 < 동일 리전 내 서로 다른 가용 영역 < 서로 다른 리전 간

- EC2 인스턴스 사이 통신
    - 같은 가용 영역 : 무료
    - 서로 다른 가용 영역 : 유료
    - 서로 다른 리전 : 유료
- EC2 인스턴스 → 인터넷 (아웃바운드) : 유료
- EC2 인스턴스 ← 인터넷 (인바운드) : 무료
- EC2 → ELB (아웃바운드)
    - 같은 가용 영역 : 무료
    - 다른 가용 영역 : 유료
- EC2 ← ELB (인바운드) : 무료

- ELB → 인터넷 (아웃바운드) : 유료
- ELB ← 인터넷 (인바운드) : 유료

- Direct Connect → 인터넷 : 유료
- Direct Connect ← 인터넷 : 무료

- Public Service (S3, Dynamo DB 등) → CloudFront : 무료
- Public Service (S3, Dynamo DB 등) ← CloudFront : 유료

- CloudFront → 외부 : 유료
- CloudFront ← 외부 : 무료

> 내부(S3)에서 CloudFront로 컨텐츠를 캐싱하고, 외부에서 CloudFront 로 접속하는 것이 직접 S3에 접속하는 것보다 비용이 절감된다.
> 

### CloudFormation

코드를 통해 AWS 리소스를 구성하고 관리하는 서비스

**구성요소**

- Template : AWS 리소스를 구성하는 텍스트 파일, JSON 또는 YAML 형식
- Stack : Template을 사용하여 생성한 리소스
    - stack 삭제 시 해당 리소스가 실제로 사라지게 된다(종료).
- Change Set : stack 리소스 변경 사항에 대한 세트