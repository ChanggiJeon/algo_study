a = int(input())
tree = [0] * a
for _ in range(a):
    node = input().split()
    idx, l, r = ord(node[0]) - 65, node[1], node[2]
    tree[idx] = [l, r]
print(tree)
def preorder(cnt):
    print(chr(cnt + 65), end = '')
    if tree[cnt][0] != '.':
        preorder(ord(tree[cnt][0]) - 65)
    if tree[cnt][1] != '.':
        preorder(ord(tree[cnt][1]) - 65)

def inorder(cnt):
    if tree[cnt][0] != '.':
        inorder(ord(tree[cnt][0]) - 65)
    print(chr(cnt + 65), end = '')
    if tree[cnt][1] != '.':
        inorder(ord(tree[cnt][1]) - 65)
    
def postorder(cnt):
    if tree[cnt][0] != '.':
        postorder(ord(tree[cnt][0]) - 65)
    if tree[cnt][1] != '.':
        postorder(ord(tree[cnt][1]) - 65)
    print(chr(cnt + 65), end = '')
preorder(0)
print()
inorder(0)
print()
postorder(0)