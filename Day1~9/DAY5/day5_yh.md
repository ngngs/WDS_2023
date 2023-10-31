# 클린코드 5일차

## 4장 주석 (1)

> 나쁜 코드에 주석을 달지 마라. 새로 짜라.
> - 브라이언 W> 커니핸, P.J. 플라우거

### 느낀 점
부끄럽게도 이 책을 읽기 전까지는 주석을 남기는 게 무조건 좋은 줄 알았다. 
그래서 주석으로 해당 코드에 대한 설명을 최대한 많이 남기려고 했고, 그게 옳은 건 줄 알았다. 
그러나 3장 함수와 4장 주석을 읽으면서 깨달은 점은 <u>코드 >> 주석</u> 이라는 점이다. 

주석으로 장황하게 코드 설명을 적을 시간에 
- (1) 변수명과 함수명을 더 이해하기 쉽게 바꾸고
- (2) 함수를 쪼개고 (너무 길어지지 않게) 
- (3) parameter와 return 값의 의미를 분명하게  

하는 것이 훨씬 좋다는 걸 깨달았다. <br/> 
앞으로는 주석을 <u>정말 필요할 때 1번</u>이라는 마음가짐으로 달아야겠다.

### 주석에 대한 저자의 관점 요약

- 주석은 필요악이다.
- 코드로 의도를 제대로 표현할 능력만 있다면 주석은 거의 필요하지 않다.
- 내가 이렇게 주석을 무시하는 이유는 프로그래머들이 주석을 유지보수하기란 현실적으로 불가능하기 때문.
- 부정확한 주석은 아예 없는 주석보다 훨씬 더 나쁘다.

### 본문 내용

(1) 주석은 나쁜 코드를 보완하지 못한다

나쁜 코드에 주석을 달 시간에 차라리 코드를 새로 짜든가 보완하라.
보통 주석을 다는 이유는 코드 퀄리티가 떨어지기 때문이다. 

(2) 코드로 의도를 표현하라

많은 경우 주석으로 설명을 하는 대신에 **함수로 표현(ex.서술적인 함수명)** 해도 충분하다.

```java
// 변경 전
// 직원에게 복지 혜택을 받을 자격이 있는지 검사한다.
if((employee.flags && HOURLY_FLAG) && (employee.age > 65))
    
// 변경 후    
if(employee.isEligibleForFullBenefits())
```

(3) 좋은 주석

나름 좋다고 생각하는 주석을 소개하겠다. 하지만 주석을 최대한 달지 않는 게 가장 좋다는 걸 명심하자.

1. 법적인 주석

2. 정보를 제공하는 주석
- 정규표현식이 시각과 날짜를 뜻한다고 설명하는 주석이다. 확실히 도움이 된다.
- **물론 아예 DateUtil과 같은 class를 만들어 따로 빼는 게 주석을 다는 것보다 훨씬 좋긴 하다.**

    ```java
    // kk:mm:ss EEE, MMM dd, yyyy 형식이다.
    Pattern timeMatcher = Pattern.compile("\\d*:\\d*:\\d* \\w*, \\w* \\d*, \\d*");
    ```
3. 의도를 설명하는 주석
- 이렇게 코드를 짠 프로그래머의 의도를 표현하는 주석도 좋다.
    ```java
    public int compareTo(Object o){
        if(o instanceof WikiPagePath){
            WikiPagePath p = (WikiPagePath)o;
            String compressedName = StringUtil.join(names, "");
            String compressedArgumentName = StringUtil.join(p.names, "");
            return compressedName.compareTo(compressedArgumentName);
        }
        return 1; // 옳은 유형이므로 정렬 순위가 더 높다.
    }
    ```

4. 의미를 명료하게 밝히는 주석
- 애매모호한 파라미터나 리턴값에 대한 의미를 밝혀주는 것도 좋다. 
  - 예를 들어, a.compareTo(b) 에서 파라미터인 a, b에 대한 설명도 없고 리턴값인 -1, 0, +1 도 의미가 불분명하므로 이럴 땐 주석을 달아주면 좋다.

    ```java
    assertTrue(a.compareTo(a) == 0);    // a == a
    assertTrue(a.compareTo(b) != 0);    // a != b
    assertTrue(a.compareTo(b) == -1);   // a < b 
    assertTrue(a.compareTo(b) == 1);    // a > b 
    ```

- 물론 파라미터와 리턴값에 대한 의미를 분명하게 하여 함수를 설계하는 것이 가장 좋은 방법이다.
- 그러나 compareTo 처럼 표준 라이브러리나 변경하지 못하는 코드에 속한다면 위처럼 의미를 명료하게 밝히는 주석이 유용하다. 

5. 결과를 경고하는 주석

6. TODO 주석

7. 중요성을 강조하는 주석

- 아래 예시처럼 중요성을 강조하는 주석도 좋은 주석이다.

```java
String listItemContent = match.group(3).trim();
// 여기서 trim은 정말 중요하다. trim 함수는 문자열에서 시작 공백을 제거한다.
// 문자열에 시작 공백이 있으면 다른 문자열로 인식되기 때문이다. 

new ListItemWidget(this, listItemContent, this.level + 1);
return buildList(text.substring(match.end()));
```

8. Open API에서 Javadocs

- Javadocs도 좋은 주석이다. API에 대한 설명을 할 때 아주 유용하다.
- 그러나 모든 함수에 Javadocs를 다는 행동은 좋지 않다. 꼭 설명이 필요한 경우에만 달도록 하자.
