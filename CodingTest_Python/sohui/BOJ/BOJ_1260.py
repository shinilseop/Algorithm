class Node:
    def __init__(self, value):
        self.value = value
        self.edges = []

    def addEdge(self, next):
        self.edges.append(next)

N, M, V = map(int, input().split())
# 4 5 1
nodes = [Node(i) for i in range(0, N+1)]
# nodes = [node(0), node(1), node(2),...,node(4)]
for _ in range(M):
    _from, _to = map(int, input().split())
    nodes[_from].addEdge(_to)
    nodes[_to].addEdge(_from)
    # node[1].addEdge(2)
    # node[2].addEdge(1)
    # ...

for now in range(M):
    nodes[now].edges.sort()

"""
DFS
"""
visited = [False for _ in range(0, N+1)]

def dfs(now):
    print(now, end=" ")
    for next in nodes[now].edges:
        if visited[next] is False:
            visited[next] = True
            dfs(next)

visited[V] = True
dfs(V)
print()
"""
BFS
"""

from queue import Queue

visited = [False for _ in range(0, N+1)]

q = Queue()
q.put(V) # put=push, get=pop
visited[V] = True
while q.empty() is False:
    now = q.get()
    print(now,end=" ")
    for next in nodes[now].edges:
        if visited[next] is False:
            visited[next] = True
            q.put(next)