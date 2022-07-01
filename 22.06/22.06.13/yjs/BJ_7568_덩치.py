import sys

N = int(input())
man_list = []
for n in range(N):
    man_list.append(list(map(int, sys.stdin.readline().split())))
order = []
for me in man_list:
    height, weight = me
    rank = 1
    for he in man_list:
        if height < he[0] and weight < he[1]:
            rank += 1
    order.append(str(rank))
print(' '.join(order))
