// 03 스택과 큐

// 스택이 유용한 경우는 '재귀 알고리즘'을 사용할 때다
// 임시 데이터를 스택에 넣어주고 재귀함수를 빠져나와 백트랙킹을 할 때 스택에 넣은 임시 데이터를 빼준다.

// 문제 1. 스택 MIN
// 기본적인 push와 pop 기능이 구현된 스택에서 최솟값을 반환하는 min 함수를 추가하려고 한다. 어떻게 설계할 것인가?
// push, pop, min 연산은 모두 O(1) 시간에 수행되어야한다.

// 나의 답
// push와 pop의 연산을 O(1)로 고려하지 않는다면, 값을 넣을 때마다 비교를 통해 가장 낮은 값을 스택의 끝으로 위치시킬 수 있다.
// 하지만 이 방법은 최악의 경우 push에서 O(N)이 사용되기 때문에 어렵다.

// 정답
// 스택의 각 상태마다 최솟값을 함께 기록하면 된다.
// 스택의 최상위 노드만을 보고 최솟값을 알 수 있다.
// 원소를 스택에 쌓을 때, 현재 값과 자신보다 아래 위치한 원소들 중의 최솟값 중에서 더 작은 값을 최솟값으로 기록
public class StackWithMin extends Stack {
    public void push(int value){
        int newMin = Math.min(value, min());
        super.push(new NodeWithMin(value, newMin));
    }

    public int min(){
        if (this.isEmpty()){
            return Integer.MAX_VALUE;
        } else {
            return peek().min;
        }
    }
}

// 하지만, 이 경우 각 원소마다 min을 기록하기 때문에 공간이 낭비됨