import sys

sys.setrecursionlimit(10 ** 9)

preoder = []


def postorder(start, end):
    if start > end:
        return
    mid = end + 1
    for i in range(start + 1, end + 1):
        if preoder[i] > preoder[start]:
            mid = i
            break
    postorder(start + 1, mid - 1)
    postorder(mid, end)
    print(preoder[start])


while True:
    try:
        num = int(input())
        preoder.append(num)
    except:
        break
postorder(0, len(preoder) - 1)


