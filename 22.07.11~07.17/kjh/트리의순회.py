# 풀이 참조 : https://my-coding-notes.tistory.com/528

import sys
# 재귀 깊이 제한을 늘려주는 코드(파이썬 기본 제한 1000회)
sys.setrecursionlimit(10**8)

# [From Google]
# 전위 순회(pre_order) : 루트를 먼저 방문 (루트-왼쪽-오른쪽, 최상단 루트에서 출발, 왼쪽이 또다시 루트인경우 왼쪽부터 계속 방문)
# 중위 순회(inorder) : 왼쪽 먼저 방문 (왼쪽-루트-오른쪽, 왼쪽 끝에서 출발)
# 후위 순회(post_order) : 하위 트리 모두 방문 후 루트 방문 (왼쪽-오른쪽-루트)
# 1. 후위 순회의 마지막 노드는 최상단 루트임
# 2. 이를 기점으로 중위의 왼쪽과 오른쪽, 루트를 분할
# 중위 : -----O+++++ -> --O++, O, --O++
# 후위 : -----+++++O -> --++O, --++O, O
# 3. 이를 분할하기 위해 중위는 루트의 인덱스가 필요하고 후위는 분할된 리스트의 사이즈가 필요하다.
# 4. 분할된 두개의 트리를 더이상 분할할 수 없을 때까지 재귀한다.
# 5. 루트를 차례대로 저장하면 전위순회가 완성된다(루트를 먼저 방문)

n = int(input())
in_order = [-1] + list(map(int, input().split()))
post_order = [-1] + list(map(int, input().split()))
# 중위의 각 값에 대한 인덱스를 미리 저장한다. (후에 후위 순회에서 찾은 루트 값으로 위치를 찾기 위함)
in_order_index = [-1] * (n + 1)
for i in range(n + 1):
    in_order_index[in_order[i]] = i

pre_order = []


# 중위 순회의 시작과 끝 위치, 후위 순회의 시작과 끝 위치를 받음
def solve(in_start, in_end, post_start, post_end):
    # 더이상 분할이 불가능한 경우 리턴
    if in_start > in_end or post_start > post_end:
        return
    # 후위 순회의 마지막 노드는 루트임
    root = post_order[post_end]
    # 중위 순회의 루트의 위치에서 시작위치를 빼면 분할된 트리의 사이즈가 나옴
    size = in_order_index[root] - in_start

    # 루트 저장
    pre_order.append(root)

    # 재귀1 - 왼쪽 트리
    solve(in_start, in_order_index[root] - 1, post_start, post_start + size - 1)
    # 재귀2 - 오른쪽 트리
    solve(in_order_index[root] + 1, in_end, post_start + size, post_end - 1)


solve(1, n, 1, n)
print(*pre_order)