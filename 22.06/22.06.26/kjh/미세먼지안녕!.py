# python 시간초과 pypy 통과
import copy

R, C, T = map(int, input().split())
table = [list(map(int, input().split())) for _ in range(R)]
r1, c1 = 999, 999
r2, c2 = 999, 999
# 위쪽 공기청정기 진행방향 우상좌하 = 0~3 / 아래쪽 공기청정기 진행방향 우하좌상 = 4~7
dr = [0, -1, 0, 1, 0, 1, 0, -1]
dc = [1, 0, -1, 0, 1, 0, -1, 0]
for time in range(1, T + 1):
    # 모든 확산은 동시에 발생해야함으로 복사본 생성
    tmp_table = copy.deepcopy(table)
    for i in range(R):
        for j in range(C):
            # 0. 공기청정기 시작 위치 저장
            if table[i][j] == -1:
                if r1 == 999:
                    r1, c1 = i, j + 1
                else:
                    r2, c2 = i, j + 1
                continue
            # 1. 확산
            if table[i][j] == 0: continue
            amount = table[i][j] // 5
            # 우상좌하 확인
            for k in range(4):
                # 확산 가능한지 확인
                nr = i + dr[k]
                nc = j + dc[k]
                if nr < 0 or nc < 0 or nr >= R or nc >= C or table[nr][nc] == -1: continue
                # 확산 가능하면 현재 위치에서 amount 감소 후 해당 위치에 더하기
                tmp_table[i][j] -= amount
                tmp_table[nr][nc] += amount
    # 테이블 갱신
    table = tmp_table

    # 위쪽 공기청정기 초기값 설정
    i = 0
    # 현재 저장된 먼지량, 현재 기준 다음 위치의 먼지량(임시저장)
    ca, na = 0, table[r1][c1]
    table[r1][c1] = 0
    cr, cc = r1, c1
    # 2. 공기 정화 : 제자리로 돌아올 때 까지
    while True:
        ca = na
        nr = cr + dr[i]
        nc = cc + dc[i]
        # 더 이상 갈 수 없을 때, 방향 전환
        if nr < 0 or nc < 0 or nr >= R or nc >= C:
            i += 1
            continue
        # 다음 위치가 공기청정기면 정화 종료
        if table[nr][nc] == -1: break
        # 다음 위치의 먼지량 임시저장
        na = table[nr][nc]
        # 다음 위치의 먼지량 현재 저장된 먼지량으로 갱신(먼지 이동)
        table[nr][nc] = ca
        # 탐색 위치 이동
        cr, cc = nr, nc

    # 아래쪽 공기청정기 초기값 설정
    i += 1
    ca, na = 0, table[r2][c2]
    table[r2][c2] = 0
    cr, cc = r2, c2
    while True:
        ca = na
        nr = cr + dr[i]
        nc = cc + dc[i]
        # 더 이상 갈 수 없을 때, 방향 전환
        if nr < 0 or nc < 0 or nr >= R or nc >= C:
            i += 1
            continue
        # 다음 위치가 공기청정기면 정화 종료
        if table[nr][nc] == -1: break
        # 다음 위치의 먼지량 임시저장
        na = table[nr][nc]
        # 다음 위치의 먼지량 현재 저장된 먼지량으로 갱신(먼지 이동)
        table[nr][nc] = ca
        # 탐색 위치 이동
        cr, cc = nr, nc

ans = 0
for i in range(R):
    ans += sum(table[i])
print(ans + 2)
