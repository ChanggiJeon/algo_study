from copy import deepcopy

N = int(input())
arr = list(map(int, input().split()))
DP_arr = deepcopy(arr)

for i in range(1, N):
    for j in range(i):
        if arr[i] > arr[j]:
            if DP_arr[i] < DP_arr[j] + arr[i]:
                DP_arr[i] = DP_arr[j] + arr[i]
ans = max(DP_arr)
print(ans)