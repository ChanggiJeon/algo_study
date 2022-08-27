# 입력값
n = int(input())
tree = {}
for _ in range(n):
    root, left, right = map(str, input().split())
    # {root : [left, right]}
    tree[root] = [left, right]


# 전위 순회 : 루 - 왼 - 오
def preorder(char):
    if char != '.':
        print(char, end='')
        preorder(tree[char][0])
        preorder(tree[char][1])


# 중위 순회 : 왼 - 루 - 오
def inorder(char):
    if char != '.':
        inorder(tree[char][0])
        print(char, end='')
        inorder(tree[char][1])


# 후위 순회 : 왼 - 오 - 루
def postorder(char):
    if char != '.':
        postorder(tree[char][0])
        postorder(tree[char][1])
        print(char, end='')


preorder('A')
print()
inorder('A')
print()
postorder('A')
