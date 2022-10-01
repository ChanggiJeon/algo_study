import sys
from heapq import heappop, heappush

# 입력값
n, m, x = map(int, sys.stdin.readline().split())
# n : 학생의 수
# m : 도로의 수
# x : 파티 장소

graph = [[] for _ in range(n + 1)]
for _ in range(m):
    # value : A, B, T -> 시작점, 도착점, 가중치(시간)
    a, b, t = map(int, sys.stdin.readline().split())
    graph[a].append((t, b))

# 초기값
ans = 0
INF = int(1e9)

# 풀이 : heapq를 활용한 다익스트라 알고리즘
def dijkstra(start_island, end_island):
    # index = student / value = time(최단거리)인 리스트
    student_time = [INF] * (n + 1)
    q = list()
    # 시작값 설정
    student_time[start_island] = 0
    heappush(q, (student_time[start_island], start_island))
    # start_island에서 모든 노드로 가는 최단 경로 탐색
    while q:
        cur_time, cur_island = heappop(q)
        if cur_island == end_island:
            return student_time[end_island]
        for next_time, next_island in graph[cur_island]:
            # 이동 했을 때 시간이 이동할 위치에 있는 기존 시간보다 작으면 갱신
            time = cur_time + next_time
            if time < student_time[next_island]:
                student_time[next_island] = time
                heappush(q, (student_time[next_island], next_island))


for i in range(1, n+1):
    tmp_ans = dijkstra(i, x)
    tmp_ans += dijkstra(x, i)
    if tmp_ans > ans:
        ans = tmp_ans
print(ans)