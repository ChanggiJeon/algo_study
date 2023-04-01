import sys
sys.stdin = open("test.txt", "r")


def search(mid):
    if longest > mid:
        return 10001, 0
    sum_p = 0
    cnt = 0
    for piece in pieces[::-1]:
        sum_p += piece
        if sum_p > mid:
            sum_p = piece
            cnt += 1
    if cnt == c:
        return cnt, sum_p
    else:
        return cnt, pieces[0]


l, k, c = map(int, input().split())
cuttingPosition = [0, *sorted([*map(int, input().split())]), l]  # [0, 4, 5, 9]
pieces = [cuttingPosition[i+1] - cuttingPosition[i]
          for i in range(k+1)]  # [4, 1, 4]
longest = max(pieces)

left = 0
right = l
while left <= right:
    mid = (left + right) // 2
    cnt, cut_L = search(mid)
    if cnt <= c:  # 더 작게 자를 수 있는 경우
        result_length = mid
        result_location = cut_L
        right = mid - 1
    else:
        left = mid + 1

print(result_length, result_location)

print(pieces)
