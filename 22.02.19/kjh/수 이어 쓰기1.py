# 1~9:9 * 1 / 10~99:90 * 2 / 100~999:900 * 3

a = input()
length = len(a)
ans = 0
tmp = ''
for i in range(length - 1):
    ans += (9 * 10**i) * (i + 1)
    tmp += '9'
b = int(a)
if tmp:
    b -= int(tmp)
ans += b * length

print(ans)
