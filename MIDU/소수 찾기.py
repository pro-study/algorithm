from itertools import permutations

def check_prime(num):
    if num == 0 or num == 1:
        return False
    for i in range(2, num//2 + 1):
        if num%i == 0:
            return False
    return True

def solution(numbers):
    answer = 0
    li = []
    
    for i in range(len(numbers)):
        li += permutations(list(numbers),i+1)
        
    li = list(set(map(lambda x: int(''.join(x)), li)))
    #print(li)
        
    for num in li:
        if check_prime(num):
            answer += 1
        
    return answer