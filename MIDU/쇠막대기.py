def solution(arrangement):
    answer = 0
    stack = []
    
    for i,s in enumerate(arrangement):
        if s == '(':
            stack.append(s)
        else:
            if arrangement[i-1] == '(':
                answer += len(stack)-1
            else:
                answer += 1
            stack.pop()
                
    return answer