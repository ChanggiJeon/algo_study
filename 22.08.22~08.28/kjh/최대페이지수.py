# 입력값
n, m = map(int, input().split())
chapter_arr = [list(map(int, input().split())) for _ in range(m)]

# 초기값
DP = [0] * (n + 1)

# 풀이
# 조건 : day, 가치 : pages
for i in range(m):
    day, pages = chapter_arr[i]
    # 한번 읽은 챕터는 다시 읽지 않음으로 뒤에서부터 연산
    for j in range(n, day-1, -1):
        # 현재 값보다 day 만큼 이전날에 읽어서 누적한 pages 값이 더 크면 갱신
        if DP[j-day] + pages > DP[j]:
            DP[j] = DP[j-day] + pages
print(max(DP))