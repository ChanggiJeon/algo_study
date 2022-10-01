import sys

# 입력값
N, D = map(int, sys.stdin.readline().split())
graph = list()
for _ in range(N):
    s, e, d = map(int, sys.stdin.readline().split())
    # 도착지가 목적지를 넘어가면 볼 필요 없음
    if e > D: continue
    # 지름길이 그냥 가는것보다 멀면 볼 필요 없음
    if e-s < d: continue
    graph.append((s, e, d))

# 풀이
DP = [D] * (D + 1)
for start, end, dist in graph:
    # 현재 위치에서의 누적거리
    cur_dist = DP[start]
    # 현재 위치의 거리가 갱신되지 않았으면 시작 위치가 곧 누적 거리임(정렬)
    if cur_dist == D:
        cur_dist = start

    # 끝나는 지점부터 현재 지름길로 간 거리가 더 작은 경우 갱신
    for i in range(end, D + 1):
        if DP[i] > cur_dist + dist + (i - end):
            DP[i] = cur_dist + dist + (i - end)

print(DP[D])