# 테트로미노는 한 점을 중심으로 아래와 같이 연속된 3개의 점을 선택하는 모든 경우의 수로 표현 가능하다.
# 		ㅇ
# 	  ㅇㅇㅇ
# 	ㅇㅇㅇㅇㅇ
# ㅇㅇㅇ	x ㅇㅇㅇ
# 	ㅇㅇㅇㅇㅇ
# 	  ㅇㅇㅇ
# 		ㅇ
# 이 때, ㅗ 모양의 범위는 x를 중심으로 상하좌우 사방의 값 중 가장 작은값을 제외하고 한번만 계산한다.

# 상하좌우 탐색 배열
dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]


def solve(cr, cc, move, s):
    # params : 현재위치, 남은 이동 횟수, 누적값
    global ans

    # 종료 조건1 : 이동횟수 소진 시
    if move == 0:
        # 이때, 누적값이 결과값 보다 크면 교체(최댓값)
        if s > ans:
            ans = s
        return

    # 종료 조건2 : 최댓값으로 다 더해도 결과값을 넘지 못하는 경우(가지치기)
    if s + move * v_max <= ans:
        return

    # 사방 탐색
    for k in range(4):
        nr = cr + dr[k]
        nc = cc + dc[k]
        # 유효범위 체크
        if nr < 0 or nc < 0 or nr >= n or nc >= m:
            continue
        # 방문여부 체크
        if visit[nr][nc] == 1:
            continue
        # 방문 체크하고 이동 위치, 카운트 감소, 누적합 계산해서 재귀
        visit[nr][nc] = 1
        solve(nr, nc, move - 1, s + arr[nr][nc])
        visit[nr][nc] = 0


# 입력값
n, m = map(int, input().split())
arr = list()
v_max = 0
for i in range(n):
    arr.append(list(map(int, input().split())))
    # 백트랙킹을 위한 최대값 탐색(최소값의 경우 필요 없음)
    if max(arr[i]) > v_max:
        v_max = max(arr[i])

# 초기값
ans = 0
visit = list([0] * m for _ in range(n))

# 탐색
for i in range(n):
    for j in range(m):
        # 이동 가능범위 탐색 및 방문 체크
        visit[i][j] = 1
        solve(i, j, 3, arr[i][j])
        visit[i][j] = 0
        # ㅗ 체크
        cross = []
        for k in range(4):
            nr = i+dr[k]
            nc = j+dc[k]
            if nr < 0 or nc < 0 or nr >= n or nc >= m:
                continue
            cross.append(arr[nr][nc])
        # 크로스 범위 내에 2개만 존재하면 ㅗ를 만들 수 없음
        if len(cross) == 2:
            continue
        # 4이면 가장 작은 값 삭제해서 ㅗ로 만듬
        elif len(cross) == 4:
            cross.remove(min(cross))
        # 3개면 합 비교
        sum_cross = sum(cross) + arr[i][j]
        if sum_cross > ans:
            ans = sum_cross
print(ans)