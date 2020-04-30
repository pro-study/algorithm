def solution(n, lost, reserve):
    h_lost = [e for e in lost if e not in reserve]
    h_reserve = [e for e in reserve if e not in lost]
    
    answer = n - len(h_lost)
    
    for num in h_lost:
        
        if num-1 in h_reserve:
            h_reserve.remove(num-1)
            answer += 1
            
        elif num+1 in h_reserve:
            h_reserve.remove(num+1)
            answer += 1
    
    return answer