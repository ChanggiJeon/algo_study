a = int(input())
travel = [list(map(int,input().split())) for _ in range(a)]
# 최소값을 구하는 것이게 최초의 값은 나올 수 있는 최대치 이상
min_value = 10000000


def dfs_backtracking(start, next, value, visited):
    global min_value

    # 방문이력의 수가 전체 포인트 수가 됐을 때
    # 즉 종료조건
    if len(visited) == a:
        # 여기서 거리비용이 0인 경우는 시작지점을 의미한다
        # 즉 시작 지점이 아니면 체크해본다는 것
        # 코드를 if next != start도 가능해보임
        if travel[next][start] != 0:
            # 현재까지의 최소 비용과 기록된 비용 중 작은 것을 도출
            min_value = min(min_value, value + travel[next][start])
            # 익숙한 코드는 아래와 같음
            # if min_value > value + travel[next][start]:
            #     min_value = value + travel[next][start]
        # 여기 까지 왔으면 재귀 종료
        return
    # 현재 포인트에서 갈 수 있는 모든 경우를 체크해보자
    for i in range(a):
        # 비용이 0이 나온다는 것은 시작지점이니 제외
        # 그리고 방문이력에 아직 없는 포인트이어야 하고
        # 현재까지의 비용이 최소비용보다 작아야함 다 순회하지 않았는데 최소값보다 크다면 
        # 목표에서 벗어남
        if travel[next][i] != 0 and i not in visited and value < min_value:
            # 방문도장을 찍고
            visited.append(i)
            # 현재 포인트를 도장 찍인 경우로 다시 탐색
            dfs_backtracking(start, i, value + travel[next][i], visited)
            # 탐색이 끝나면 지워주기
            visited.pop()

for i in range(a):
    dfs_backtracking(i, i, 0, [i])

print(min_value)
