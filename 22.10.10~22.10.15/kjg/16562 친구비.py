import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

def convert(x):
    # print(x)
    if x == graph[x]:
        return x
    graph[x] = convert(graph[x])
    return graph[x]

def union(x,y):
    x = convert(x)
    y = convert(y)
    if a != b:
        if cost[x] <= cost[y]:
            graph[y] = x
        else:
            graph[x] = y


m,n,l = map(int,input().split())
cost = [0] + list(map(int,input().split()))
graph = [i for i in range(m + 1)]

for _ in range(n):
    a,b = map(int,input().split())
    union(a,b)

ans = 0

for idx, num in enumerate(graph):

    if idx == num:
        ans += cost[idx]
if ans <= l:
    print(ans)
else:
    print("Oh no")

