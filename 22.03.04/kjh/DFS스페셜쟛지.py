# 간선정보 저장하고 주어진 순서대로 방문해보기
# 방문체크하고 방문하는 대로 stack에 쌓기
# 다음 노드로 갈 수 없으면 pop하고 이전노드에서 갈 수 있는지 확인
# stack이 다 빌때까지 다음 노드로 못 간다 = fail
import sys
n = int(sys.stdin.readline())
edges = list([] for _ in range(n+1))
# 간선정보 입력, 양방향
for i in range(n-1):
    from_node, to_node = map(int, sys.stdin.readline().split())
    edges[from_node].append(to_node)
    edges[to_node].append(from_node)

# 방문 순서 따라서 연결되어 있는지 확인하기
arr = list(map(int, sys.stdin.readline().split()))
ans = arr[0]
s = [arr[0]]
for i in range(n-1):
    while True:
        # 종료 조건1. 스택이 다 비면 fail
        if not s:
            ans = 0
            break
        # 종료 조건2. 다음 노드로 갈 수 있는 경우 스택 쌓고 break
        next_node = arr[i + 1]
        if next_node in edges[s[-1]]:
            s.append(next_node)
            break
        # 다음 노드로 갈 수 없으면 pop(이전 노드에서 갈 수 있는지 확인)
        s.pop()
    # fail이면 그만 알아보쟈
    if not ans:
        break
print(ans)

# python3로 제출하면 시간초과나고 pypy3로 제출하면 통과함