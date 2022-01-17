N = int(input())
arr = list(map(int, input().split()))
DP_arr = [1] * N

for i in range(1, N):
    for j in range(i):
        if arr[j] > arr[i] and DP_arr[j] + 1 > DP_arr[i]:
            DP_arr[i] = DP_arr[j] + 1
print(max(DP_arr))