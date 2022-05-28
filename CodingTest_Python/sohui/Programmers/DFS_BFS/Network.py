def solution(n, computers):
    class Node():
        def __init__(self, num):
            self.num = num
            self.edges = []

        def addEdge(self, next):
            self.edges.append(next)

    def dfs(now):
        for next in nodes[now].edges:
            if visited[next] is False:
                print("탐색중 : ", i)
                visited[next] = True
                dfs(next)

    nodes = [Node(i) for i in range(n)]
    for i in range(len(computers)):
        for j in range(len(computers[i])):
            if (i == j):
                continue

            if computers[i][j] == 1:
                nodes[i].addEdge(j)

    for i in range(len(nodes)):
        print(i, ":", nodes[i].edges)

    visited = [False for _ in range(n)]

    cnt = 0
    for i in range(n):
        if visited[i] is False:
            visited[i] = True
            print("첫 방문 : ", i)
            cnt += 1
            dfs(i)

    return cnt


print(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))
