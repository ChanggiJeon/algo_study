# 전위 순회(리스트)를 트리로 만드는 함수
def make_tree(pre_order):
    global tree
    base_root = pre_order[0]
    tree[base_root] = [0,0,0] # [root, left, right]
    root = base_root

    for i in range(1, len(pre_order)):
        # 현재 값이 루트보다 작으면 : 루트의 왼쪽에 넣고 루트값을 갖는 노드 생성
        cur_val = pre_order[i]
        if cur_val < root:
            tree[root][1] = cur_val
            tree[cur_val] = [root, 0, 0]
            root = cur_val
        # 현재 값이 루트보다 크면
        # 1. 루트의 루트보다 큰지 확인하고 더 크면 계속 타고 올라가서 더 작은 경우 오른쪽 노드 생성, 루트 갱신
        # 2. base_root까지 갔는데 더 큰 값이 없는 경우 base_root의 오른쪽 값으로 추가 후 루트 갱신
        else:
            while True:
                # 값이 루트의 루트 보다 더 크면
                if cur_val > tree[root][0]:
                    # base_root check
                    if tree[root][0] == base_root:
                        tree[base_root][2] = cur_val
                        tree[cur_val] = [base_root, 0, 0]
                        root = cur_val
                        break
                    # 루트의 루트 계속 타고 올라감
                    root = tree[root][0]
                # 값이 루트의 루트 보다 더 작으면
                else:
                    # 오른쪽이 비었는 지 확인
                    if tree[root][2] == 0:
                        # 오른쪽 값 넣고
                        tree[root][2] = cur_val
                        # 노드 생성하고
                        tree[cur_val] = [root, 0, 0]
                        # 이동
                        root = cur_val
                        break
                    # 안비었으면
                    else:
                        # 루트의 루트 계속 타고 올라감
                        root = tree[root][0]


# 트리를 후위순회 하고 출력하는 함수
def solve(node):
    if node == 0:
        return
    solve(tree[node][1])
    solve(tree[node][2])
    print(node)


# 입력값
arr = list()
i = 0
while i <= 10000:
    try:
        arr.append(int(input()))
    except:
        break
    i += 1

# 초기값
tree = dict()

# 풀이
make_tree(arr)
solve(arr[0])