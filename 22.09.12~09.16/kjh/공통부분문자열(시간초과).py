# 입력값
word_A = input()
word_B = input()

# 초기값 : 1차원배열 -> 시간초과
length_A = len(word_A)
length_B = len(word_B)
DP = [0] * length_B

# 풀이 : A의 글자를 하나씩 뽑아서 B의 글자에 대입. 같은 글자가 연속되는대로 각 글자의 DP값 갱신(최대값)
for ci in range(length_A):
    for cj in range(length_B):
        ni, nj = ci, cj
        cnt = 0
        # 같은 글자면 DP 갱신
        while word_A[ni] == word_B[nj]:
            cnt += 1
            if DP[nj] < cnt:
                DP[nj] = cnt
            ni += 1
            nj += 1
            if ni == length_A or nj == length_B:
                break
print(max(DP))