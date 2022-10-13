import sys

# 입력값
n, m = map(int, sys.stdin.readline().split())
edges = []
for _ in range(m):
    # a는 출발점, b는 도착점, c는 가중치
    a, b, c = map(int, sys.stdin.readline().split())
    edges.append((a, b, c))

# 초기값
INF = int(1e9)
dist = [INF] * (n + 1)
# 자기 자신은 0
dist[1] = 0


def bellman_ford():
    for i in range(n):
        for a, b, c in edges:
            # dist[a]가 무한이 아니다 -> 시작점에서 a로 가는 경로가 존재한다.
            # dist[b]가 dist[a] + c보다 크다. -> a를 거쳐서 b로 가는 게 더 빠르다.
            if dist[a] != INF and dist[b] > dist[a] + c:
                # 갱신해야하는데 n번째다? -> 음의 순환 존재
                if i == n - 1:
                    return False
                # a를 거쳐서 간다.
                dist[b] = dist[a] + c
    # n번째에 갱신이 되지 않았음으로 통과!
    return True


if not bellman_ford():
    print(-1)
else:
    for d in dist[2:]:
        if d != INF:
            print(d)
        else:
            print(-1)