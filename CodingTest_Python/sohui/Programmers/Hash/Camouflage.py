def solution(clothes):
    def fitting(idxStart, now, fitted, count):
        if now == fitted:
            return count

        _sum = 0
        for i in range(idxStart, len(_keys)):
            if visited[i] is False:
                visited[i] = True
                _sum += fitting(i+1, now+1, fitted, count*kind[_keys[i]])
                visited[i] = False

        return _sum

    kind = {}
    for i in range(len(clothes)):
        cloth = clothes[i]
        if cloth[1] in kind:
            kind[cloth[1]] += 1
        else:
            kind[cloth[1]] = 1

    _sum = 0
    _keys = list(kind.keys())
    for i in range(1, len(_keys)+1):
        visited = [False for _ in range(len(_keys))]
        _sum+=fitting(0, 0, i, 1)
    return _sum

print(solution([["yellowhat", "headgear"], ["bluesunglasses", "eyewear"], ["green_turban", "headgear"]]))