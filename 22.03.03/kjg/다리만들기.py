# 오랜만에 해서 해당 최소거리 구하기 알고리즘이 생각이 안나 
# 풀이보고 암기로 작성

from collections import deque

# 아래 함수가 무사히 진행되면 각 섬의 영역이 표시됨
def bfs(x,y):
    global count
    q= deque()
    # 요부분 중요 (초기값 입력)
    q.append([x,y])
    visit[y][x] = 1
    Map[y][x] = count
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            # 조건은 맵 안에 존재하는 좌표이며
            # 육지라는 표시가 1과 동일함 가상좌표의 존재여부만 확인
            # 방문을 통해 갔던 곳 다시 가지 않게 하기
            if 0<=nx<N and 0<=ny<N and Map[ny][nx] and not visit[ny][nx]:
                # 방문일지 찍어주고
                visit[ny][nx] = 1
                # 섬 번호 입력하기
                Map[ny][nx] = count
                # 해당섬의 다른 구역 확인
                q.append([nx,ny])

def bfs2(k):
    global answer
    # -1로 생성하는 이유는 바다를 나타내기위해
    # 0은 연결되어있는 육지부분
    # 1이상은 섬과 섬의 거리
    dist=[[-1]*N for _ in range(N)]
    q = deque()

    # 전체 맵을 탐색해서 각 섬의 육지연결여부 갱신
    for i in range(N):
        for j in range(N):
            if Map[i][j] == k:
                q.append([j,i])
                dist[i][j] = 0
    # 연결 상태 확인 후 거리 탐색 시작
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<N and 0<=ny<N:
                # 섬의 번호가 부여가 되어있고
                # 현재 섬과 다른 섬일 경우
                if Map[ny][nx]> 0 and Map[ny][nx] != k:
                    # 현재 최소거리와 현재 지점의 거리와 비교하여 최소로 갱신
                    answer = min(answer,dist[y][x])
                    return
                # 현재 가상좌표가 바다일 경우 다리를 세운적이 없을때 다음 좌표가 기록
                if Map[ny][nx] == 0 and dist[ny][nx] == -1:
                    # 다리의 가상좌표까지의 다리길이는 현재 지점에서 +1
                    dist[ny][nx] = dist[y][x] +1
                    q.append([nx,ny])

N = int(input())
Map = [list(map(int,input().split())) for _ in range(N)]
visit = [[0]*N for _ in range(N)]
# 상하좌우
dx = [0,0,-1,1]
dy = [-1,1,0,0]
# 섬번호
count = 1
# 정사각형 맵이고 최소거리를 구하는 것이기에 최대치를 가로*세로 정함
answer = N*N

# 전체 맵 탐사를 위한 반복문
for i in range(N):
    for j in range(N):
        if not visit[i][j] and Map[i][j] == 1:
            bfs(j,i)
            # 한 섬에 대한 마킹이 끝났으니 다음 번호로 이동
            count += 1

for k in range(1,count):
    # 각 섬을 기준으로 거리 재기
    bfs2(k)
print(answer)