# 04 트리와 그래프(이어서)

# 그래프 탐색(BFS, DFS)
# 1. 깊이 우선탐색 : 루트 노드에서 시작해 다음 분기로 넘어가기 전에 해당 분기를 완벽하게 탐색
# 2. 너비 우선탐색 : 루트 노드에서 시작해 인접한 노드를 먼저 탐색

# 언제쓰는게 좋을까요?
# 모든 노드를 방문하고자 할 때 : DFS
# 최단 루트를 찾고자 할 때 : BFS

################# 문제 #######################
# https://school.programmers.co.kr/learn/courses/30/lessons/43163
# 두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.

# 1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
# 2. words에 있는 단어로만 변환할 수 있습니다.
# 예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면 "hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.

# 두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.

# 제한사항
# 각 단어는 알파벳 소문자로만 이루어져 있습니다.
# 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
# words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
# begin과 target은 같지 않습니다.
# 변환할 수 없는 경우에는 0를 return 합니다.

from collections import deque

def solution(begin, target, words):
    
    if target not in words :
        return 0
    
    words.append(begin)
    
    visited = [0] * len(words)
    connection = [[] for _ in range(len(words))]
    for i in range(len(words)-1) :
        for j in range(i+1, len(words)) :
            cnt = 0
            for k in range(len(begin)) :
                if words[i][k] == words[j][k] :
                    cnt += 1
            if cnt >= len(begin)-1 :
                connection[i].append(words[j])
                connection[j].append(words[i])
    
    def bfs(word) :
        q = deque()
        q.append(word)
        while q :
            start = q.popleft()
            for end in connection[words.index(start)] :
                print(start, end, "########")
                
                if end != words[-1] and visited[words.index(end)] == 0 :
                    q.append(end)
                    visited[words.index(end)] = visited[words.index(start)] + 1
                    print(start, end, visited)
    
    bfs(words[-1])
    return visited[words.index(target)]

                
print(solution("hit", "cog", ["hot", "dot", "dog", "lot", "log", "cog"]))