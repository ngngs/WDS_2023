# 클린코드 7일차

## 5장 형식 맞추기

### 나에게 필요한 부분 요약 정리

세로 밀집도 & 수직 거리
1. 변수 선언 : 변수는 사용하는 위치에 최대한 가까이 선언한다.
2. 인스턴스 변수 : 반면 인스턴스 변수는 클래스 맨 처음에 선언한다.
3. 종속 함수 : 서로 연관된 함수는 가까이 배치한다. **또한 가능하다면 호출하는 함수를 호출되는 함수보다 먼저 배치한다.**
4. 개념적 유사성 : 친화도가 높을수록 코드를 가까이 배치한다.

### 형식을 맞추는 목적

코드는 영원하지 않다. <br/>
오늘 구현한 기능은 다음 버전에서 바뀔 확률이 매우 높다. <br/>
그렇기에 코드의 <u>가독성</u>이 매우 중요하고, 이는 앞으로 바뀔 코드의 품질에 지대한 영향을 끼친다. 

### 형식을 맞추는 규칙

(1) 세로 형식

세로 길이는 500자를 넘지 않고 대부분 200줄 정도면 충분하다. (junit, fitnesse, testNG 프로젝트의 평균 길이)

1. 신문 기사처럼 작성하라
- 코드는 위에서 아래로 읽어간다. 따라서 신문 기사처럼 작성하면 좋다.
  - **첫 부분엔 고차원 개념과 알고리즘을 설명**
  - **아래로 내려갈수록 의도를 세세히 묘사**
  - **마지막엔 가장 저차원 함수와 세부 내역**

2. 개념은 빈 행으로 분리하라

- 너무 당연한 거지만 package, import, class 처럼 서로 다른 개념은 공백을 주어 분리해주면 가독성이 좋아진다.

```java
package fitnesse.wikitext.widgets;

import java.util.regex.*;

public class BoldWidget extends ParentWidget{
    
    public static final String REGEXP = ~~~;
    
    public BoldWidget(){
        
    }
}
```

3. 세로 밀집도 & 수직 거리
- 세로 밀집도는 연관성을 의미한다.
- **서로 밀접한 개념이라면 세로로 가까이 둬야 한다!**
- **서로 밀접한 개념이라면 한 파일에 속해야 마땅하다.** <u>이는 protected 변수를 피해야 하는 이유 중 하나다</u>
  
```java
변수 선언 : 변수는 사용하는 위치에 최대한 가까이 선언한다.

private static void readPreferences(){
    InputStream is = null; // 변수는 가까이 선언!
    try{
        is = new FileInputStream(getPreferencesFile());
        ...
    } catch (IOException e){
        ...
    }
}
```

```java
2. 인스턴스 변수 : 반면 인스턴스 변수는 클래스 맨 처음에 선언한다.

import java.util.Vector;

public class TestSuite implements Test {
    
    private static int count = 0;  // 클래스 변수 
    
    private String fName; // 인스턴스 변수
    
    private Vector<Test> fTests = new Vector<Test>(); // 인스턴스 변수
    
    // 메서드 부분
}
```


```java
3. 종속 함수 : 서로 연관된 함수는 가까이 배치한다. ★또한 가능하다면 호출하는 함수를 호출되는 함수보다 먼저 배치한다.★

public Response makeResponse(FitNesseContext context, Request request) throws Exception{
    String pageName = getPageNameOrDefault(request, "FrontPage"); // 1st
    loadPage(pageName, context); // 2nd
    if(page == null){
        return notFoundResponse(context, request); // 3rd
    }else{
        return makePageResponse(context); // 4th
    }
    
    // 1st
    private String getPageNameOrDefault(){
        
    }
    
    // 2nd
    protected void loadPage(){
        
    }
    
    // 3rd
    private Response notFoundResponse(){
        
    }
    
    // 4th
    private SimpleResponse makePageResponse(){
        
    }
}
```

```java
4. 개념적 유사성 : 친화도가 높을수록 코드를 가까이 배치한다.

static public void assertTrue(String message, boolean condition){
    
}

static public void assertTrue(boolean condition){

}

static public void assertFalse(String message, boolean condition){

}

static public void assertFalse(boolean condition){

}
```



(2) 가로 형식

한 행은 20자에서 60자 사이, 대략 45자 정도가 적당한 것 같다.

