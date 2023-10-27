# 클린코드 4일차

## 3장 함수 (2)

(5) 함수 인수

최선은 파라미터 개수가 0개, 차선은 1개

1. 파라미터 0개

- includeSetupPageInto(new PageContent)보다 includeSetupPageInto()가 훨씬 이해하기 쉽다

2. 파라미터 1개

- 아래 예시처럼 함수명과 파라미터명을 **함께** 봤을 때 이해하기 쉽게 만들면 좋다
- boolean fileExists("MyFile")
  - MyFile이 존재하는지 체크하는 함수
- InputStream fileOpen("MyFile")
  - MyFile을 open해서 InputStream으로 return하는 함수
- passwordAttemptFailedNtimes(int attempts)
  - 패스워드 입력했지만 N번째 실패했다는 함수

3. 플래그 파라미터

- **절대 파라미터로 boolean값(true/false)을 사용하지 마**
  - 1가지만을 해야 하는 함수가 여러가지를 하도록 공표하는 셈이다
  - 이럴 거면 차라리 true/false 값에 따라 함수를 나누는 것이 좋다

4. 파라미터 2개

- writeField(name)이 writeField(outputStream, name)보다 이해하기 쉽다
- assertEquals(expected, actual) &rightarrow; assertExpectedEqualsActual(expected, actual) 형태가 훨씬 좋다. 파라미터의 순서가 헷갈리지 않게끔

5. 파라미터 3개

- 권장 X
- 파라미터 일부를 묶어 독자적인 클래스 변수로 선언할 수 있다면 파라미터 개수를 줄일 수 있다

  ```java
  Circle makeCircle(double x, double y, double radius);

  // 위 double x와 double y를 Point라는 class 변수로 묶으면 아래와 같다
  Circle makeCircle(Point center, double radius);
  ```

(6) 부수 효과를 일으키지 마라!

checkPassword라는 함수 이름만 봐서는 패스워드만 체크할 것 같지만, 실은 세션 초기화까지 일어나게 된다. 이런 경우 세션을 초기화해도 되는 경우에만 해당 메서드를 호출할 수 있다는 단점이 존재한다.

- 따라서 함수명에 세션 초기화를 명시하든가 (checkPasswordAndInitializeSession)
- 함수가 1가지의 일만 하도록 쪼개는게 좋다

```java
public class UserValidator{
    private Cryptographer cryptographer;

    public boolean checkPassword(String userName, String password){
        User user = UserGateway.findByName(userName);
        if(user != user.NULL){
            String codedPhrase = user.getPhraseEncodedByPassword();
            String phrase = cryptographer.decrypt(codedPhrase, password);
            if("Valid Password".equals(phrase)){
                Session.initialize(); // 부수 효과를 일으키는 곳
                return true;
            }
        }
        return false;
    }
}
```

(7) Try/Catch 블록 뽑아내기

try/catch 블록은 그 자체로도 보기 추하지만, 정상 동작과 오류 처리 동작을 뒤섞기 때문에 별도 함수로 뽑아내는 것이 좋다. **예외(오류) 처리도 1가지 작업이다!**

try/catch 블록 추출 전

```java
try{
    deletePage(page);
    registry.deleteReference(page.name);
    configKeys.deleteKey(page.name.makeKey());
}catch (Exception e){
    logger.log(e.getMessage());
}
```

try/catch 블록 추출 후

- 오류를 처리하는 try/catch 블록에서 정상 동작하는 부분을 따로 함수로 뺐다.
- 그에 따라 정상 동작 함수에선 Exception을 던지고 있는 형태이다.

```java
// 오류 처리 함수
public void delete(Page page){
    try{
        deletePageAndAllReferences(page);
    }catch (Exception e){
        logError(e); // 심지어 로그를 찍는 역할도 따로 함수로 뺌
    }
}

// 정상 동작 함수
private void deletePageAndAllReferences(Page page) throws Exception{
    deletePage(page);
    registry.deleteReference(page.name);
    configKeys.deleteKey(page.name.makeKey());
}

private void logError(Exception e){
    logger.log(e.getMessage());
}
```
