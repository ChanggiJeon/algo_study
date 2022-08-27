import sys
sys.setrecursionlimit(10**6)

def recursion(array,target,cnt,idx):
    # print(array)
    if len(target) == 6:
        print(*target)
        return
    for i in range(idx, len(array)):
        recursion(array,target[:]+[array[i]], cnt + 1, i + 1)


while True:
    target = list(map(int,input().split()))
    if len(target) == 1 and target[0] == 0:
        break
    recursion(target[1:],[],0,0)
    print()


