import sys


class Home():
    def __init__(self, y, x):
        self.y = y
        self.x = x


class Chicken():
    def __init__(self, y, x):
        self.y = y
        self.x = x


def combination(arr, r, chosen):
    if len(chosen) == r:
        selected.append([chosen[i] for i in range(len(chosen))])
        return

    start = arr.index(arr[chosen[-1]]) + 1 if chosen else 0
    for nxt in range(start, len(arr)):
        chosen.append(nxt)
        combination(arr, r, chosen)
        chosen.pop()


def calDist(selected):
    _minSum = 0
    for i in range(len(home)):
        _min = sys.maxsize
        for j in range(len(selected)):
            _min = min(_min, abs(home[i].y - chicken[selected[j]].y) + abs(home[i].x - chicken[selected[j]].x))
        _minSum += _min
    return _minSum

N, M = map(int, input().split())

home = []
chicken = []
city = []
for i in range(N):
    city.append(list(map(int, input().split())))
    for j in range(N):
        if (city[i][j] == 1):
            home.append(Home(i, j))
        elif (city[i][j] == 2):
            chicken.append(Chicken(i, j))

visited = [False for _ in range(len(chicken))]
selected = []
combination(chicken, M, [])
# print(selected)

_min = sys.maxsize
for i in range(len(selected)):
    _min  = min(_min, calDist(selected[i]))
print(_min)
