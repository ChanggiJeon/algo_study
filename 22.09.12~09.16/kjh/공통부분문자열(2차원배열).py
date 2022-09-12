# 입력값
word_A = ' ' + input()
word_B = ' ' + input()

# 초기값 : 2차원 배열 DP 설명 -> https://dailylifeofdeveloper.tistory.com/114
length_A = len(word_A)
length_B = len(word_B)
DP = list([0] * length_B for _ in range(length_A))
ans = 0

# 풀이 : i, j에서 글자가 같으면 i-1, j-1의 DP값에 +1을 해서 넣어준다.(연속된 값임으로)
for i in range(1, length_A):
    for j in range(1, length_B):
        if word_A[i] == word_B[j]:
            DP[i][j] = DP[i-1][j-1] + 1
            # 해당 값이 최대값인 경우 갱신
            if DP[i][j] > ans:
                ans = DP[i][j]
print(ans)