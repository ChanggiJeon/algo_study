
chain = []
point = [0] * 4
for _ in range(4):
    chain.append(list(input()))
d = [-1,1]

# 해당 문제의 로직은
# 1. 대상 톱니바퀴가 시계/반시계 방향으로 회전한다
# 2. 이 때 좌우에 있는 톱니는 2번 혹은 6번에 상태에 맞춰 대상 톱니바퀴의 반대로 회전한다
# 2-1 톱니의 성질은 N,S 두 가지가 있으면 맞닿아 있는 톱니의 성질이 같을 경우  회전한다
# 3. 좌우의 톱니가 회전 하게 된다면 회전 하게 되는 톱니기준으로 2-1을 반복한다
# 3-1 만약 이미 회전한 상태면 적용하지 않는다
# 4. 모든 톱니가 회전을 마쳤을 때 각 톱니바퀴의 최상단에 있는 성질을 기준으로 점수를 계산한다

def spinCircle(num,spin,visit):
    target = point[num]
    visit[num] = 1
    # 대상 톱니가 시계방향으로 회전 할 때
    if spin == 1:
        point[num] = (point[num] + 7) % 8
        if num + 1 < 4 and not visit[num + 1]:
            if chain[num][(target + 2) % 8] != chain[num + 1][(point[num + 1] + 6) % 8]:
                spinCircle(num + 1, -1,visit)
        if num - 1 >= 0 and not visit[num - 1]:
            if chain[num][(target + 6) % 8] != chain[num - 1][(point[num - 1] + 2) % 8]:
                spinCircle(num - 1, -1,visit)
    # 대상 톱니가 반시계 방향으로 회전 할 때
    elif spin == -1:
        point[num] = (point[num] + 1) % 8
        if num + 1 < 4 and not visit[num + 1]:
            if chain[num][(target + 2) % 8] != chain[num + 1][(point[num + 1] + 6) % 8]:
                spinCircle(num + 1, 1,visit)
        if num - 1 >= 0 and not visit[num - 1]:
            if chain[num][(target + 6) % 8] != chain[num - 1][(point[num - 1] + 2) % 8]:
                spinCircle(num - 1, 1,visit)


n = int(input())
for _ in range(n):
    num, spin = map(int, input().split())
    visit = [0] * 4
    spinCircle(num - 1, spin, visit)
ans = 0
for i in range(4):
    if chain[i][point[i]] == '1':
        ans += 2 ** i
print(ans)

