# 클린코드 22일차

## 14장 점진적인 개선 (2)

Boolean, String, Integer, Double 등 여러 타입을 다 받을 수 있는 코드 초안은 굉장히 지저분하다.
그러나 Boolean 인수만 지원하던 초기 버전은 이만큼 엉망이지 않았다.
지원되는 기능을 늘리다 보니 초기에 비해 코드 지저분해진 것이다.

### Args 초안 및 점진적 개선 과정

#### 1. Boolean만 지원하는 버전

비록 길긴 하지만 나름 괜찮은 코드이다.

```java
public class Args{
    private String schema;
    private String[] args;
    private boolean valid;
    private Set<Character> unexpectedArguments = new TreeSet<Character>();
    private Map<Character, Boolean> booleanArgs = new HashMap<Character, Boolean>();
    private int numberOfArguments = 0;
    
    public Args(String schema, String[] args){
        this.schema = schema;
        this.args = args;
        valid = parse();
    }
    
    public boolean isValid(){
        return valid;
    }
    
    private boolean parse(){
        if(schema.lenth() == 0 && args.length == 0){
            return true;
        }
        parseSchema();
        parseArgumetns();
        return unexpectedArguments.size() == 0;
    }
    
    private boolean parseSchema(){
        for(String element : schema.split(",")){
            parseSchemaElement(element);
        }
        return true;
    }
    
    private void parseSchemaElement(String element){
        if(element.length() == 1){
            parseBooleanSchemaElement(element);
        }
    }
    
    private void parseBooleanSchemaElement(String element){
        char c = element.charAt(0);
        if(Character.isLetter(c)){
            booleanArgs.put(c, false);
        }
    }
    
    private boolean parseArgumetns(){
        for(String arg : args){
            parseArgumetns(arg);
        }
        return true;
    }
    
    private void parseArgument(String arg){
        if(arg.startWith("-")){
            parseElements(arg);
        }
    }
    
    private void parseElements(String arg){
        for (int i=1; i<arg.length(); i++){
            parseElement(arg.charAt(i));
        }
    }
    
    private void parseElement(char argChar){
        if(isBoolean(argChar)){
            numberOfArguments++;
            setBooleanArg(argChar, true);
        }else{
            unexpectedArguments.add(argChar);
        }
    }
    
    private void setBooleanArg(char argChar, boolean value){
        booleanArgs.put(argChar, value);
    }
    
    private boolean isBoolean(char argChar){
        return booleanArgs.containsKey(argChar);
    }
    
    private int cardinality(){
        return numberOfArguments;
    }
    
    public String usage(){
        if(schema.length() > 0){
            return "-["+schema+"]";
        }else{
            return "";
        }
    }
    
    public String errorMessage(){
        if (unexpectedArguments.size() > 0) {
            return unexpectedArgumentMessage();
        }else{
            return "";
        }
    }
    
    private String unexpectedArgumentMessage(){
        StringBuffer message = new StringBuffer("Argument(s) -");
        for(char c : unexpectedArguments){
            message.append(c);
        }
        message.append(" unexpected.");
        
        return message.toString();
    }
    
    public boolean getBoolean(char arg){
        return booleanArgs.get(arg);
    }
    
}
```

#### 2. Boolean과 String
그러나 위 코드에 String 파라미터 유형 1개를 추가하기 시작하니 코드가 엉망이 되어가는 문제가 발생했다.

**그래서 Integer를 추가하기 전에 코드를 리팩토링하기로 결정했다!**
- 첫째, 인수(=파라미터) 유형에 해당하는 HashMap을 선택하기 위해 스키마 요소의 구문을 분석한다.
- 둘째, 명령행 인수에서 인수 유형을 분석해 진짜 유형으로 변환한다.
- 셋째, getXxx 메서드를 구현해 호출자에게 진짜 유형을 반환한다. 

**인수 유형은 다양하지만 모두가 유사한 메서드를 제공하므로 클래스 하나가 적합하다고 판단했고, <u>그리하여 ArgumentMarshaler라는 개념이 탄생**</u>했다. 

```java
책 264~269pg 참조
```

#### 3. 점진적으로 개선하다

프로그램을 망치는 가장 좋은 방법 중 하나는 개선이라는 명목 하에 구조를 크게 뒤집는 행위다. 그래서 TDD 기법을 사용하여 개선하는 것이 좋다.
