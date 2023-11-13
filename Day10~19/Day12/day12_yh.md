# 클린코드 12일차

## 9장 단위 테스트 (1)

### 개요

1997년만 해도 TDD(Test Driven Development)라는 개념을 아무도 몰랐다. <br/>
그 당시의 단위 테스트란 자기 프로그램이 '돌아간다'는 사실만 확인하는 일회성 코드에 불과했다.

애자일과 TDD 덕택에 단위 테스트를 자동화하는 프로그래머들이 이미 많아졌고 더 늘어나는 추세다. <br/>
하지만 <u>급하게 테스트를 추가해야 한다는 점 때문에</u> **제대로 된 테스트 케이스를 작성해야 한다는 중요한 사실을 놓치고 있다.**

### TDD 법칙 3가지

1. 실패하는 단위 테스트를 작성할 때까지 실제 코드를 작성하지 않는다.
2. 컴파일은 실패하지 않으면서 실행이 실패하는 정도로만 단위 테스트를 작성한다.
3. 현재 실패하는 테스트를 통과할 정도로만 실제 코드를 작성한다.

### 깨끗한 테스트 코드 유지하기
> 요약 : 실제 코드뿐만 아니라 테스트 코드도 clean code 해야 한다!

테스트 코드를 깨끗하게 유지(clean code)해야 하는 이유는 단순하다. <br/>
clean code하지 않으면 결국 유지보수가 힘들어지고, 결국 테스트 코드를 잃게 된다. <br/>
테스트 케이스가 없으면 코드를 변경하기 두려워진다. 모든 변경이 잠정적인 버그이기 때문이다. <br/>
테스트 코드가 dirty해지면 실제 코드도 dirty해진다. <br/>
결국 테스트 코드를 잃어 버리게 되고 실제 코드도 망가지게 된다.

### 깨끗한 테스트 코드 예시

실제로 테스트 코드를 많이 짤 일이 있을 때 이 부분을 다시 보도록 하자... (책 158~164p)