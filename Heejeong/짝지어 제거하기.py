def solution(s):
    answer = 0
    stack = []
    s = list(s[::-1])
    while s:
        element = s.pop()
        if not stack:
            stack.append(element)
        else:
            if stack[-1] == element:
                stack.pop()
            else:
                stack.append(element)

    if not stack: answer = 1
    return answer

if __name__ == "__main__":
    test_case = ["baabaa", "cdcd"]
    test_result = [1, 0]
    for i in range(len(test_case)):
        result = solution(test_case[i])
        print("#{} {}".format(i+1, result))
        if result == test_result[i]:
            print("맞았습니다!")
        else: print("틀렸습니다!")