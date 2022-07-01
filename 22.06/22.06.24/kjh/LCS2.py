# 참고 : https://hjp845.tistory.com/29
# 키포인트 : LCS = 2차원 배열 DP
# 키포인트 : DP[-1][-1]이 가장 큰값임으로 여기서부터 0이 될때까지 거슬러 올라가면서 문자열 조합을 완성한다.
a = input()
b = input()

# 거꾸로 출발해서 0에 반드시 도달해야함으로 1열과 1행을 0으로 감싸준다.
dp = [[0 for i in range(len(a) + 1)] for j in range(len(b) + 1)]

# 2차원 배열을 순회하면서
for i in range(1, len(b) + 1):
    for j in range(1, len(a) + 1):
        # 두 문자가 같으면 // a와 b는 0으로 감싸져있지 않음으로 -1을 해줘야함
        if a[j - 1] == b[i - 1]:
            # 현재위치에 대각선 위에 값 + 1
            dp[i][j] = dp[i - 1][j - 1] + 1
        # 두 문자가 다르면
        else:
            # 왼쪽과 위쪽 중 큰 값을 대입(이것이 DP이니까☆)
            dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

def findit():
    ans = ''
    # 맨 오른쪽 아래에서 출발
    now = dp[-1][-1]
    y = len(dp) - 1
    x = len(dp[0]) - 1
    # 위치한 값이 0이면 끝
    while now != 0:
        # 현재 위치한 값이 왼쪽과 위쪽의 값보다 모두 1이 작다? = 현재 위치한 값은 a와 b가 일치! 왜냐하면 DP배열에서 두 문자가 같은 경우에 해당함으로
        if dp[y][x - 1] == now - 1 and now - 1 == dp[y - 1][x]:
            # 문자열 앞쪽에 추가
            ans = a[x - 1] + ans
            # 문자 하나 찾았으니까 count 하나 줄이고 좌표 대각선 왼쪽 위로 이동
            now -= 1
            y -= 1
            x -= 1
        # 모두 1이 작지 않은 경우는 무조건 왼쪽과 위 중 하나가 더 큰 경우임
        else:
            # 위가 더 크면
            if dp[y - 1][x] > dp[y][x - 1]:
                # 위로 이동
                y -= 1
            # 왼쪽이 더 크면
            else:
                # 왼쪽으로 이동
                x -= 1
    # 합쳐진 문자열 반환
    return ans

# LCS의 길이는 dp배열의 마지막 값
print(dp[-1][-1])
# LCS의 문자열은 return 값(ans)
print(findit())