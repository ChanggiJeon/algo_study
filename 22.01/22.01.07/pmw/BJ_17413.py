'''
data 입력
 n = int(input())  : input()의 return 은 string이어서 형변환 해야됨 ->하지만 느림

import sys
data = sys.stdin.readline().rstrip() : 줄바꿈기호제거를 위해 rstrip 사용

'''

test = input()
reverseWord = []
noReverseWord = []
answer = ""
flag = False
for i in test:
    if (i == "<"):
        flag = True
        reverseWord.reverse()

        answer = answer + "".join(reverseWord)
        reverseWord = []
    if (flag == True):
        if (i == ">"):
            flag = False

        noReverseWord.append(i)
        answer = answer + "".join(noReverseWord)
        noReverseWord = []
        continue
    if (flag == False):
        if (i == " "):
            reverseWord.reverse()
            answer = answer + "".join(reverseWord) + " "
            reverseWord = []
            continue
        else:
            reverseWord.append(i)

reverseWord.reverse()
answer = answer + "".join(reverseWord)
print(answer)