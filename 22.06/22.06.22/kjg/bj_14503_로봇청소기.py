import sys
sys.setrecursionlimit(10**6)
N, M = map(int,input().split())
robot = list(map(int, input().split()))
world = [list(map(int, input().split())) for _ in range(N)]
visit = [ [0] * M for _ in range(N)]

# 상, 우, 하, 좌
dx = [0, 1, 0, -1]
dy = [-1, 0, 1, 0]
cnt = 0

# bfs로 시도시 실패
# q = deque()
# q.append(robot+[0])
# while q:
#     y, x, d, c = q.popleft()
#     print(y,x,d,c)
#     if visit[y][x] == 0:
#         visit[y][x] = 1
#         # print(y,x,d,c)
#         cnt += 1
#     if c == 4:
#         nx2 = x + dx[(d + 2) % 4]
#         ny2 = y + dy[(d + 2) % 4]
#         if 0 <= nx2 < M and 0 <= ny2 < N :
#             if  world[ny2][nx2] == 1:
#                 break
#             else:
#                 q.append([ny2, nx2, d, 0])        
#     nx = x + dx[(d - 1) % 4]
#     ny = y + dy[(d - 1) % 4]

#     if nx < 0 or nx >= M or ny < 0 or ny >= N:
#         # print('!',ny,nx)
#         q.append([y, x, (d - 1) % 4, c + 1])
#         continue
#     if world[ny][nx] == 1 or visit[ny][nx] != 0:
#         # print('!!')
#         q.append([y, x, (d - 1) % 4, c + 1])
#         continue
#     # print('!!!')
#     q.append([ny, nx, (d - 1) % 4, 0])

def dps(y,x,d,c):
    global cnt
    if visit[y][x] == 0:
        visit[y][x] = 1
        # print(y,x,d,c)
        cnt += 1
    if c == 4:
        nx2 = x + dx[(d + 2) % 4]
        ny2 = y + dy[(d + 2) % 4]
        if 0 <= nx2 < M and 0 <= ny2 < N :
            if  world[ny2][nx2] == 1:
                return
            else:
                # q.append([ny2, nx2, d, 0])        
                return dps(ny2, nx2, d, 0)
    nx = x + dx[(d - 1) % 4]
    ny = y + dy[(d - 1) % 4]

    if nx < 0 or nx >= M or ny < 0 or ny >= N:
        return dps(y, x, (d - 1) % 4, c + 1)
    if world[ny][nx] == 1 or visit[ny][nx] != 0:
        return dps(y, x, (d - 1) % 4, c + 1)
    return dps(ny, nx, (d - 1) % 4, 0)
dps(robot[0],robot[1],robot[2],0)
print(cnt)