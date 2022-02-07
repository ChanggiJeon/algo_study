k = int(input())
ans = 1
cnt = 0
for i in range(1,k+1):
    ans *= i
ans = str(ans)
for a in range(len(ans)-1,-1,-1):
    if ans[a] == '0':
        cnt += 1
    else:
        break
print(cnt)
