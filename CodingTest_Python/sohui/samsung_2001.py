def summing(flys, startY, startX, M):
    _sum = 0

    for i in range(startY, startY+M):
        for j in range(startX, startX+M):
            _sum += flys[i][j]

    return _sum

T = int(input())

for tc in range(T):
    N, M = map(int, input().split())

    flys = [[0 for _ in range(N)] for _ in range(N)]

    for i in range(N):
        _input = [list(map(int, input().split()))]
        for j in range(len(_input)):
            flys[i][j] = _input[j]

    _max = 0
    for i in range(0, N - M + 1):
        for j in range(0, N - M + 1):
            _max = max(_max, summing(flys, i, j, M))

    print(_max)