'''
공략
0으로 구성된 길이 1000의 리스트(1 <= AI <= 1000)에
입력받은 리스트의 수를 하나씩 카운팅하며 계산
??? 뭔가 설명하기가 너무 힘드네요
'''
N = int(input())
lst = list(map(int,input().split()))
result = [0]*1001

for i in lst:
    result[i] = max(result[:i])+i

print(max(result))