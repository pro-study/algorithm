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
    stage = {n: Stage(n + 1, 0, 0) for n in range(N)}

    for i in range(len(stages)):
        key = stages[i] - 1
        if key in stage.keys():
            stage[key].failed += 1
        else:
            key -= 1
        for j in range(key + 1):
            stage[j].total += 1

    stage = list(stage.values())
    stage.sort(key=lambda x: x.getFailedRate(), reverse=True)
    answer = list(map(lambda x: x.num, stage))
    return answer


if __name__ == "__main__":
    N = 5; stages = [2, 1, 2, 6, 2, 4, 3, 3]
    print(solution(N, stages))