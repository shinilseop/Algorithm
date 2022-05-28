class Stage():
    def __init__(self, stage):
        self.stage = stage
        self.challenge = 0
        self.passPercent = 0.0


def solution(N, stages):
    answer = []

    _stages = [Stage(i) for i in range(N)]
    passed = 0
    for now in stages:
        if now == (N + 1):
            passed += 1
        else:
            _stages[now - 1].challenge += 1

    for i in range(len(_stages) - 1, -1, -1):
        if (passed + _stages[i].challenge == 0):
            _stages[i].passPercent = 0
        else:
            _stages[i].passPercent = 1 - (passed / (passed + _stages[i].challenge))
        passed += _stages[i].challenge

    _stages.sort(reverse=True, key=lambda x: x.passPercent)
    for stage in _stages:
        answer.append(stage.stage + 1)

    return answer


print(solution(5, [2, 1, 2, 6, 2, 4, 3, 3]))
print(solution(4, [4, 4, 4, 4, 4]))
