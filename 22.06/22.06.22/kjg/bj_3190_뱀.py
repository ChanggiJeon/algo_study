from collections import deque

# 우,하,좌,상
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

a = int(input())
world = [[0] * a for _ in range(a)]
b = int(input())
# 사과 위치 입력
# 주의 사항 리스트 좌표상[0,0] 이지만 
# 입력으로 주어지는 좌표는 1씩 증가한 위치다
for i in range(b):
    y, x = map(int, input().split())
    # 따라서 1씩 빼주고 실행
    world[y - 1][x - 1] = 1
# 방향전환 목록
d_cnt = []
c = int(input())
for j in range(c):
    t, di = input().split()
    d_cnt.append([int(t), di])

# 뱀의 이동 시뮬레이션
# deque를 안써도 되려나?
snake = deque()
snake.append([[[0, 0]], 0])
# 시간
cnt = 0
while snake:
    # 1.시작하면 1초씩 증가
    cnt += 1
    body, d = snake.popleft()
    # 2.매초 마다 방향의 변화 확인
    d_change = ''
    if d_cnt and d_cnt[0][0] == cnt:
        d_change = d_cnt[0][1]
        d_cnt.pop(0)

    # 3.주어진 방향으로 다음위치 계산
    nx = body[-1][1] + dx[d]
    ny = body[-1][0] + dy[d]

    # 4-a.맵을 벗어나면 아웃
    if 0 > nx or nx >= a or 0 > ny or ny >= a:
        break

    # 4-b.머리가 몸통을 물면 아웃
    if [ny, nx] in body:
        break
    # 4-c.몸통 추가
    body.append([ny, nx])
    # 5-a 꼬리이동
    if world[ny][nx] == 0:
        body.pop(0)
    # 5-b 사과먹고 성장
    elif world[ny][nx] == 1:
        world[ny][nx] = 0
    # 6. 방향에 변화 있는지 체크
    if d_change == "D":
        d = (d + 1) % 4
    elif d_change == "L":
        d = (d - 1) % 4
    # 다음 뱀 상태 저장
    snake.append([body, d])
    # 시간이 10000초가 넘으면 아웃
    if cnt == 10000:
        break
print(cnt)