from collections import deque

# python의 특징 때문에 그런지 bfs를 함수구조로 하지않으면 시간초과가 발생한다
# pypy3로 진행했을 때는 오히려 함수구조 썼을때 안썼을때 상관없이 통과하지만
# 시간은 함수구조를 안썼을 때 높다

n,m = map(int,input().split())
world = [list(map(int,input())) for _ in range(n)]

# 1. 방향설정: 
# 맵의 구조가 어떻게 될지 모르는 상황이기에
# 좌상에서 우하로 가는 경우라도 4방향 설정
# 우하좌상
dc = [1,0,-1,0]
dr = [0,1,0,-1]

# 2. 재방문을 방지하기 위한 리스트
# 벽을 부섰는지 안부섰는지도 중요하기에 3차원으로 작성
# 중요 차원이 높아질때 반드시 반복문으로 작성
visited = [[[0]*2 for _ in range(m)]  for _ in range(n)]
# 거리(시작지점도 포함하기에 1로시작)
visited[0][0][0] = 1
# 3. 최소값을 위한 bfs

def bfs():
    q = deque()
    # 열,행,벽 카운트
    q.append([0,0,0])

    while q:
        cr,cc,cnt = q.popleft()
        # 4. 도착하면 탈출할 포인트
        if cr == n-1 and cc ==  m - 1:
            return visited[cr][cc][cnt]
            
        for i in range(4):
            nc = cc + dc[i]
            nr = cr + dr[i]

            if nc < 0 or nc >= m or nr < 0 or nr >= n:
                continue
            if world[nr][nc] == 1 and cnt == 0:
                visited[nr][nc][1] = visited[cr][cc][0] + 1
                q.append([nr,nc,1])
                
            elif world[nr][nc] == 0 and visited[nr][nc][cnt] == 0:
                visited[nr][nc][cnt] = visited[cr][cc][cnt] + 1
                q.append([nr,nc,cnt])
    return -1
print(bfs())



