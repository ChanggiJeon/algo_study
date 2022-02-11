n = int(input())
data = list(map(int,input().split()))

flag = 0
for i in range(n-1,0,-1):
    if data[i-1] < data[i]:
        for j in range(n-1,0,-1):
            if data[i-1] < data[j]:
                data[i-1],data[j] = data[j],data[i-1]
                ans = data[:i]+sorted(data[i:])
                flag = 1
                break
    if flag == 1:
        print(*ans)
        break
else:
    print(-1)