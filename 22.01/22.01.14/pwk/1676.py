cnt = 0
N = int(input())
while N != 0:
    N = N // 5
    cnt += N

print(cnt)