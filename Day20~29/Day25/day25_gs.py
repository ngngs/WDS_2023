# 01 배열과 문자열

# 해시테이블(hash table) : 효율적인 탐색을 위한 자료구조
 

# 해시테이블 구현하기 : (연결리스트 + 해시 코드 함수)
# 1. 키의 해시 코드 계산하기 (단, 키의 개수는 무한하지만 int의 개수는 유한하기 때문에 서로 다른 두 개의 키가 같은 해시코드를 가르킬 수 있음)
# 2. hash(key) % array_length와 같은 방식으로 해시 코드를 이용해 배열의 인덱스를 구한다
# 3. 배열의 각 인덱스에는 키와 값으로 이루어진 연결리스트가 존재한다. (충돌에 대비해 연결리스트를 사용해야한다)
#   - 충돌이란? 1) 서로 다른 두 개의 키가 같은 해시코드를 가리킴 2) 서로 다른 두 개의 해시 코드가 같은 인덱스를 가리킴

# 질문? 해시테이블은 어떻게 구현하나요
# 답 : 주어진 키로부터 해시코드를 계산하고, 해시코드를 이용해 인덱스를 계산, 그 다음 해당 키에 상응하는 값을 연결리스트에서 탐색

# 질문? 충돌이 자주 발생한다면?
# 답 : 최악의 경우 수행 시간은 O(N) 그러나 일반적으로 최소화하기 때문에 O(1)


##########################################################################################################
# # 문제 (https://school.programmers.co.kr/learn/courses/30/lessons/147354)
# 완호가 관리하는 어떤 데이터베이스의 한 테이블은 모두 정수 타입인 컬럼들로 이루어져 있습니다. 테이블은 2차원 행렬로 표현할 수 있으며 열은 컬럼을 나타내고, 행은 튜플을 나타냅니다.
# 첫 번째 컬럼은 기본키로서 모든 튜플에 대해 그 값이 중복되지 않도록 보장됩니다. 완호는 이 테이블에 대한 해시 함수를 다음과 같이 정의하였습니다.

# 해시 함수는 col, row_begin, row_end을 입력으로 받습니다.
# 테이블의 튜플을 col번째 컬럼의 값을 기준으로 오름차순 정렬을 하되, 만약 그 값이 동일하면 기본키인 첫 번째 컬럼의 값을 기준으로 내림차순 정렬합니다.
# 정렬된 데이터에서 S_i를 i 번째 행의 튜플에 대해 각 컬럼의 값을 i 로 나눈 나머지들의 합으로 정의합니다.
# row_begin ≤ i ≤ row_end 인 모든 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로서 반환합니다.
# 테이블의 데이터 data와 해시 함수에 대한 입력 col, row_begin, row_end이 주어졌을 때 테이블의 해시 값을 return 하도록 solution 함수를 완성해주세요.

def solution(genres, plays):
    
    
    # 장르별로 가장 많이 재생된 노래를 두 개씩
    # 1.속한 노래가 많이 재생된 장르 먼저
    # 2.장르 내에서는 많이 재생된 노래 먼저
    # 3.재생횟수가 같다면 고유번호가 낮은 거 먼저
    
    # 카운트랑, 인덱스 따로
    cnt_list = dict()
    idx_list = dict()
    ans = []
    
    for i in range(len(genres)) :
        if genres[i] not in idx_list :
            idx_list[genres[i]] = [[i, plays[i]]]
            cnt_list[genres[i]] = plays[i]
        else :
            idx_list[genres[i]].append([i, plays[i]])
            cnt_list[genres[i]] += plays[i]
            
    # 가장 큰 순서대로 뽑기
    len_list = []
    for key, value in cnt_list.items() :
        len_list.append([key, value])
    
    len_list = sorted(len_list, key = lambda x : -x[1])

    
    for genre in len_list :
        tmp = idx_list[genre[0]]
        tmp = sorted(tmp, key = lambda x : (-x[1], x[0]))
        if len(tmp) < 2 :
            ans.append(tmp[0][0])
        else :
            ans.extend([tmp[0][0], tmp[1][0]])

    return ans