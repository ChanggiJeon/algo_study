def dfs(level, idx):
    if level == 6:
        print(*out)
        return

    for i in range(idx, k):
        out.append(S[i])
        dfs(level + 1, i + 1)
        out.pop()

while True:
    base = list(map(int, input().split()))
    k = base[0]
    S = base[1:]
    if k == 0 : break
    out = []
    dfs(0, 0)
    print()
