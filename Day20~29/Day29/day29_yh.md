# 클린코드 29일차

## 16장 SerialDate 리팩토링 (2)

### 이어서

DayDate(SerialDate 리팩토링 클래스 이름) 클래스에 한 작업을 정리해보자.

1. 필요한 주석만 남기고, 나머지는 삭제(ex. 이력 주석)
2. enum을 독자적인 소스 파일로 옮김
```java
public enum WeekInMonth{
    FIRST(1), SECOND(2), THIRD(3), FOURTH(4), LAST(0);
    
    public final int index;
    
    WeekInMonth(int index){
        this.index = index;
    }
}
```
3. 정적 변수(dateFormatSymbols)와 정적 메서드(getMonthNames, isLeapYear, lastDayOfMonth)를 DateUtil 이라는 새 클래스로 옮김
4. 일부 추상 메서드를 DayDate 클래스로 끌어올림
5. 숫자 1 대신 Month.JANUARY.toInt(), Day.SUNDAY.toInt()로 변경
