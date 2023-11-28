# 클린코드 24일차

## 14장 점진적인 개선 (4)

pp.294~309

### 이어서

#### 점진적으로 개선하다

여전히 고칠 부분은 많다. 아까 바꾼 setIntArg, setStringArg, setBooleanArg를 해당 ArgumentMarshaler 파생 클래스로 내리는 것이 좋다.

그러나 이 과정에서 파라미터 2개(args, currentArgument)를 넘겨야 했다. **파라미터는 1개만 넘기는 편이 좋기 때문에** 이를 해결하는 과정을 진행한다!

이는 **args 배열을 list로 변환한 후 Iterator를 set 함수로 전달함으로써 해결**할 수 있고, 아래 코드는 그 결과이다.

```java
public class Args{
    private String[] args; // 삭제할 인스턴스 변수
    private Iterator<String> currentArgument; // 새로 추가한 인스턴스 변수 (1)
    private List<String> argsList; // 새로 추가한 인스턴스 변수 (2)
    
    public Args(String schema, String[] args) throws ParseException{
        this.schema = schema;
        argsList = Arrays.asList(args);
        valid = parse();
    }
    
    private boolean parse() throws ParseException{
        if(schema.length() == 0&& argsList.size() == 0){
            return true;
        }
        parseSchema();
        try{
            parseArguments();
        } catch (ArgsException e){
            
        }
        return valid;
    }
    // ...
    
    private boolean parseArguments() throws ArgsException{
        for(currentArgument = argsList.iterator(); currentArgument.hasNext();){
            String arg = currentArgument.next();
            parseArgument(arg);
        }
        return true;
    }
}
```
사실 setBooleanArg는 iterator가 필요 없다. 그런데도 iterator를 파라미터로 넘긴 이유는 
- (1) setIntArg, setStringArg에서 필요하기 때문이다.
- (2) 또한 3개 함수 모두 ArgumentMarshaler의 추상 메서드로 호출하기 위해서다. 

```java
private abstract class ArgumentMarshaler{
    public abstract void set(Iterator<String> currentArgument) throws ArgsExcetion; // 새로 추가한 추상 메서드
    // ...
}
```
