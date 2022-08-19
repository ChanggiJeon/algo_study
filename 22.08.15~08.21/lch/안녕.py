N = int(input())
L = list(map(int, input().split()))
J = list(map(int, input().split()))

# 체력은 100 기쁨은 0
# 체력이 0이되면 기쁨이 0이된다
ans = 0
def hs(idx, health, happy):
    global ans
    if health <= 0 : return
    if happy > ans:
        ans = happy
    if idx == N : return
    hs(idx+1, health-L[idx], happy+J[idx])
    hs(idx+1, health, happy)

hs(0, 100, 0)
print(ans)