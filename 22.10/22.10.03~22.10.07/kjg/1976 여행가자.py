import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

n = int(input())
m = int(input())

parent = [i for i in range(n)]

def connect(x):
    if x == parent[x]:
        return x
    y = connect(parent[x])
    parent[x] = y
    return parent[x]



def union(x,y):
    x = connect(x)
    y = connect(y)

    if x== y:
        return
    if x < y:
        parent[y] = x
    else:
        parent[x] = y



for i in range(n):
    arr = list(map(int,input().split()))

    for j in range(len(arr)):
        if arr[j] == 0:
            continue
        else:
            union(i,j)

arr2 = list(map(int,input().split()))

cnt = -1
for a in arr2:
    if cnt == -1:
        cnt = parent[a - 1]
    else:
        if cnt != parent[a - 1]:
            print("NO")
            break
else:
    print("YES")
