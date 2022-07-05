a = int(input())
jump = [list(map(int,input().split())) for _ in range(a)]
# dp에 기록하는 것은 각 좌표의 방문회수이다
dp = [[0] * a for _ in range(a)]
# 그리고 시작점은 무조건 한번은 방문한다.
# 그리고 점프 포인트가 마이너스가 없고 방향이 우,하 2가지 밖에 없으모로
# 돌아갈 일도 없다.
# 따라서 시작점의 방문횟수는 1로 고정이다
dp[0][0] = 1
for i in range(a):
    for j in range(a):
        # 목적지에 도착하면 탈출
        # 탈출하지않으면 밑의 조건문에서 
        # 불필요한 방문회수 추가
        if [i, j] == [a - 1, a - 1]:
            print(dp[i][j])
            break
        # 현재 좌표의 점프력
        jp = jump[i][j]
        # 아래와 같은 방식으로 답이 성립하는 이유는
        # 진행방향이 아래, 오른쪽 뿐이고 점프계수가 0이상이기 때문에
        # 시작점을 거치지 않은 좌표는 방문횟수가 추가 될 수 없다.
        # 아래로 갈 수 있을 때
        if i + jp < a:
            dp[i + jp][j] += dp[i][j]
        # 오른쪽으로 갈 수 있을 때
        if j + jp < a:
            dp[i][j + jp] += dp[i][j]