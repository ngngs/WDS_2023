# 03 스택과 큐

# 스택(stack) : LIFO(Last In First Out)에 따라 자료를 배열한다
# 스택이 유용한 경우는 재귀 알고리즘을 사용할 때
# 임시 데이터를 스택에 넣고, 재귀 함수를 빠져나와 백트래킹을 할 때는 스택에 넣어둔 임시 데이터를 빼줘야한다

# 큐(Queue) : FIFO 순서를 따른다.
# 큐는 너비 우선 탐색(BFS)을 하거나 캐시를 구현하는 경우에 사용
# 노드를 접근한 순서대로 처리하고 싶다면 사용한다

############################### 문제 ###################################
# https://school.programmers.co.kr/learn/courses/30/lessons/42583
# 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 합니다. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다. 다리에는 트럭이 최대 bridge_length대 올라갈 수 있으며, 다리는 weight 이하까지의 무게를 견딜 수 있습니다. 단, 다리에 완전히 오르지 않은 트럭의 무게는 무시합니다.

# 예를 들어, 트럭 2대가 올라갈 수 있고 무게를 10kg까지 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.
# 따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

# solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

def solution(length, threshold, trucks):
    answer = 0
    bridge = [0]*length
    curWeight = 0
    trucks = trucks[::-1]
    while trucks:
        answer += 1
        curWeight -= bridge.pop(0)
        w = trucks.pop() if curWeight + trucks[-1] <= threshold else 0
        curWeight += w
        bridge.append(w)

    return answer + len(bridge)

print(solution(2, 10, [7, 4, 5, 6]))