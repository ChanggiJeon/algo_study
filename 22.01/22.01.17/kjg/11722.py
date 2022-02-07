N=int(input())
M = list(map(int,input().split()))
ans = [1]*N
for i in range(1,N):
    cnt = []
    for j in range(i):
        if M[i] < M[j]:
            cnt.append(ans[j])
    if not cnt:
        continue
    else:
        ans[i] += max(cnt)
print(max(ans))
