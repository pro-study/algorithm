import queue
from collections import namedtuple

"""class PrinterItem:
    def __init__(self, location, priority):
        self.location = location
        self.priority = priority"""

def solution(priorities, target):
    print_cnt = 0
    printer = queue.Queue()
    PrinterItem = namedtuple('PrinterItem','location priority')
    
    for location, priority in enumerate(priorities):
        printer.put(PrinterItem(location, priority))
        
    priorities.sort() #최대값 비교를 위해서 오름차순 정렬합니다.

    while printer:
        cur_item = printer.get()
        
        if cur_item.priority < priorities[len(priorities)-1]:
            printer.put(cur_item)
            continue
            
        priorities.pop()
        print_cnt += 1
        
        if cur_item.location == target:
            break
    
    return print_cnt