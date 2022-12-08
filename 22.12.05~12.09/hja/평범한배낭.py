n, k = map(int, input().split())
backpack = [0]*(k+1)
for _ in range(n):
    w,v = map(int,input().split())
    for j in range(k, w-1, -1):
        if backpack[j] < (backpack[j-w] + v):
            backpack[j] = (backpack[j-w] + v)

print(backpack[k])


