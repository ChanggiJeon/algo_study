a = int(input())
n = 1
for i in range(1, a + 1):
    n *= i
cnt = 0
while not n % 10:
    n = n // 10
    cnt += 1
print(cnt)