import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline
n,m = map(int,input().split())

visit = [i for i in range(n+1)]

def connect(x):
    if x == visit[x]:
        return x
    y = connect(visit[x])
    visit[x] = y
    return visit[x]

def convert(x,y):

    x = connect(x)
    y = connect(y)

    if x==y:
        return
    if x < y:
        visit[y] = x
    else:
        visit[x] = y

for _ in range(m):
    c,a,b = map(int,input().split())

    if c == 0:
        convert(a,b)
    else:
        if connect(a) == connect(b):
            print("YES")
        else:
            print("NO")