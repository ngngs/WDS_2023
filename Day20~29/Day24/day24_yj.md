# 24일차

[참고: **Amazon CloudFront 오리진 액세스 제어(OAC)로 S3 오리진 보호하기**](https://aws.amazon.com/ko/blogs/korea/amazon-cloudfront-introduces-origin-access-control-oac/)

### CloudFront의 OAI

Amazon S3를 웹 사이트, 비디오와 같은 콘텐츠를 호스팅하는 원본으로 사용하고 CloudFront에서 해당 콘텐츠를 사용자에게 제공한다. 

여기서 **CloudFront는 OAI (Origin Access ID)**를 활용해 CloudFront를 통해서만 S3 오리진에 접근하도록 해서 S3를 보호할 수 있다. 

**OAI의 한계**

- AWS Signature Version 4 요구
- POST method를 사용하는 HTTP/HTTPS 요청 지원하지 않음
- AWS KMS를 사용한 서버측 암호화를 지원하지 않음

→ 이러한 한계를 극복하기 위한 방법으로 **OAC**

### OAC

IAM 서비스 보안 주체를 사용하여 S3 오리진을 인증

- 보안- 단기 자격 증명, 리소스 기반 정책 등 향상된 보안 방식 지원
- 포괄적인 HTTP method 지원 - GET, PUT, POST, PATCH, DELETE, OPTIONS 및 HEAD 지원
- SSE-KMS - SSE-KMS로 암호화된 S3 객체 다운로드 및 업로드 지원
- 모든 AWS 리전에서 S3 접근 가능 - 모든 AWS 리전에서 S3에 접근할 수 있다. (OAI는 2022.12월 이전에 출시된 리전에서만 지원)