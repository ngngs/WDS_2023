# 최소공배수(Lowest Common Multiple, LCM)
# 공배수(common multiple)란 두 수 이상의 여러 수의 공통된 배수를 의미
# 최소공배수(LCM)란 두 수 이상의 여러 수의 공배수 중 최소인 수를 가리킴

# 기본적인 방법
def lcm(a, b):
    for i in range(max(a, b), (a * b) + 1):
        if i % a == 0 and i % b == 0:
            return i
        
# 최대공약수 활용
def gcd(a, b):  # 최대공약수
    while b > 0:
        a, b = b, a % b
    return a


def lcm(a, b):
    return a * b / gcd(a, b)

########### 문제 ##########
# 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. 
# n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.

def solution(arr):
    if arr :
        val1 = arr.pop()

    while arr :
        val2 = arr.pop()
        val1 = lcm(val1, val2)

    return val1

print(solution([2,6,8,14]))