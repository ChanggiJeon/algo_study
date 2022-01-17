N = int(input())
lst = list(map(int, input().split()))

cnt = [0]*N
cnt[-1] = 1

for i in range(N-1,-1,-1):
    largest_cnt = 0
    for j in range(N-1,-1,-1):
        if lst[i] > lst[j]:
            if largest_cnt < cnt[j]:
                largest_cnt = cnt[j]
    cnt[i] = largest_cnt + 1

print(max(cnt))