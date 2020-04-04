# 이진수(bin_num) 문자열을 입력받아 1의 개수를 반환하는 함수
def countOne(bin_num):
    return str(bin(bin_num))[2:].count('1')

def solution(n):
    condition = countOne(n)
    while True:
        n += 1
        if countOne(n) == condition: break
    return n

if __name__ == "__main__":
    test_case = [78, 15]
    test_answer = [83, 23]

    for i in range(len(test_case)):
        answer = solution(test_case[i])
        print("#{} {}".format(i+1, answer))
        if answer == test_answer[i]: print("맞았습니다!")
        else: print("틀렸습니다!")