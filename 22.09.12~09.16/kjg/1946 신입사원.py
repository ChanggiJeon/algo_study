import sys
input = sys.stdin.readline
n = int(input())
for _ in range(n):
    m = int(input())
    arr = []
    cnt = 1
    for i in range(m):
        f1, s1 = map(int, input().split())
        arr.append([f1, s1])

    arr.sort()
    target = arr[0][1]
    for i in range(1,m):
        if arr[i][1] < target:
            target = arr[i][1]
            cnt += 1
    print(cnt)
    # 확인용!!