import sys
sys.stdin = open("test.txt", "r")

n, m = map(int, input().split())

words = []
sumWords = 0
wordsOrder = []  # 단어 첫 글자를 아스키로

for i in range(n):
    word = input()
    words.append(word)
    wordsOrder.append(ord(word[0]))
    sumWords += len(word)


restNum = m - sumWords
gapWords = restNum // (n-1)  # 공통적으로 단어 사이에 들어갈 _ 수
plusWordsNum = restNum % (n-1)  # 앞에 _가 하나 더 들어가야할 단어
wordsOrderSort = sorted(wordsOrder)
res = words[0]

for i in range(1, n):
    addCheck = 0
    for j in range(plusWordsNum):
        if addCheck == 0:
            if ord(words[i][0]) >= 97 and ord(words[i][0]) == wordsOrderSort[j]:
                res += '_'*(gapWords+1)
                res += words[i]
            else:
                res += '_'*(gapWords)
                res += words[i]
            addCheck = 1

print(res)
