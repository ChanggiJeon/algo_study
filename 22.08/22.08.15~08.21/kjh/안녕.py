# N <= 20임으로 재귀(완전 탐색)로 풀 수 있다.

def solve(hp, joy, idx):
    global ans

    # 중단 조건1 : hp가 0이하로 떨어진 경우 (이전 상태에서 인사 불가능)
    if hp <= 0:
        return

    # 유효한 경우 최댓값 갱신
    if joy > ans:
        ans = joy

    # 중단 조건2 : idx가 범위를 넘어선 경우 (이전 상태까지는 인사 가능)
    if idx == n:
        return

    # 재귀1 : 인사한 경우
    solve(hp - Life[idx], joy + Joy[idx], idx + 1)
    # 재귀2 : 인사 안한 경우
    solve(hp, joy, idx + 1)


# 입력값
n = int(input())
Life = list(map(int, input().split()))
Joy = list(map(int, input().split()))

# 초기값
ans = 0

# 풀이 시작
solve(100, 0, 0)

# 결과 출력
print(ans)