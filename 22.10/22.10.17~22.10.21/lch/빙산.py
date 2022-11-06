from collections import deque
import copy

def bfs(i, j):
    q = deque()
    q.append([i, j])
    visit = [[0] * M for _ in range(N)]
    visit[i][j] = 1
    while q:
        a, b = q.popleft()
        for k in range(4):
            x = a + dx[k]
            y = b + dy[k]
            if 0 <= x < N and 0 <= y < M and visit[x][y] == 0 and temp[x][y] != 0:
                temp[x][y] = 0
                visit[x][y] = 1
                q.append([x, y])
#주위의 0 개수 측정
def check(i, j):
    cnt = 0
    for k in range(4):
        x = i + dx[k]
        y = j + dy[k]
        if 0 <= x < N and 0 <= y < M and t[x][y] == 0:
            cnt += 1
    return cnt
# 전부 녹았는지 체크
def check_0():
    for i in range(N):
        for j in range(M):
            if base[i][j] != 0:
                return False
    return True


N, M = map(int, input().split())
base = []
for i in range(N):
    base.append(list(map(int, input().split())))
answer = 1
dx = [1, -1, 0, 0]
dy = [0, 0, -1, 1]

while True:
    if check_0():
        print(0)
        break
    t = copy.deepcopy(base)
    for i in range(N):
        for j in range(M):
            if t[i][j] != 0:
                next = base[i][j] - check(i, j)
                if next > 0:
                    base[i][j] = next
                else:
                    base[i][j] = 0
    temp = copy.deepcopy(base)
    cnt = 0
    for i in range(N):
        for j in range(M):
            if temp[i][j] != 0:
                temp[i][j] = 0
                bfs(i, j)
                cnt += 1
    if cnt > 1:
        print(answer)
        break
    answer += 1