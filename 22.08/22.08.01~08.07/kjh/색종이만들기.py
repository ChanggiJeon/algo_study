def solve(cr, cc, k):
    global white, blue
    # cr, cc = 시작점, k = 이동거리, c = 색상(0 or 1)
    c = arr[cr][cc]

    # 시작점부터 이동거리만큼 탐색
    for i in range(cr, cr + k):
        for j in range(cc, cc + k):
            # 다르면 조각내서 재귀
            if arr[i][j] != c:
                half = k//2
                solve(cr, cc, half)
                solve(cr, cc + half, half)
                solve(cr + half, cc, half)
                solve(cr + half, cc + half, half)
                return
    # 모든 조각이 같은 색상이거나 k가 1일 때 카운트
    if c:
        blue += 1
        return
    else:
        white += 1
        return


# 입력값
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

# 초기값
white = 0
blue = 0

# 실행
solve(0, 0, n)

# 출력
print(white)
print(blue)