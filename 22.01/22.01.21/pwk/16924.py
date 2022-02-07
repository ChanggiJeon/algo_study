dr = [-1,1,0,0]
dc = [0,0,-1,1]

def check(r,c):
    # 좌표부터 상하좌우 탐색, 각 방위의 가능한 길이 탐색
    length = [0,0,0,0]
    for i in range(4):
        nr = r
        nc = c
        while True:
            nr += dr[i]
            nc += dc[i]
            if 0<=nr<N and 0<=nc<M:
                if arr[nr][nc] == '*':
                    length[i] += 1
                else:
                    break
            else:
                break
        # 가능한 길이가 0이면 더이상 볼 필요 없음
        if length[i] == 0:
            return
    # length에서 가장 작은 크기의 십자가 생성, 정답에 해당하는 출력값이 idx를 1부터 샘(row,col에 1추가)
    plan.append([r+1,c+1,min(length)])
    # 십자가 그리기 : 막판에 그려야함
    for i in range(4):
        nr = r
        nc = c
        result[nr][nc] = '*'
        for _ in range(min(length)):
            nr += dr[i]
            nc += dc[i]
            result[nr][nc] = '*'

# 입력
N, M = map(int,input().split())
arr = [list(input()) for _ in range(N)]
# 내가 새로 그릴 배열
result = [['.']*M for _ in range(N)]
# 무지성으로 십자가를 그릴때 어떻게 그릴지[row, col, length]
plan = []

# 상하좌우 1만큼 작은 사각형 각각 탐색
for i in range(1,N-1):
    for j in range(1,M-1):
        if arr[i][j] == '*':
            check(i,j)

# 새로 그린 배열이랑 원본배열이랑 비교
if arr != result:
    print(-1)
else:
    # 십자가 더 많이 적어도 된다했으니까 무지성출력
    print(len(plan))
    for i in plan:
        print(*i)