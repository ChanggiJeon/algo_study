# 입력값
# n, m = map(int, input().split())
# table = [[0] * (n + 1)]
# table.extend([[0] + list(map(int, input().split())) for _ in range(n)])
# list_xy = [list(map(int, input().split())) for _ in range(m)]

# 풀이 : 각 구간을 순회하면서 합을 구한다. -> m이 큰 경우 시간 초과 발생
# while list_xy:
#     # 초기값
#     x1, y1, x2, y2 = list_xy.pop(0)
#     ans = 0
#     cr, cc = x1, y1
#     while True:
#         # 누적합
#         ans += table[cr][cc]
#
#         # 종료조건 : 마지막 좌표 도착 시
#         if cr == x2 and cc == y2:
#             break
#
#         # 좌표 이동
#         if cc + 1 <= y2:
#             cc += 1
#         else:
#             cc = y1
#             cr += 1
#     print(ans)

# 참조 : https://velog.io/@ready2start/Python-백준-11660-구간-합-구하기-5
# 풀이2 : 구간 합(prefix sum) = DP
# DP 배열로 (1,1)에서 (r,c)까지의 구간합을 계산하여 좌표가 주어질 때 한번의 수식으로 답을 찾는다.

# input().split() -> 시간초과
from sys import stdin

# 입력값
n, m = map(int, stdin.readline().split())
table = [[0] * (n + 1)]
table.extend([[0] + list(map(int, stdin.readline().split())) for _ in range(n)]) # 0열, 0행 0으로 채우기

# (n+1) * (n+1) DP 만들기
DP = [[0] * (n + 1) for _ in range(n + 1)]
for i in range(1, n + 1):
    for j in range(1, n + 1):
        # DP 위 + DP 왼 - DP 위왼 + table 값
        DP[i][j] = DP[i-1][j] + DP[i][j-1] - DP[i-1][j-1] + table[i][j]
for _ in range(m):
    sr, sc, er, ec = map(int, stdin.readline().split())
    print(DP[er][ec] - DP[er][sc - 1] - DP[sr - 1][ec] + DP[sr - 1][sc - 1])