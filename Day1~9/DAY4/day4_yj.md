# 4일차

### 그 외 FSx

- FSx for NetApp ONTAP : NetApp ONTAP 파일 시스템에 구축, NFS, iSCSI 프로토콜을 지원하는 시스템으로 Linux, Windows 및 MacOS와 연결 가능
- FSx for OpenZFS : NFS 프로토콜을 지원하는 시스템

### AWS DataSync와 유사 서비스

- AWS DataSync vs AWS Snowball Edge
    - AWS DataSync : 온라인 데이터 전송
    - AWS Snowball Edge : 오프라인 데이터 전송

- AWS DataSync vs AWS Storage Gateway
    - AWS DataSync : 주로 1회성 데이터 마이그레이션 용도
    - AWS Storage Gateway : 마이그레이션 된 데이터 및 온프레미스 파일 애플리케이션과 지속적인 액세스를 위한 용도

- AWS DataSync vs Amazon S3 Tracsfer Acceleration
    - Amazon S3 Tracsfer Acceleration : S3로 대용량 파일 전송을 위한 서비스

- AWS DataSync vs AWS Transfer Family
    - AWS DataSync : (온프레미스) NFS 서버, SMB 파일 공유 또는 AWS 스토리지 서비스 간 데이터 마이그레이션을 자동화하는 용도
    - AWS Transfer Family : FTP 서비스, FTP 프로토콜을 사용해 AWS S3 및 EFS 와 파일 전송하는 용도