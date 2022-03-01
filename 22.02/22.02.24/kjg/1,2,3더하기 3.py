# 메모리 문제가 생겼는데 그 이유가 10000단위만 넘어가도 숫자의 크기 어마무시해서 
# 생기는 문제였다.
N = int(input())
num= [int(input()) for _ in range(N)]
dp = [0] * 1000001
dp[1],dp[2],dp[3] = 1,2,4
for a in range(4,max(num)+1):
    dp[a] = (dp[a-3]+dp[a-2]+dp[a-1])%1000000009

for i in range(len(num)):
    print(dp[num[i]])