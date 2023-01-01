# 조합
from itertools import combinations

l, c = map(int, input().split(' '))

vowels = ['a', 'e', 'i', 'o', 'u']

array = input().split(' ')
array.sort() # 사전식

for passwords in combinations(array, l):
    cnt = 0
    for pwd in passwords:
        if pwd in vowels:
            cnt += 1 # 모음 개수
    if cnt >= 1 and cnt <= l - 2:
        print(''.join(passwords))
