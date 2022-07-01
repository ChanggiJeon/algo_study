a = int(input())
for i in range(a):
    m, n = map(int,input().split())
    Max = 1001
    d = 1000000009
    dp = [[0] * Max for _ in range(Max)]

    # dp의 기초는 고정값을 정하는 것이고 여기서 고정값은 만들어야하는 수 1,2,3일 때 뿐이다.
    # 1일때 n개 사용한 경우의 수
    dp[1][1] = 1
    # 2일때 n개 사용한 경우의 수
    dp[2][1] = 1
    dp[2][2] = 1
    # 3일때 n개 사용한 경우의 수
    dp[3][1] = 1 # (3)
    dp[3][2] = 2 # (1,2), (2,1)
    dp[3][3] = 1 # (1,1,1)

    # dp계산이 들어가는 건 고정값을 제외한 수부터
    for i in range(4,Max):
        # 나올 수 있는 사용된 숫자의 갯수는 현재의 숫자를 벗어날 수 없다
        for j in range(1, i + 1):
            dp[i][j] = (dp[i - 1][j - 1] + dp[i - 2][j - 1] + dp [i - 3][j - 1]) % d
    print(dp[m][n])

# 다시 풀어봐야겠다