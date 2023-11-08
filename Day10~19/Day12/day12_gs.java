// 09. 시스템의 설계 및 확장성

/*
 * 문제 9.1. 서비스를 하나 구현한다. 이 서비스는 폐장 시점에 주가 정보(시작가, 종가, 최고가, 최저가)를 최대 1000개의 클라이언트에게 제공한다
 * 데이터는 이미 주어져 있고, 어떤 형태로든 저장할 수 있다.
 * 이 서비스를 어떻게 설계할 것인가? 개발과 배포를 책임져야 하고, 지속적으로 시스템을 모니터링 하는 한편 사용자에게 전송되는 정보를 관리해야한다.
 * 어떤 접근법을 택했는 지, 그 접근법을 선택한 이유는 무엇인가
 * 클라이언트 프로그램에 정보를 전송하는 방법도 원하는대로 선택해라.
 */

 /*
  * 나의 답 : 클라이언트의 편의성을 최우선으로 고려한 설계. 모바일로 볼 확률이 높기에 모바일로 보기 적합한 형태로 (안드로이드, 아이폰) 나누어 자료를 제공
  서버의 입장에서 생각해보면, 주가 정보의 데이터 특성상 정해진 시간에만 데이터가 들어옴. 데이터가 유입될 때만 서버를 추가적으로 키는 방안
  */

/*
* 답지 : 1)클라이언트 편의성 2)서버 편의성 3)요구를 수용하기 유연한 구조 4)규모 확장성과 효율성을 고려하라

  방법1: 데이터를 간단한 텍스트 파일에 보관하고 클라이언트가 그 데이터를 FTP 서버에서 다운.
        이 경우, 유지보수성이 높지만 쿼리를 날리려면 텍스트 파일을 파싱해야하는 과정이 복잡하다
    
  방법2: 표준SQL 데이터베이스를 이용해 클라이언트가 해당 디비에 직접 사용할 수 있도록 만든다.
  장점 : 클라이언트가 쿼리를 날리기 쉽다. 처음부터 전부 개발할 필요가 없다. 기존 애플리케이션에 통합하기 쉽다
  단점 : 개발 결과물이 필요 이상으로 무거워진다. 보안 문제가 발생한다

  방법3 : 최적의 선택은 XML이다. XML은 정보를 전송하기 가장 좋은 포맷이다.
        우리가 전송해야하는 데이터 포맷은 고정되어 있고 크기가 일정하다. 
  장점 : 전송하기 쉽다. XML은 데이터를 공유하고 전송하는 표준모델이다.
        따라서 대부분 프로그래밍 언어에는 XML을 관리하는 라이브러리가 존재한다
 단점 : 클라이언트에게 모든 자료를 보내야함으로 비효율적이다.
*/