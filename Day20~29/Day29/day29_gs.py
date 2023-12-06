# 최적화 방법론 1 : BUD를 찾아라

# 병목현상(Bottlenecks)
# 불필요한 작업(Unnecessary Work)
# 중복되는 작업(Duplicated Work)

# 어떤 부분에서 알고리즘이 느려지는가?
# 예 : 배열을 정렬한 뒤 특정 속성을 갖는 원소를 찾는 알고리즘
# 첫 번째 단계에서, O(NlogN)이 소요되고 두 번째 단계에서 O(N)이 소요된다
# 두 번째 단계를 O(logN)이나 O(1)로 낮추는 건 소용이 없다.
# 병목점은 첫번째 단계이기 때문이다. 

# 어떤 부분이 불필요한 작업인가?
# 예 : A^3 + B^3 = C^3 + D^3 을 만족하는 모든 자연수를 출력하라
# 이 문제에서 모든 가능한 값을 D에 대입하는 과정은 불필요하다.
# 왜냐하면 가능한 D의 값은 한 가지만 남기 떄문이다.

# 어떤 부분이 중복되는 작업인가?
# 위 문제는 근본적으로 (A, B) 쌍에 대해 만족하는 (C, D)를 찾는 것이다
# 가능한 (C,D) 리스트를 미리 만든 뒤 대응되는 (C, D)를 찾으면 된다
# 이 경우 해시테이블을 이용하면 쉽게 사용할 수 있다


############문제##################
# n개의 노드가 있는 그래프가 있습니다. 각 노드는 1부터 n까지 번호가 적혀있습니다. 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하려고 합니다. 가장 멀리 떨어진 노드란 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드들을 의미합니다.

# 노드의 개수 n, 간선에 대한 정보가 담긴 2차원 배열 vertex가 매개변수로 주어질 때, 1번 노드로부터 가장 멀리 떨어진 노드가 몇 개인지를 return 하도록 solution 함수를 작성해주세요.

# 제한사항
# 노드의 개수 n은 2 이상 20,000 이하입니다.
# 간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
# vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.

from collections import deque

def solution(n, edge):
    
    # vertex 돌면서 index값 따라서 이동 가능한 범위 두고
    # visited 만들어서 이미 방문하면 다시 안 들리도록
    
    visited = [0] * (n+1)
    graph = [[] for _ in range(n+1)]
    
    for start, end in edge :
        graph[start].append(end)
        graph[end].append(start)
        
    def bfs(x) :
        visited[x] = 1
        q = deque([x])

        while q :
            tmp = q.popleft()

            for line in graph[tmp] :
                if not visited[line] :
                    visited[line] = visited[tmp] + 1
                    q.append(line)

                    
    bfs(1)
    
    res = visited.count(max(visited))
    
    return res
            
            
            
            
            
            