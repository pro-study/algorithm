from functools import reduce

def gcd(a, b):
    if b == 0: return a
    else: return gcd(b, a % b)

def solution(n, m):
    # 최대공약수
    max_value = gcd(n, m)

    # 최소공배수
    min_value = max_value * reduce(lambda x, y: x * y, map(lambda x: x // max_value, [n, m]))

    return [max_value, min_value]