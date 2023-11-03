// 트리와 그래프

// 트리(Tree)를 설명하기 가장 좋은 방법은 '재귀'다.
// 트리는 노드로 이루어진 자료구조이며, 다음과 같은 성격을 띤다.
// 1. 트리는 하나의 루트 노드를 갖는다
// 2. 루트 노드는 0개 이상의 자식 노드를 갖는다
// 3. 자식 노드 또한 0개 이상의 자식 노드를 갖고 이는 반복적 정의 된다.

// 이진 트리 : 각 노드가 최대 두개 자식
// 이진 탐색 트리 : 모든 왼쪽 자식들 <= n < 모든 오른쪽 자식들 속성을 갖는다
// 많은 사람들의 실수는 트리 문제가 주어지면 이진 탐색 트리라고 가정한다는 것이다.

// 1. 완전 이진트리 : 노드가 왼쪽에서 오른쪽으로 채워짐(꽉 찰 필요 없음)
// 2. 전 이진트리 : 모든 노드의 자식이 0개 or 2개
// 3. 포화 이진트리 : 모든 노드가 꽉 차 있음(perfect binary tree)


// 트라이(접두사 트리)
// 트라이는 n차 트리의 변종. 각 노드에 문자를 저장하는 자료구조.
// 트리를 아래쪽으로 순회하면 단어가 하나 나온다.
// 널 노드(null node)라고 불리는 '*노드'는 종종 단어의 끝
// (중요) 해시테이블을 이용하면 주어진 문자열이 유효한지 아닌 지 빠르게 확인할 수 있지만, 
// 그 문자열이 어떤 유효한 단어의 접두사인지 확인할 수 없다.