class Traffic:
    def __init__(self, line):
        date, time, process_time = line.split()
        time = list(map(float, time.split(':')))
        
        for i in range(2):
            time[2] += time[i] * (60 ** (2 - i)) #초단위로 다 계산해줍니다.
        
        end_time = time[2]
        process_time = float(process_time[:-1])
        
        self.end_time = end_time
        self.start_time = end_time - process_time + 0.001
        self.process_time = process_time
        
    def __str__(self):
        return "start_time = {}, end_time = {}".format(self.start_time, self.end_time)


def solution(lines):
    answer = 0
    stack = []
    
    for i in range(len(lines)):
        lines[i] = Traffic(lines[i])
        #print(line)
    lines.sort(key = lambda x: x.start_time) #시작시간 순으로 다시 정렬해줍니다. (생략시 3번/8번 testcase 실패)
    
    for line in lines:
        if not stack:
            stack.append(line)
        else:
            #print(line)
            for e in stack:
                if e.end_time > line.start_time - 1:
                    continue
                else:
                    stack.remove(e)
            stack.append(line)
        
        if len(stack) > answer:
            answer = len(stack)
    
    return answer

if __name__ == "__main__":
    result = solution(["2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"])
    print(result)