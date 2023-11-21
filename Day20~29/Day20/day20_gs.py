# sorting
# sort() 메소드, sorted() 함수

# 1. 내림차순 정렬
_list = [5, 6, 4, 8, 2, 3]
sorted_list = sorted(_list, reverse = True)

# 2. lambda를 활용한 정렬
_list = [(1,3), (8,2), (2,5), (4,7)]
sorted_list = sorted(_list, key = lambda x : (x[1], x[0]))

# 3. 문자열은 대소관계를 비교, 다음과 같이 모두 소문자로 바꾸기
_list = ["CHicken", "hamburger", "Sushi", "chocolate"]
print(sorted(_list, key = lambda x : x.lower()))

# 4. 문자열
print('===chickend==='.strip('='))
string = 'I am Hungry...'
print(string[::-1])

# 5. combination/permutation
import itertools
_list = [1, 2, 3, 4]
iter = itertools.combinations(_list, 2)

# 6. join 사용하기
_list = ["1", "2", "3"]
print(', '.join(_list))

# 7. 입출력
def solution(seoul) :
    tmp = seoul.index("Kim")
    answer = f"김서방은 {tmp}에 있다"
    return answer


