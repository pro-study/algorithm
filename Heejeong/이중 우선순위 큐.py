import heapq
def solution(operations):
    stack = []
    for oper in operations:
        command, data = oper.split(" ")
        if command == "I": heapq.heappush(stack, int(data))
        else:
            if not stack: continue
            elif data == "-1": heapq.heappop(stack)
            else: del stack[stack.index(max(stack))]

    if not stack: return [0,0]
    else: return [max(stack), min(stack)]

if __name__ == "__main__":
    test_case = [["I 7", "I 5", "I -5", "D -1"], ["I 16", "D 1"],
                 ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]]
    test_result = [[7,5], [0,0], [333, -45]]

    for i in range(len(test_case)):
        result = solution(test_case[i])
        print(result)
        if result == test_result[i]:
            print("맞았습니다!")
        else: print("틀렸습니다!")
