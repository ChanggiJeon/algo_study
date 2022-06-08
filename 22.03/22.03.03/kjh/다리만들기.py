import sys
from collections import deque

dr = [0, 1, 0, -1]
dc = [1, 0, -1, 0]

# 특정 섬 x에서 다른 섬까지 최단 거리를 찾는 함수
def find_island(x):
    # 누적 거리 정보
    dist = list([0] * n for _ in range(n))
    q = deque()
    # x섬과 인접한 바다 체크
    for i in range(n):
        for j in range(n):
            # 현재 위치가 x번째 섬
            if islands[i][j] == x:
                # 주변 위치 확인
                for d in range(4):
                    nr = i + dr[d]
                    nc = j + dc[d]
                    # 범위, 육지 체크
                    if nr == n or nr == -1 or nc == n or nc == -1 or original[nr][nc]: continue
                    # 이미 체크했으면 넘어감
                    if dist[nr][nc] == 1: continue
                    # 바다면 체크
                    dist[nr][nc] = 1
                    q.append((nr, nc))
    # 인접한 바다에서 시작해서 바다-바다인경우 : dist+1
    # 바다-다른섬인 경우 ans 갱신 후 return
    while q:
        cr, cc = q.popleft()
        for d in range(4):
            nr = cr + dr[d]
            nc = cc + dc[d]
            # 범위, 방문 체크
            if nr == n or nr == -1 or nc == n or nc == -1 or dist[nr][nc]: continue
            # x섬인 경우 패스
            if islands[nr][nc] == x: continue
            # 바다인 경우 거리 체크하고 q에 쌓기
            elif not islands[nr][nc]:
                dist[nr][nc] = dist[cr][cc] + 1
                q.append((nr, nc))
            # 다른 섬인 경우(종료)
            else:
                ans.append(dist[cr][cc])
                return


n = int(input())
original = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
# 섬 정보
islands = list([0] * n for _ in range(n))
q = deque()

# 섬 라벨링
label = 1
for i in range(n):
    for j in range(n):
        # 현재 위치가 육지인데 섬체크 안되어 있으면 섬 체크하기
        if original[i][j] == 1 and islands[i][j] == 0:
            islands[i][j] = label
            q.append((i, j))
            while q:
                cr, cc = q.popleft()
                for d in range(4):
                    nr = cr + dr[d]
                    nc = cc + dc[d]
                    # 범위, 방문, 바다 체크
                    if nr == -1 or nr == n or nc == -1 or nc == n or islands[nr][nc] or not original[nr][nc]: continue
                    islands[nr][nc] = label
                    q.append((nr, nc))
            # 섬 체크가 끝나면 다음 섬 체크를 위해 라벨+1
            label += 1
# 섬의 총 개수 저장
island_num = label
ans = []
# 섬의 총 개수만큼 돌면서 최단거리 검색
for i in range(1, island_num):
    find_island(i)
print(min(ans))