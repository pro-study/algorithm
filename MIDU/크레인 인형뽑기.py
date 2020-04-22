def solution(board, moves):
    answer = 0
    N = len(board)
    board_stack = [[] for _ in range(N)]
    box = []
    
    for e in board[::-1]:
        for i in range(N):
            if e[i] != 0:
                board_stack[i].append(e[i])
    
    for move in moves:
        if board_stack[move-1]:
            now = board_stack[move-1].pop()
            if box and box[-1] == now:
                answer += 2
                box.pop()
            else:
                box.append(now)
    
    return answer