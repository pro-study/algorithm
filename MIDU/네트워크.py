def dfs(graph, start, visited) :
    stack = [start]
    
    while stack:
        n = stack.pop()
        stack += [x for x in range(len(graph)) if x not in visited and x != n and graph[n][x]]
        visited[n] = 1
        
    return

def solution(n, computers):
    net_cnt = 0
    visited = {}
    
    for i in range(len(computers)):
        if i not in visited:
            net_cnt += 1
            dfs(computers, i, visited)
            
    return net_cnt