def combination(arr, r, chosen):
    if len(chosen) == r:
        selectedCombi.append([chosen[i] for i in range(len(chosen))])
        return

    start = arr.index(arr[chosen[-1]]) + 1 if chosen else 0
    for nxt in range(start, len(arr)):
        chosen.append(nxt)
        combination(arr, r, chosen)
        chosen.pop()

def dfs(arr, r, chosen):
    if len(chosen) == r:
        selectedDFS.append([chosen[i] for i in range(len(chosen))])
        return

    for i in range(len(arr)):
        if visited[i] is False:
            chosen.append(i)
            visited[i]=True
            dfs(arr, r, chosen)
            visited[i]=False
            chosen.pop()

arr = ['a','b','c','d','e']
r = 3
selectedCombi = []
selectedDFS = []
visited = [False for _ in range(len(arr))]
combination(arr, r, [])
dfs(arr, r, [])
print(selectedCombi)
print(selectedDFS)
