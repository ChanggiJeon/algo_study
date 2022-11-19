import sys

sys.setrecursionlimit(10 ** 7)


def solution(nodeinfo):
    num = [0] * len(nodeinfo)
    for i in range(len(nodeinfo)):
        num[i] = nodeinfo[i][0]
    nodeinfo.sort(key=lambda x: (-x[1], x[0]))
    sortNum = [0] * len(nodeinfo)
    for i in range(len(nodeinfo)):
        sortNum[i] = nodeinfo[i][0]
    prearr = preorder(sortNum)
    postarr = postorder(sortNum)
    for i in range(len(sortNum)):
        prearr[i] = num.index(prearr[i]) + 1
        postarr[i] = num.index(postarr[i]) + 1

    answer = [prearr, postarr]
    return answer


def preorder(arr):
    mid = arr[0]
    larr = []
    rarr = []
    for i in range(1, len(arr)):
        if arr[i] < mid:
            larr.append(arr[i])
        else:
            rarr.append(arr[i])
    if len(larr) > 0:
        larr = preorder(larr)
    if len(rarr) > 0:
        rarr = preorder(rarr)
    return [mid] + larr + rarr


def postorder(arr):
    if len(arr) <= 1:
        return arr
    mid = arr[0]
    larr = []
    rarr = []
    for i in range(1, len(arr)):
        if arr[i] < mid:
            larr.append(arr[i])
        else:
            rarr.append(arr[i])
    if len(larr) > 0:
        larr = postorder(larr)
    if len(rarr) > 0:
        rarr = postorder(rarr)
    return larr + rarr + [mid]