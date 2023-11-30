# 04 트리와 그래프

# 트리 : 트리는 도르오 이루어진 자료구조

# 트리는 결국 '재귀' 다
# 1. 트리는 하나의 루트 노드를 갖는다
# 2. 루트 노드는 0개 이상의 자식 노드를 갖는다
# 3. 자식 노드 또한 0개 이상의 자식 노드를 갖고 이는 반복된다

# 트라이 (접두사 트리) : n차 트리의 변종으로, 각 노드에 문자를 저장하는 자료구조
# 트라이 트리를 아래쪽으로 순회하면 단어가 하나 나온다
# 트라이에서 널 노드는(null node)라고 불리는 "*노드"는 단어의 끝을 나타낸다

############문제#############################
# https://school.programmers.co.kr/learn/courses/30/lessons/17685
# 포털 다음에서 검색어 자동완성 기능을 넣고 싶은 라이언은 한 번 입력된 문자열을 학습해서 다음 입력 때 활용하고 싶어 졌다. 예를 들어, go 가 한 번 입력되었다면, 다음 사용자는 g 만 입력해도 go를 추천해주므로 o를 입력할 필요가 없어진다! 단, 학습에 사용된 단어들 중 앞부분이 같은 경우에는 어쩔 수 없이 다른 문자가 나올 때까지 입력을 해야 한다.
# 효과가 얼마나 좋을지 알고 싶은 라이언은 학습된 단어들을 찾을 때 몇 글자를 입력해야 하는지 궁금해졌다.

# 예를 들어, 학습된 단어들이 아래와 같을 때
# go
# gone
# guild
# go를 찾을 때 go를 모두 입력해야 한다.
# gone을 찾을 때 gon 까지 입력해야 한다. (gon이 입력되기 전까지는 go 인지 gone인지 확신할 수 없다.)
# guild를 찾을 때는 gu 까지만 입력하면 guild가 완성된다.
# 이 경우 총 입력해야 할 문자의 수는 7이다.

# 라이언을 도와 위와 같이 문자열이 입력으로 주어지면 학습을 시킨 후, 학습된 단어들을 순서대로 찾을 때 몇 개의 문자를 입력하면 되는지 계산하는 프로그램을 만들어보자.

def make_trie(words):
    dic = {}
    for word in words:
        current_dict = dic
        for letter in word:
            current_dict.setdefault(letter, [0, {}])
            current_dict[letter][0] +=1              
            current_dict = current_dict[letter][1]
            
    return dic

def solution(words):
    answer = 0
    trie = make_trie(words)
    for word in words:
        temp = trie
        for letter in word:
            answer += 1
            temp = temp[letter]
            if temp[0] == 1:
                break
            else:
                temp = temp[1]
    
    return answer

print(solution(["go","gone","guild"]))