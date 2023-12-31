// 11. 테스팅

/*
* 소프트웨어 테스팅

두 가지 핵심은 수작업vs자동화, 블랙박스테스트vs화이트박스테스트

수작업 vs 자동화 : 일반적으로 모든 것이 자동화되면 좋겠지만 불가능하다. 예를 들어 해당 컨텐츠가 포르노와 연관이 있는지 판단하는 것은 정령화하기 어렵다
블랙박스 vs 화이트박스 : 주어진 소프트웨어를 그대로 테스트 할 것인지(블랙박스) vs 내부 개별 함수들을 프로그램적으로 접근할 것인지(화이트박스)

1단계 : 블랙박스 테스트를 할 것인가 화이트박스 테스트를 할 것인가
2단계 : 누가 사용할 것이며 왜 사용하는가?
        예) 부모가 웹 브라우저를 통제하는 소프트 웨어를 테스트한다면, 이 소프트웨어의 사용자는 부모(차단을 가하는 사용자)와 아이들(차단을 당하는 사용자)
3단계 : 어떤 유스케이스가 있는가?
        예) 부모의 유스케이스는 소프트웨어를 설치하고, 차단 기능을 활성화하거나 해제하고, 인터넷을 사용하는 행위
            아이의 유스케이스는 합법적 콘텐츠에 접근하고, 불법적 컨텐츠는 차단당한다
4단계 : 한계 조건은?
        예) 웹사이트를 차단하는 것은 정확히 무엇인가. 불법컨텐츠를 담고 있는 특정 페이지만 차단하는 것이낙, 아니면 전체 웹사이트를 차단하는 것인가
5단계 : 스트레스 조건과 장애 조건은?
6단계 : 테스트 케이스는? 테스트 실행은 어떻게?
*/


/*
 * 함수 테스팅 : 입력과 출력을 확인하는 테스트
 * 
 * 1단계 테스트 케이스 정의 : 정상적인케이스, 극단적인 케이스, null입력 또는 잘못된 입력, 특수한 입력
 * 2단계 예상되는 결과를 정의하고 테스트 코드를 작성
 */


// ============================================================================

// 문제. 구글 크롬에서 일하는 당신이, 실행하자마자 크롬 브라우저가 죽는다는 버그 리포트를 받았다.

// 1단계 시나리오를 구성한다. 
// 가능한 상황을 리스트업한다.

/*
 * 1. 사용자는 얼마나 오랫동안 이 문제를 겪었나?
 * 2. 브라우저 버전은? 운영체제 버전은?
 * 3. 항상 발생하는가? 발생 빈도는 어떤가? 언제 발생하는가?
 * 4. 오류 보고서가 표시되는가?
 */

 // 2단계 문제를 쪼갠다
 /*
  * 1. Window의 시작 메뉴로 간다
  * 2. 크롬 아이콘을 클릭
  * 3. 브라우저가 시작
  * 4. 브라우저가 설정을 읽는다
  * 5. 브라우저가 홈페이지에 HTTP 요청을 날린다
  * 6. 브라우저가 HTTP 응답을 받는다
  * 7. 웹 페이지를 파싱한다
  * 8. 웹 페이지를 화면에 표시한다.
  */

  // 3단계 구체적이고 관리 가능한 테스트를 생성한다
