# from collections import deque
N, M = map(int,input().split())
candy = [list(map(int, input().split())) for _ in range(N)]

# 실패 
# 문제는 없어보이는 데 99퍼에서 끊기는 것을 고려한다면
# 주관적인 합리적 의심에 의하면 bps로 풀면 틀리는 예시를 작성해놓은 것 같다.
# 하, 우 # 우,우하, 하로 하면 시간초과
# dx = [0, 1]
# dy = [1, 0]
# world = [[0] * M for _ in range(N)]
# q = deque()
# world[0][0] = candy[0][0]
# q.append([0, 0])
# while q:
#     y, x = q.popleft()
#     for i in range(2):
#         nx = x + dx[i]
#         ny = y + dy[i]
#         if 0 > nx or M <= nx or 0 > ny or N <= ny:
#             continue
#         if world[y][x] + candy[ny][nx] <= world[ny][nx]:
#             continue
#         world[ny][nx] = world[y][x] + candy[ny][nx]
#         q.append([ny, nx])
# print(world[N - 1][M - 1])

# 그렇다면 다른 방식으로 풀어보자
# 1번 예시에 최대한 맞춰서 배열을 짜본다면
# 사탕의 위치는 아래와 같고
# 1 2 3 4
# 0 0 0 0
# 9 8 7 6
# 최대 사탕 갯수를 기록하는 배열은 N+1 * M+1 크기일것이다
# 이 때 준규의 위치는 (1,1) 즉 느낌표 위치고
# 0 0 0 0 0   
# 0 ! 0 0 0
# 0 0 0 0 0
# 0 0 0 0 0 
# 만약 !좌표에서 ?까지 옮긴다고 했을 때 최대값은 몇이 될까?
# 0 0 0 0 0   
# 0 ! @ 0 0
# 0 # ? 0 0
# 0 0 0 0 0
# ?시점에서 보면 현재의 최대 갯수는 
# !,@,# 중에서 가장 큰것을 골라온 것 + 현재위치 사탕 갯수로 보인다.
# 그것을 식으로 적어본다면 현재좌표까지 최대사탕은 현좌표 사탕 + max(위,왼위,왼)라는 식으로 표현된다
world = [[0] * (M + 1) for _ in range(N + 1)]
for i in range(1,N + 1):
    for j in range(1, M + 1):
        world[i][j] = candy[i-1][j-1] + max(world[i - 1][j],world[i][j - 1],world[i - 1][j - 1])
print(world[N][M])
