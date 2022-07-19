import sys
input = sys.stdin.readline
a = int(input())
cla = [list(map(int, input().split())) for i in range(a)]
cla.sort(key = lambda x: (x[1],x[0]))
e = cla[0][1]
cnt = 1
# print(cla)
for i in range(1, a):
    if cla[i][0] >= e:
        e = cla[i][1]
        cnt += 1
print(cnt)
