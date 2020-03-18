import queue

def solution(priorities, location):
    answer = 0
    printer = queue.Queue()
    
    for i,e in enumerate(priorities):
        printer.put([i,e])
        
    priorities.sort()
        
    while printer:
        temp = printer.get()
        
        if temp[1] < priorities[len(priorities)-1]:
            printer.put(temp)
            continue
            
        priorities.pop()
        answer += 1
        
        if temp[0] == location:
            break
    
    return answer