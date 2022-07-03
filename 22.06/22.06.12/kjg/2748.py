a = int(input())
visit = [0] * (a + 1)

if a == 0:
    print(0)
elif a == 1:
    print(1)
else:
    visit[0], visit[1] = 0, 1
    for i in range(2, a + 1):
        visit[i] = visit[i - 2] + visit[i - 1]
    print(visit[a])