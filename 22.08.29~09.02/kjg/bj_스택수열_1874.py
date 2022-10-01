import sys
input = sys.stdin.readline

n = int(input())
arr = []
pm = []
cnt = 1
tf = True
for i in range(n):
    target = int(input())
    while cnt <= target:
        pm.append('+')
        arr.append(cnt)
        cnt += 1
    if arr[-1] == target:
        arr.pop()
        pm.append('-')
    else:
        tf = False
if tf:
    for p in pm:
        print(p)
else:
    print('NO')    
