def solution(s):
    set_li = list(map(lambda x: set(map(int, x.split(','))), s.lstrip('{').rstrip('}').split('},{')))
    set_li.sort(key = lambda x: len(x))
    
    answer_tuple = list(set_li[0])
    
    for set_1, set_2 in zip(set_li, set_li[1:]+[set()]):
        answer_tuple += list(set_2 - set_1)
    
    return answer_tuple