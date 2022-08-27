T = int(input())
for tc in range(T):
    N = int(input())
    case = list(map(int, input().split()))
    sort_case = sorted(case)
    base = [0 for _ in range(N)]
    ans = [0 for _ in range(N)]

    for i in range(N):
        if i % 2 == 0:
            base[i // 2] = sort_case[i]
        else:
            base[-(i // 2 + 1)] = sort_case[i]

    for j in range(N):
        ans[j] = abs(base[j] - base[(j + 1) % N])
    print(max(ans))