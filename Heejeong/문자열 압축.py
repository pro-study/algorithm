def solution(s):
    # result -> 문자열 압축 최소값. 문자열 길이로 초기화
    result = len(s)

    # cnt : 압축 단위
    for cnt in range(1, (len(s) + 1) // 2 + 1):
        stack = []

        # 압축 단위수 만큼 문자열 자르기
        s_list = [s[i:i + cnt] for i in range(0, len(s), cnt)]

        # 문자열의 개수 세기
        for element in s_list:
            if not stack:
                stack.append([element, 1])
            else:
                if element == stack[len(stack) - 1][0]:
                    stack[len(stack) - 1][1] += 1
                else:
                    stack.append([element, 1])

        # print(stack)
        # length = 문자열 압축 길이
        length = 0
        for i in range(len(stack)):
            if stack[i][1] == 1:
                length += len(stack[i][0])
            else:
                length += len(stack[i][0]) + len(str(stack[i][1]))
        if result > length: result = length

    return result