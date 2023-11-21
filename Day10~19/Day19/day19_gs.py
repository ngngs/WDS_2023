# Pythonic Code
# 1. 가변인자
_list = [1, 2, 3, 4, 5]
first_index, *rest, last_index = _list
print(rest)

# 2. Unpacking
_list = [1, 2, 3, 4 ,5]
print(*_list)

# 3. List Comprehension
# 1) 기본형 리스트
_list = [i for i in range(10)]
print(_list)
# 2) 지능형 리스트
print(*[1 if dt in _list else 0 for dt in _list], sep = '\n')
# 3) 지능형 리스트 예제
# 1~10을 담는 리스트
_list = [i for i in range(10)]
# 2, 4, 6, ..., 20을 담는 리스트
_list = [2 * i for i in range(10)]
# 주어진 리스트를 받아 3의 배수만 담는 리스트
import random
tmp = [random.randrange(1, 200) for i in range(100)]
_list = [i for i in tmp if i % 3 == 0]
print(_list)

# 4. Dictionary 잘 쓰기
# dictionary와 set은 hash table 구조를 띈다. 그래서 삽입, 삭제, 탐색 연산 시간복잡도는 O(1)
# list에서 in을 사용하지 않도록 주의
data = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
for i in range(100) : 
    if i in data :
        print(1)
    
# 이 경우 set를 사용한다
data = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
_data = set(data)
for i in range(100) :
    if i in _data :
        print(1)

# dictionary 만들기 기본형
fruit = ['apple', 'grape', 'orange', 'banana']
price = [3200, 15200, 9800, 5000]
_dict = {}
for i in range(len(price)) :
    _dict.append((fruit[i], price[i]))

# dictionary 만들기 zip
fruit = ['apple', 'grape', 'orange', 'banana']
price = [3200, 15200, 9800, 5000]

_dict = dict(zip(fruit, price))

print(*_dict.keys())
print(*_dict.values())
print(*_dict.items())

# dictionary key 값이 존재하는지 확인
car = {"name" : "BMW", "price" : "7000"}
if "name" in car :
    print( " done ")
else :
    print( " no ")
    