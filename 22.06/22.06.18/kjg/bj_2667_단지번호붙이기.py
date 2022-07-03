a = int(input())
adj = [list(input()) for _ in range(a)]
visit = [[0] * a for _ in range(a)]
ajd2 = []

def dfs(y, x):
    # 새로 생긴 단지가 현재 체크중인 단지이기에 리스트 최후미 접근
    # 방문일지 체크
    ajd2[-1] += 1
    visit[y][x] = 1

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 > nx or a <= nx or 0 > ny or a <= ny:
            continue
        if adj[ny][nx] != '1':
            continue
        if visit[ny][nx] != 0:
            continue
        dfs(ny, nx)

# 상,하, 좌, 우
dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]

# 단지 번호 메길 변수
cnt = 0
for y in range(a):
    for x in range(a):
        if adj[y][x] == '1' and visit[y][x] == 0:
            # 새로운 단지의 생성
            ajd2.append(0)
            # 단지번호 갱신
            cnt += 1
            dfs(y, x)
print(cnt)

# 실패원인1 단지의 갯수를 오름차순으로 정렬할 필요가 있다(문제에서 제시)
ajd2.sort()
for aj in ajd2:
    print(aj)