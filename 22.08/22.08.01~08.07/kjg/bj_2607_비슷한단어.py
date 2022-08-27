import sys
input = sys.stdin.readline
n = int(input())
words = [[0 for _ in range(26)] for _ in range(n)]
for i in range(n):
    b = list(input().strip())
    for c in b:
        words[i][ord(c) - ord('A')] += 1

ans = 0
for w in range(1,n):
    plus, minus = 0, 0
    for i in range(26):
        if words[w][i] > words[0][i]:
            plus += words[w][i] - words[0][i]
        else:
            minus += words[0][i] - words[w][i]
    # 아래와 같은 조건식이 되는 이유는 더하거나 빼거나 바꾸거나 이기때문
    if plus < 2 and minus < 2:
        ans += 1
print(ans)
