import sys
sys.stdin = open("test.txt", "r")

n, m = map(int, input().split())

words = []
sumWords = 0


for i in range(n):
    word = input()
    words.append(word)
    sumWords += len(word)


restNum = m - sumWords
gapWords = restNum // (n-1)  # 공통적으로 단어 사이에 들어갈 _ 수
plusWordsNum = restNum % (n-1)  # 앞에 _가 하나 더 들어가야할 단어

res = words[0]

for i in range(1, n):
    restNo = n - i - 1
    if words[i][0].islower() and plusWordsNum:
        res += '_'*(gapWords+1)
        res += words[i]
        plusWordsNum -= 1
    elif words[i][0].isupper() and plusWordsNum > restNo:
        res += '_'*(gapWords+1)
        res += words[i]
        plusWordsNum -= 1
    else:
        res += '_'*(gapWords)
        res += words[i]
print(res)
