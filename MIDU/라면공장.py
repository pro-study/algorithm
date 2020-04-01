import heapq

def solution(stock, dates, supplies, k):
    answer = 0
    heap = []
    dates.reverse()
    supplies.reverse()

    while stock < k:
        # 창고가 버텨줄 때까지 가능한 공급 수를 heqp에 추가합니다.
        while len(dates) > 0 and dates[len(dates)-1] <= stock:
            dates.pop()
            heapq.heappush(heap, -supplies.pop())

        stock -= heapq.heappop(heap)
        answer += 1
        
    return answer