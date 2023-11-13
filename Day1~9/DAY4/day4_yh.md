# 클린코드 4일차

## 3장 함수 (1)

함수란?

**어떤 프로그램이든 가장 기본적인 단위가 함수다. 함수는 그 언어에서 동사이며, 클래스는 명사다.**

함수를 잘 만드는 여러가지 규칙

(1) 작게 만들어라! (4~5줄)

- 블록과 들여쓰기
  - if문, else문, while문 등에 들어가는 블록은 1줄인 게 좋다.

if문 { } 블록 안에 여러 줄이 있는 것보단

```java
public static String renderPageWithSetupAndTeardonws(PageData pageData, boolean isSuite) throws Exception{
    boolean isTestPage = pageData.hasAttribute("Test");
    if(isTestPage){
        WikiPage testPage = pageData.getWikiPage();
        StringBuffer newPageContent = new StringBuffer();
        includeSetupPages(testPage, newPageContent, isSuite);
        newPageContent.append(pageData.getContent());
        includeTeardownPages(testPage, newPageContent, isSuite);
        pageData.setContent(newPageContent.toString());
    }
    return pageData.getHtml();
}
```

이렇게 1줄로만 구성된 게 좋으며, 이를 위해 또 하나의 함수를 새로 생성해주는 것이 좋다.

```java
public static String renderPageWithSetupAndTeardonws(PageData pageData, boolean isSuite) throws Exception{
    if(isTestPage(pageData)){
        includeSetupAndTeardownPages(pageData, isSuite);
    }
    return pageData.getHtml();
}
```

(2) 1가지만 해라!

- 함수는 1가지를 해야 한다. 그 1가지를 잘해야 한다. 그 1가지만을 해야 한다.
- 함수가 '1가지'만 하는지 판단하는 또다른 방법
  - 단순히 다른 표현이 아니라 의미 있는 이름으로 다른 함수를 추출할 수 있다면 그 함수는 여러 작업을 하는 것

(3) 함수당 추상화 수준은 하나로!

(4) 서술적인 이름을 사용하라!

- 함수의 역할을 쉽게 알 수 있게 서술적인 이름 사용
  - testableHtml &rightarrow; SetupTeardownIncluder
  - isTestable, includeSetupAndTeardownPages 등
- 서술적인 이름을 사용하는 게 주석을 길게 다는 것보다 훨씬 낫다
- 동일 모듈 내에선 이름을 일관성 있게 짓자

  - includeSetupAndTeardownPages
  - includeSetupPages
  - includeSuiteSetupPage
