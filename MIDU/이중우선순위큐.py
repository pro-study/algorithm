import heapq

class PPQ:
    def __init__(self):
        self.q = []
        return
    
    def insert(self, num):
        heapq.heappush(self.q, num)
        return
    
    def del_max(self):
        if self.q:
            self.q.remove(max(self.q))
        return
    
    def del_min(self):
        if self.q:
            heapq.heappop(self.q)
        return

    def empty(self):
        return not self.q

def solution(operations):
    answer = []
    ppq = PPQ()
    
    for operation in operations:
        if operation.startswith("I"):
            ppq.insert(int(operation[2:]))
        elif operation == "D 1":
            ppq.del_max()
        else: ppq.del_min()
        
    if ppq.empty():
        return [0,0]
    else:
        answer = [max(ppq.q), ppq.q[0]]
    
    return answer