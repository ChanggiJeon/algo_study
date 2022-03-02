'''
data 입력
 n = int(input())  : input()의 return 은 string이어서 형변환 해야됨 ->하지만 느림

import sys
data = sys.stdin.readline().rstrip() : 줄바꿈기호제거를 위해 rstrip 사용

'''

import sys

T = sys.stdin.readline().rstrip() # 테스트케이스 입력
T=int(T)
for i in range(T):
    data = []
    result = ""
    sentence = sys.stdin.readline().rstrip()
    index = 0
    for j in sentence:
        index=index+1

        if j == " ":
            data.reverse()
            data.append(j)
            result = result + ''.join(s for s in data)
            data = []
            continue
        elif index==len(sentence):
            data.append(j)
            data.reverse()
            result = result + ''.join(s for s in data)
        data.append(j)
    print(result)



