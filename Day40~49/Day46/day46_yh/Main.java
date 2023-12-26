package study.my.java.whiteship.effective_java.chapter01.item01.lecture10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        
        // 1. 문자열로 클래스의 정보를 참조하기
        Class<?> aClass = Class.forName("study.my.java.whiteship.effective_java.chapter01.item01.lecture10.ReflectionTest");
        
        // 2. 참조한 클래스로부터 인스턴스 만들기
        // 2-1. 클래스로부터 곧바로 newInstance() 하는 건 deprecated 됐다. (다른 방법으로 Class의 인스턴스를 얻는 걸 권장)
        Constructor<?> constructor = aClass.getConstructor();

        // 2-2. 이처럼 생성자로부터 newInstance() 하여 인스턴스를 얻는 것이 권장 방법이다.
        ReflectionTest reflectionTest = (ReflectionTest)constructor.newInstance();

        // ex) 인스턴스 메서드 실행
        reflectionTest.method1();

        // 아니면 클래스로부터 직접 field/constructor/method/annotation의 정보를 얻는 방법도 있다.
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor();
        Method[] declaredMethods = aClass.getDeclaredMethods();

        // 이런 식으로 "클래스 읽기/인스턴스 만들기/메서드 실행/필드 값 가져오기 및 변경" 등이 가능하며
        // 심지어 private 필드, 메서드도 접근할 수 있다. (즉, 접근 지시자를 무시하는 것도 가능)

        // 더 자세한 내용은 '더 자바, 코드를 조작하는 방법' 강의를 참조하길 바란다.
    }
}
