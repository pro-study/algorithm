def getRoundNumber(num):
    return (num+1)//2

def solution(n,a,b):
    answer = 0

    while n != 1:
        n /= 2
        a, b = getRoundNumber(a), getRoundNumber(b)
        answer += 1
        if a == b: break

    return answer