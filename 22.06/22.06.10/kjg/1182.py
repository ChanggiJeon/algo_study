n, s = map(int, input().split())
targets = list(map(int, input().split()))
cnt = 0
def comb(start,ans):
    global cnt
    if start == n:
        return
    ans += targets[start]
    if ans == s:
        cnt += 1
    comb(start + 1, ans - targets[start])
    comb(start + 1, ans)
comb(0,0)
print(cnt)
