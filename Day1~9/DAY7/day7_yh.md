# 클린코드 7일차

## 4장 주석 (2)

(4) 나쁜 주석

1. 주절거리는 주석
2. 같은 이야기를 중복하는 주석
3. 오해할 여지가 있는 주석
4. 의무적으로 다는 주석

- Javadocs 부분에서 이미 한 번 언급하긴 했지만.. 모든 함수에 Javadocs 주석을 달 필요는 없다.
- **충분히 이해가 가능하게끔 변수명과 함수명을 설계했으므로 굳이 주석이 필요 없다.**  

    ```java
    /**
     * 
     * @param title CD 제목
     * @param author CD 저자
     * @param tracks CD 트랙 숫자
     * @param durationInMinutes CD 길이(단위: 분)
     */
    public void addCD(String title, String author, int tracks, int durationInMinutes){
        CD cd = new CD();
        cd.title = title;
        cd.author = author;
        cd.tracks = tracks;
        cd.duration = cd.durationInMinutes;
        cdList.add(cd);
    }
    ```

5. 이력을 기록하는 주석

- 과거와 달리 이제는 git 등 형상 관리 시스템이 있으므로 더이상 이력을 기록하는 주석이 필요 없다.

6. 있으나 마나 한 주석

- 너무 당연한 사실을 주석으로도 달지 마라. 

    ```java
  // 기본 생성자임을 모르는 개발자는 없을 것이다..
  
    /**
     * 기본 생성자
     */
    protected AnnualDateRule(){
        
    }
    ```

7. 무서운 잡음

8. 함수나 변수로 표현할 수 있다면 주석을 달지 마라

9. 위치를 표시하는 주석

- 반드시 필요할 때만 사용하도록 하자.

    ```java
    // ~~을 위한 코드 시작
    
    ...
    
    // ~~을 위한 코드 끝
    ```

10. 닫는 괄호에 다는 주석

- 이러한 주석을 달고 싶다는 생각이 들면 차라리 함수를 쪼개라. 함수가 장황하고 길다는 뜻이다.

    ```java
    if(){
        
        ...
            
    } // if end
    ```

11. 공로를 돌리거나 저자를 표시하는 주석

12. 주석으로 처리한 코드

- 주석으로 처리된 코드는 다른 사람들이 지우기를 주저한다. 
- 그러다 점차 쌓여서 나쁜 코드가 되어간다. 필요 없다면 주석 처리하지 말고 꼭 지우자.

```java
response.setBody(formatter.getResultStream(), formatter.getByteCount());
// InputStream resultsStream = formatter.getResultStream(); // 이렇게 남기지 말고 미리 미리 지우자.
// StreamReader reader = new StreamReader(resultStream);
```

13. HTML 주석

14. 전역 정보

15. 너무 많은 정보

16. 모호한 관계

17. 함수 헤더

18. 비공개 코드에서 Javadocs

(5) 예제
- 예제를 통해 어떤 주석을 없애면 좋을지 직접 테스트 해보자.
- 책 90 ~ 94
