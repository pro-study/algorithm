from collections import Counter

class Stage:
    def __init__(self, num, failed, total):
        self.num = num
        self.failed = failed
        self.total = total
        self.failed_rate = 0

    def getFailedRate(self):
        if self.total > 0:
            self.failed_rate = self.failed / self.total
            return self.failed_rate
        else:
            return 0

    def __str__(self):
        return "num: {}, failed: {}, total: {}, failed_rate: {}".format(self.num, self.failed, self.total,
                                                                        self.getFailedRate())


def solution(N, stages):
    answer = []

    # stage 별 Stage 객체 생성
    stage = {n: Stage(n, 0, 0) for n in range(1, N+1)}
    stage_count = dict(Counter(stages))

    # stage_count의 배열을 순회하면서 stage의 전체 횟수와 실패 횟수 카운트
    for key in stage_count.keys():
        if key in stage.keys():
            stage[key].failed += stage_count[key]

        for s in stage:
            s = stage[s]
            if s.num <= key: s.total += stage_count[key]
            else: continue

    stage = list(stage.values())
    stage.sort(key=lambda x: x.getFailedRate(), reverse=True)
    answer = list(map(lambda x: x.num, stage))
    return answer


if __name__ == "__main__":
    N = 5; stages = [2, 1, 2, 6, 2, 4, 3, 3]
    print(solution(N, stages))