# 6일차

### Global Accelerator의 Client Affinity

- 엣지로케이션을 사용해 사용자에게 가장 적합한 엔드포인트를 찾아서 라우팅하는 서비스
- (default) Client Affinity는 None
    - Global Accelerator가 트레픽을 엔드포인트 그룹에서 균등하게 분산 시킴
- Client Affinity를 특정 IP로 설정하는 경우
    - source IP와 destination IP를 사용해서, 사용자가 접속할 때마다 이전에 접속한 것과 동일한 엔드포인트로 라우팅 한다.

*엔트포인트 그룹: 사용자의 트래픽을 라우팅 할 엔드포인트 그룹, EC2, ALB, NLB 등 설정 가능 

### AWS CloudFront vs AWS Global Accelerator

**AWS CloudFront** 

- 엣지로케이션에 콘텐츠를 캐싱
- 동적 IP 주소 사용
- HTTP 프로토콜 처리에 적합

**AWS Global Accelerator**

- 엣지로케이션을 사용해 사용자와 가까운 리전으로 AWS 전용 고속망을 사용해 라우팅
- Anycast의 고정 IP 주소 2개 사용
- TCP, UDP 프로토콜 처리에 적합
- health check를 통해 해당 엔드포인트가 사용 가능한지 체크 > 사용 가능한 엔드포인트로 자동 라우팅