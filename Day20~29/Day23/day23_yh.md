# 클린코드 23일차

## 14장 점진적인 개선 (3)

pp.278~293

### 이어서 

#### 점진적으로 개선하다

1. isxxxArg 메서드를 별도로 선언할 이유가 없어져 인라인 코드로 만듦. 
```java
private boolean isIntArg(ArgumentMarshaler m){
    return m instanceof IntegerArgumentMarshaler;
}

private boolean isStringArg(ArgumentMarshaler m){
        return m instanceof StringArgumentMarshaler;
}
```

즉, 위 코드 대신에 아래 코드처럼 인라인 코드로 대체
```java
private boolean setArgument(char argChar) throws ArgsException{
    ArgumentMarshaler m = marshalers.get(argChar);
    if(m instanceof BooleanArgumentMarshaler){
        setBooleanArg(argChar);
    }else if(m instanceof StringArgumentMarshaler){
        setStringArg(argChar);
    }else if(m instanceof IntegerArgumentMarshaler){
        setIntArg(argChar);
    }else{
        return false;
    }
    
    return true;
}
```

2. 위와 같이 코드를 일부 변경했더라도 항상 테스트를 먼저 해보고, 그 다음 리팩토링을 이어서 해야 한다.


3. String과 Integer도 똑같이 변경
