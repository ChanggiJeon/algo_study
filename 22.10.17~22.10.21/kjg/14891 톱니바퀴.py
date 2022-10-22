
chain = []
point = [0] * 4
for _ in range(4):
    chain.append(list(input()))
d = [-1,1]
# print(chain)
# print(point)
def spinCircle(num,spin,visit):
    target = point[num]
    visit[num] = 1
    if spin == 1:
        point[num] = (point[num] + 7) % 8
        if num + 1 < 4 and not visit[num + 1]:
            if chain[num][(target + 2) % 8] != chain[num + 1][(point[num + 1] + 6) % 8]:
                spinCircle(num + 1, -1,visit)
        if num - 1 >= 0 and not visit[num - 1]:
            if chain[num][(target + 6) % 8] != chain[num - 1][(point[num - 1] + 2) % 8]:
                spinCircle(num - 1, -1,visit)
    elif spin == -1:
        point[num] = (point[num] + 1) % 8
        if num + 1 < 4 and not visit[num + 1]:
            if chain[num][(target + 2) % 8] != chain[num + 1][(point[num + 1] + 6) % 8]:
                spinCircle(num + 1, 1,visit)
        if num - 1 >= 0 and not visit[num - 1]:
            if chain[num][(target + 6) % 8] != chain[num - 1][(point[num - 1] + 2) % 8]:
                spinCircle(num - 1, 1,visit)


n = int(input())
for _ in range(n):
    num, spin = map(int, input().split())
    visit = [0] * 4
    spinCircle(num - 1, spin, visit)
ans = 0
for i in range(4):
    if chain[i][point[i]] == '1':
        ans += 2 ** i
print(ans)

