import sys
from collections import deque
from copy import deepcopy

# 탐색 순서 = 왼-위-오
dr = [0, -1, 0]
dc = [-1, 0, 1]


# 주어진 궁수 위치에서 몬스터 찾는 함수
def search_monster(r, c):
    # 중복 탐색 방지를 위한 방문배열
    visit = list([0] * M for _ in range(N))
    q = deque()
    # 바로 앞 몬스터 우선 탐색
    cr, cc = r - 1, c
    if graph_copy[cr][cc]:
        return [True, cr, cc]
    else:
        # 바로 앞 몬스터 위치부터 탐색 시작(궁수 위치에서 좌우 탐색x)
        q.append((cr, cc, D - 1))
        visit[cr][cc] = 1

    # 탐색
    while q:
        cr, cc, cd = q.popleft()
        for d in range(3):
            nr, nc, nd = cr + dr[d], cc + dc[d], cd - 1
            # 탐색 가능 거리 체크
            if nd == -1: continue
            # 범위 체크
            if nr >= N or nr < 0 or nc >= M or nc < 0: continue
            # 방문 체크
            if visit[nr][nc]: continue
            # 몬스터 발견 성공!
            if graph_copy[nr][nc]:
                return [True, nr, nc]
            # 발견 못하면 계속 탐색
            else:
                q.append((nr, nc, nd))
                visit[nr][nc] = 1
    # 몬스터 발견 실패!
    return [False]


# 입력값
N, M, D = map(int, sys.stdin.readline().split())
graph_origin = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]

# 초기값
ans = 0

# 1. 궁수 col 위치 선정 (3마리 -> 3중 for)
for first in range(0, M-2):
    for second in range(first + 1, M-1):
        for third in range(second + 1, M):
            # 현재 3명의 궁수 위치 조합에서 kill count와 그래프(맵)
            kill_cnt = 0
            graph_copy = deepcopy(graph_origin)
            # 2. 궁수 row 위치 선정(게임 진행에 따라 위로 한칸씩 이동, N ~ 1번 행까지)
            for row in range(N, 0, -1):
                # 결과 저장
                res = list()
                res.append(search_monster(row, first))
                res.append(search_monster(row, second))
                res.append(search_monster(row, third))
                # 결과 처리(모든 궁수는 동시에 공격하며 같은 적이 여러 궁수에게 공격당할 수 있음으로)
                for i in range(3):
                    # 몬스터 찾은 경우
                    if res[i][0]:
                        r, c = res[i][1], res[i][2]
                        # 이미 죽었는지 확인
                        if not graph_copy[r][c]: continue
                        # 몬스터 죽이기
                        graph_copy[r][c] = 0
                        # kill count 증가
                        kill_cnt += 1
            # 정답 도출(최대값)
            if kill_cnt > ans:
                ans = kill_cnt
print(ans)
