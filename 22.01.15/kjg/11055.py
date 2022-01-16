n = int(input())
k = list(map(int, input().split()))
ans = [0]* n
ans[0] = k[0]
for i in range(1,n):
    for j in range(i):
        if k[j] < k[i]:
            ans[i] = max(ans[i], ans[j]+k[i])
        else:
            ans[i] = max(ans[i],k[i])
print(max(ans))


