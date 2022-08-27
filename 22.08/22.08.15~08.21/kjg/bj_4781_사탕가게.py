import sys
input = sys.stdin.readline


while True:
    a = input().rstrip().rsplit()
    n, cost = int(a[0]), float(a[1])
    if n == 0 and cost == 0.00:
        break
    # 각 코스트 마다 최대값을 확인하기 위해 정수로 변환
    cost = int(cost * 100)
    k_arr = []
    p_arr = []
    for i in range(n):
        b = input().split()
        kcal, pay = int(b[0]), int(float(b[1]) * 100 + 0.5)
        k_arr.append(kcal)
        p_arr.append(pay)
    
    # 돈을 기준으로 dp를 쌓아 올림
    dp = [0] * 10001

    for i in range(1,cost + 1):
        for j in range(n):
            candy_k = k_arr[j]
            candy_p = p_arr[j]

            # 금액이 현재 비용보다 낮을 경우 확인할 필요가 없다                
            if i < candy_p:
                continue

            # 현재 비용의 dp는 기록되었던 현재 코스트의 칼로리와
            # 현재 계산되는 칼로리와 총 코스트에서 현재 코스트를 뺀 비용의 칼로리를 더한 값 중
            # 큰 쪽을 선택한다
            dp[i] = max(dp[i], candy_k + dp[i - candy_p])
    print(dp[cost])
