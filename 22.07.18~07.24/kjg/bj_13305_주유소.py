import sys
input = sys.stdin.readline
a = int(input())
di = list(map(int,input().split())) 
cost = list(map(int,input().split()))

def journey(x):
    if x == a:
        return 0
    e = 0
    for i in range(x + 1, a - 1):
        if cost[x] > cost[i]:
            dis = sum(di[x:i])
            e = i
            cos = dis * cost[x]
            break
    else:
        dis = sum(di[x:])
        e = a
        cos = dis * cost[x]
    # print(cos)
    return cos + journey(e)
print(journey(0))


