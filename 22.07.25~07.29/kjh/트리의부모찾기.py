# 위에서부터 부모 노드를 찾아내려가면 됨으로 BFS 사용
from collections import deque

# 입력값
n = int(input())
# index = 노드번호, value = 해당 노드에 연결된 노드 리스트
nodes = [[] for _ in range(n + 1)] # 0포함 +1
for _ in range(n-1):
    a, b = map(int, input().split())
    nodes[a].append(b)
    nodes[b].append(a)

# 초기값
# index = 노드번호, value = 해당 노드의 부모 노드
parents_node = [0] * (n + 1)
visit = [0] * (n + 1)
q = deque()
q.append(1)

# q에 저장된 순서대로 자식노드들을 탐색, 부모노드를 현재 노드로 저장, q에 추가
while q:
    cur_node = q.popleft()
    visit[cur_node] = 1
    for nxt_node in nodes[cur_node]:
        if visit[nxt_node] == 0:
            parents_node[nxt_node] = cur_node
            q.append(nxt_node)

# 2번 노드부터 한줄씩 출력
ans = parents_node[2:]
for ans_node in ans:
    print(ans_node)