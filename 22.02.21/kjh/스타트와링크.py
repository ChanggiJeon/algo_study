# 조합 구하는 함수, arr은 n개의 수, r은 뽑을 갯수
def combinations(arr, r):
    for i in range(len(arr)):
        # 하나만 더 뽑으면 되면 끝냄
        if r == 1:
            yield [arr[i]]
        # 더 뽑을 게 남았으면 재귀 (r개의 숫자를 뽑게 됨)
        else:
            for j in combinations(arr[i+1:], r-1):
                # 뽑아서 나온거는 합치기
                yield [arr[i]] + j


n = int(input())
# 0부터 n-1까지 숫자 만들기
arr = [i for i in range(n)]
S = [list(map(int, input().split())) for _ in range(n)]
# 가능한 팀 조합 계산하기
team = []
for c in combinations(arr,n//2):
    team.append(c)

# 팀간 전력의 최솟값 구하기
ans = 99999999999
for i in range(len(team) // 2):
    # 첫번째 조합과 마지막 조합은 서로 여집합
    star = team[i]
    link = team[(-1) - i]
    # 두 조합에서 2명씩 뽑아서 시너지 계산하기
    possible_star = combinations(star, 2)
    possible_link = combinations(link, 2)
    star_power = 0
    link_power = 0
    for r, c in possible_star:
        star_power += S[r][c]
        star_power += S[c][r]
    for r, c in possible_link:
        link_power += S[r][c]
        link_power += S[c][r]

    # 두 팀의 힘의 격차가 ans보다 작으면 교체
    if abs(star_power - link_power) < ans:
        ans = abs(star_power - link_power)
print(ans)