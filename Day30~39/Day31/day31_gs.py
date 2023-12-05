# 보기 좋은 코드 이어서

# 문제
# n명의 권투선수가 권투 대회에 참여했고 각각 1번부터 n번까지 번호를 받았습니다. 권투 경기는 1대1 방식으로 진행이 되고, 만약 A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이깁니다. 심판은 주어진 경기 결과를 가지고 선수들의 순위를 매기려 합니다. 하지만 몇몇 경기 결과를 분실하여 정확하게 순위를 매길 수 없습니다.

# 선수의 수 n, 경기 결과를 담은 2차원 배열 results가 매개변수로 주어질 때 정확하게 순위를 매길 수 있는 선수의 수를 return 하도록 solution 함수를 작성해주세요.

# 제한사항
# 선수의 수는 1명 이상 100명 이하입니다.
# 경기 결과는 1개 이상 4,500개 이하입니다.
# results 배열 각 행 [A, B]는 A 선수가 B 선수를 이겼다는 의미입니다.
# 모든 경기 결과에는 모순이 없습니다.

from collections import deque
def solution(n, results):
    
    # 일방향 그래프를 만들어서 순위 체크
    
    win_graph = [[] for _ in range(n+1)]
    lose_graph = [[] for _ in range(n+1)]
    for winner, loser in results :
        win_graph[winner].append(loser)
        lose_graph[loser].append(winner)

    ans = 0
        
    # 이긴 사람 먼저, 진 사람 순회
    for i in range(1,n+1) :
        visited = [0] *(n+1)
        q = deque([i])
        # 내가 이긴 사람이 있다면
        while q :
            _win = q.popleft()
            for _lose in win_graph[_win] :
                if not visited[_lose] :
                    visited[_lose] = 1
                    q.append(_lose)

        dq = deque([i])
        # 내가 진 사람이 있다면
        while dq :
            _lose = dq.popleft()
            for _win in lose_graph[_lose] :
                if not visited[_win] :
                    visited[_win] = 1
                    dq.append(_win)
        

        # 다 돌고 cnt가 n-1이면 ans +1
        if visited.count(1) == n-1 :
            ans += 1
    

    return ans