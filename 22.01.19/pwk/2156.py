n = int(input())

arr = []
for _ in range(n):
    arr.append(int(input()))

# 이번걸 안먹는 경우 / 저번걸 안먹은 경우 / 저번걸 먹고 이번것도 먹은 경우
result = [[] for _ in range(n)]
if n == 1:
    print(arr[0])
    exit()
result[0] = [0,arr[0],0]
if n == 2:
    print(sum(arr))
    exit()
result[1] = [arr[0], arr[1], arr[0]+arr[1]]

for i in range(2, n):
    result[i] = [max(result[i-1]),
                 arr[i] + max(result[i-2]),
                 arr[i] + result[i-1][1]
    ]
print(max(result[-1]))