# 1 <= N <= 26으로 메모리/시간 초과를 고려하지 않고 생각해보았다.
# 각각을 큐든 스택이든 처리를 한다고 했을 때, 문제는 방문처리.. 알파벳을 방문처리하려면? 아스키코드를 활용해보자!
# A~Z = 65 ~ 90 / 숫자 -> 아스키 : chr() / 아스키 -> 숫자 : ord()
# 전위 순회 : 루트를 하나씩 찾아가면된다. -> BFS, 큐
# 중위 순회 : 루트를 타고 들어가서 더이상 들어갈 수 없으면 저장하면서 올라오면서 저장하고 오른쪽을 확인한다 -> DFS, 스택
# 후위 순회 : 루트를 타고 들어가서 더이상 들어갈 수 없으면 저장하면서 올라오면서 오른쪽을 확인해서 저장하고 다시 올라와서 저장한다. -> DFS, 스택

from collections import deque

# 입력값
n = int(input())
tree = {}
for _ in range(n):
    root, left, right = map(str, input().split())
    # {root : [left, right]}
    tree[root] = [left, right]

# 전위 순회 : 루 - 왼 - 오
preorder = ''
visit = [0] * 91
q = deque()
q.append('A')
while q:
    cur_node = q.popleft()
    visit[ord(cur_node)] = 1
    # 루트 추가
    preorder += cur_node
    # 왼쪽 추가
    left = tree[cur_node][0]
    if left != '.' and not visit[ord(left)]:
        q.appendleft(left)
    # 오른쪽 추가
    right = tree[cur_node][1]
    if right != '.' and not visit[ord(right)]:
        q.append(right)
print(preorder)

# 중위 순회 : 왼 - 루 - 오
inorder = ''
stack = list()
stack.append('A')
# 방문 초기화
visit = [0] * 91
while stack:
    # 왼쪽부터 담아야함으로 pop하지 않고 조회
    cur_node = stack[-1]
    left = tree[cur_node][0]
    # 왼쪽 마지막 노드가 아닌 경우, 스택에 쌓기
    if left != '.' and not visit[ord(left)]:
        stack.append(left)
        continue
    # 왼쪽 마지막 노드인 경우, pop해서 답에 추가하고 방문처리, 오른쪽 노드가 있을 경우 스택에 쌓기
    else:
        inorder += stack.pop()
        visit[ord(cur_node)] = 1
        right = tree[cur_node][1]
        if right != '.' and not visit[ord(right)]:
            stack.append(right)
print(inorder)

# 후위 순회 : 왼 - 오 - 루
postorder = ''
stack = list()
stack.append('A')
visit = [0] * 91
while stack:
    # 중위와 동일
    cur_node = stack[-1]
    left = tree[cur_node][0]
    if left != '.' and not visit[ord(left)]:
        stack.append(left)
        continue
    # 왼쪽 마지막 노드인 경우, pop해서 답에 추가하고 방문처리
    # 중위와 차이점 : 현재 노드에서 방문하지 않은 오른쪽 노드가 있는 경우 우선 처리
    else:
        right = tree[cur_node][1]
        if right != '.' and not visit[ord(right)]:
            stack.append(right)
            continue
        postorder += stack.pop()
        visit[ord(cur_node)] = 1
print(postorder)