# 생각나는 순서
# 1. 벽을 세울 수 있는 모든 경우의 수를 구한다
# 2. 벽을 새운 뒤 바이러스를 움직여 퍼트린다.
# 3. 안전지대의 수를 구한다.
# 4. 각 경우의 수를 구하며 안전지대의 최대값을 찾는다

# 추론
# 1. 어떤 상황이든 바이러스의 갯수가 최소이면 안전지대의 수가 최대이다. 그러니 바이러스의 갯수만 새서 역산하자
# ->제한사항: 그러기 위해서는 벽의 개수도 알필요가 있다.
# ->추가로 초기 바이러스의 위치도 알아야 바이러스의 전염범위를 계산할 수 있다.
# -> 그럼 언제 조사하는 것이 가장 빠른가?
# -> 벽을 세우는 조합을 진행하면서 진행하는 것은?
# -> 확인한 위치를 파악하기 위해서는 list같은 형식으로 저장해서 확인해야 하지만
# 그렇게 되면 벽이나 바이러스가 추가될수록 조회할 때 과정이 늘어난다.
# -> 전체 맵을 한번 조회하면서 벽의 수만 카운트하자 그리고 벽은 3개까지 추가되는 +3 된 개수로 연산하자
# -> 그리고 다시 맵을 탐색할때 바이러스가 확인되면 그 시점에서 바이러스를 퍼트리고
# ->바이러스의 개수를 카운트하자
# ->기존 경우의 수에서 나온 바이러스 수보다 많이 나오면 안전지대의 수가 줄어듦으로 빠져나오자
# 위 과정으로 진행될 경우 확정적인 전체탐색 횟수는
# 초기 1회 + 벽을 세울수 있는 경우의수 만큼이다
from copy import deepcopy
from collections import deque
def makeWall(idx, cnt):

    if cnt == 3:
        findVirus()
        return
    for i in range(idx, (n * m)):
        r = i // m  # 나눈 값의 몫은 열번호가 된다
        c = i % m  # 나머지는 행번호가 된다.
        if world[r][c] == 0:
            world[r][c] = 1
            makeWall(i +1, cnt + 1)
            world[r][c] = 0

def findVirus():
    global min_virus,wall
    cWorld = deepcopy(world)
    q = deque()
    vi_cnt = 0
    wall = 0
    for i in range(n):
        for j in range(m):
            if cWorld[i][j] == 2:
                q.append([i,j])
            if cWorld[i][j] == 1:
                wall += 1
    while q:
        cr, cc = q.popleft()
        vi_cnt += 1
        if vi_cnt >= min_virus:
            return
        for i in range(4):
            nr = cr + dr[i]
            nc = cc + dc[i]
            if nr < 0 or nr >= n or nc < 0 or nc >= m:
                continue
            if cWorld[nr][nc] == 1 or cWorld[nr][nc] == 2:
                continue
            cWorld[nr][nc] = 2
            q.append([nr, nc])
    min_virus = min(min_virus,vi_cnt)
# 상,하,좌,우
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

n, m = map(int, input().split())
world = [list(map(int, input().split())) for _ in range(n)]
cWorld = []
min_virus = n*m
wall = 0
makeWall(0,0)
print(n*m -(min_virus+wall))
