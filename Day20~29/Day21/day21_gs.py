# 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

# 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중 가장 큰 수는 6210입니다.

# 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.

def solution(num) :
    ans = ''
    numb = [str(tmp) for tmp in num]
    numb = sorted(num, key = lambda x : x * 3, reverse=True)

    ans = "".join(numb)

    return ans if int(ans) != 0 else "0"


# 이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
from heapq import *

def solution(operations):

    heap = []    
    for operation in operations :
        command, value = operation.split(" ")[0], int(operation.split(" ")[1])
        if command == "I" :
            heappush(heap, value)
        else :
            if heap :
                if value == -1 :
                    heappop(heap)
                else :
                    heap = nlargest(len(heap), heap)[1:]
                    heapify(heap)

    if heap :
        _min, _max = heappop(heap), nlargest(1, heap)[0]
        ans = [_max, _min]
    else :
        ans = [0, 0]

    return ans
