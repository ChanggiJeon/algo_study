import sys

# 입력값
n, m = map(int, sys.stdin.readline().split())
table = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
# 초기값
# 각 테두리에 있는 구멍의 번호 리스트
left = [i for i in range(1, n+1)]
bottom = [i for i in range(n+1, n+m+1)]
right = [i for i in range(2*n+m, n+m, -1)]
top = [i for i in range(2*n+2*m, 2*n+m, -1)]

ans = list()


# 각 범위 초과 시 해당하는 값을 ans에 누적
def check_ans(i, j):
    if i == n:
        ans.append(bottom[j])
    elif i == -1:
        ans.append(top[j])
    elif j == m:
        ans.append(right[i])
    elif j == -1:
        ans.append(left[i])


def move(cr, cc, dr, dc):
    d = 0
    # 범위 안에 있으면
    while True:
        if 0 <= cr < n and 0 <= cc < m:
            # 거울 아니면 그냥 이동
            if not table[cr][cc]:
                cr += dr[d]
                cc += dc[d]
            # 거울이면 방향 바꿔서 이동
            else:
                d = (d + 1) % 2
                cr += dr[d]
                cc += dc[d]
        # 범위 벗어나면 출구임
        else:
            check_ans(cr, cc)
            break


for k in range(n):
    # 1 ~ n 체크
    cr, cc = k, 0
    # 방향은 오-위
    dr = [0, -1]
    dc = [1, 0]
    move(cr, cc, dr, dc)
for k in range(m):
    # n+1 ~ n+m 체크
    cr, cc = n-1, k
    # 방향은 위-오
    dr = [-1, 0]
    dc = [0, 1]
    move(cr, cc, dr, dc)
for k in range(n-1, -1, -1):
    # n+m+1 ~ 2n+m 체크
    cr, cc = k, m-1
    # 방향은 왼-아래
    dr = [0, 1]
    dc = [-1, 0]
    move(cr, cc, dr, dc)
for k in range(m-1, -1, -1):
    # 2n+m+1 ~ 2n+2m 체크
    cr, cc = 0, k
    # 방향은 아래-왼
    dr = [1, 0]
    dc = [0, -1]
    move(cr, cc, dr, dc)
print(*ans)