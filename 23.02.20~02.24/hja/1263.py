import sys
sys.stdin = open("test.txt", "r")

n = int(input())
arr = []
for _ in range(n):
    t, s = map(int, input().split())
    arr.append([t, s])

sorted_arr = sorted(arr, key=lambda x: x[1], reverse=True)
res = sorted_arr[0][1] - sorted_arr[0][0]


for i in range(1, n):
    if res > sorted_arr[i][1]:
        res = sorted_arr[i][1] - sorted_arr[i][0]
    else:
        res -= sorted_arr[i][0]
if res >= 0:
    print(res)
else:
    print(-1)
