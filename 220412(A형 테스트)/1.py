even_dr = [-1,-1,-1,0,0,1]
odd_dr = [1,1,1,0,0,-1]
dc = [-1,0,1,-1,1,0]


def solve(cnt, now, cr, cc):
    global ans
    # 인접한 노드의 값 찾기
    near = []
    for i in range(6):
        if cc % 2 == 0:
            nr = cr + even_dr[i]
            nc = cc + dc[i]
        # 홀수면
        else:
            nr = cr + odd_dr[i]
            nc = cc + dc[i]
        # 범위 안에 있고 방문하지 않은 노드에 대하여
        if 0 <= nr < h and 0 <= nc < w and not visit[nr][nc]:
            # 인접한 노드 리스트에 담기
            near.append(cells[nr][nc])
    # 방문 가능한 노드의 수가 남은 cnt보다 많으면 제자리에서 가능한 최댓값 찾기
    if len(near) >= 4-cnt:
        # 인접 노드 값 정렬하여 가능한 최댓값 만들기
        near.sort()
        add_max = 0
        for i in range(4-cnt):
            add_max += near[-i-1]
        # 만들어진 최댓값 더하고 비교
        check_now = now + add_max
        if check_now > ans:
            ans = check_now

    # 종료조건 : cnt = 3일때
    if cnt == 3:
        return

    # 재귀 : 다음 지점으로 이동하여 재귀
    for i in range(6):
        # 인덱스가 짝수면
        if cc % 2 == 0:
            nr = cr + even_dr[i]
            nc = cc + dc[i]
        # 홀수면
        else:
            nr = cr + odd_dr[i]
            nc = cc + dc[i]
        # 범위 안에 있고 방문하지 않은 노드를 방문
        if 0 <= nr < h and 0 <= nc < w and not visit[nr][nc]:
            visit[nr][nc] = 1
            new_now = now + cells[nr][nc]
            solve(cnt + 1, new_now, nr, nc)
            visit[nr][nc] = 0


T = int(input())
for tc in range(1, T+1):
    w, h = map(int, input().split())
    cells = list(list(map(int, input().split())) for _ in range(h))
    visit = list([0] * w for _ in range(h))
    ans = 0
    for r in range(h):
        for c in range(w):
            visit[r][c] = 1
            solve(1, cells[r][c], r, c)
            visit[r][c] = 0
    print(f'#{tc}', ans * ans)