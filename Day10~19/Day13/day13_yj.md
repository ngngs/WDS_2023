# 13일차

### AWS Organization

- 여러 AWS 계정을 중앙집중식 관리 서비스
- 글로벌 서비스
- 관리 계정, 멤버 계정
- OU(Organization Unit) 조직 단위로 관리

**SCP (서비스 제어 정책)**

- 계정에 대한 서비스 액세스를 제어하는 정책
- OU 단위나 계정 단위로 SCP 적용 가능
    - 정책 상속: OU에 SCP를 적용하면, 해당 OU에 속한 계정은 동일한 정책이 적용된다.

### Cloud Watch

- 지표 (Metrics) : AWS 각 서비스에 따른 리소스 사용량 등 측정값을 모니터링
    - 기본 제공 지표나 사용자 정의 지표를 모니터링 할 수 있다.
- 대시보드 : 지표에 대한 그래프 제공
- 로그 : AWS 서비스의 모든 동작에 대한 로그 기록
    - 해당 로그를 Kinesis Data Stream/Firehose, AWS Lambda, S3로 전송 가능
    - Cloud Watch 외에도 Log Agent를 서버에 설치하면 로그 수집 가능
- 경보 : AWS 각 서비스의 지표값에 대한 알림 생성
    - 알림에 대한 이메일 전송, SNS Topic 게시, SQS 대기열에 메시지 전송 가능
    - 알림을 통한 서비스 중단, Auto Scaling 등 트리거 설정 가능