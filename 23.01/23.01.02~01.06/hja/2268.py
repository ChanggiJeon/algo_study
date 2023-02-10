def sum_acc(num):
    result = 0
    while num > 0:
        result += tree[num]
        num -= (num & -num)
    return result

def sum_s_e(start, end):
    return sum_acc(end) - sum_acc(start-1)

def update(num, dif):
    temp = sum_acc(num) - sum_acc(num - 1)
    dif -= temp
    while num <= n:
        tree[num] += dif
        num += (num & -num)

n, m = map(int,input().split())

arr = [0]*(n+1)
tree = [0]*(n+1)

for i in range(m):
    type, a, b =  map(int,input().split())
    if type == 0: #sum
        if a <= b:
            print(sum_s_e(a, b))
        else:
            print(sum_s_e(b, a))
    else: # modify
        update(a, b - arr[a])
        arr[a] = b

# from math import ceil, log
#
# n, m = map(int, input().split())
# arr = [0]*(n+1)
#
# h = ceil(log(n, 2)+1)
# tree = [0] * (2**h)
#
# def init(s, e, node):
#     if s == e:
#         tree[node] = arr[s]
#         return
#     mid = (s+e) // 2
#     init(s, mid, node*2)
#     init(mid+1, e, node*2+1)
#     tree[node] = tree[node*2] + tree[node*2+1]
#
# def update(s, e, node, idx,diff):
#     if not (s <= idx <= e):
#         return
#     tree[node] += diff
#     if s == e:
#         return
#     mid = (s + e) // 2
#     update(s, mid, node*2, idx, diff)
#     update(mid+1, e, node*2+1, idx, diff)
#
# def interval_sum(s, e, node, left, right):
#     if e < left or right < s:
#         return 0
#     if left <= s and e <= right:
#         return tree[node]
#     mid = (s + e) // 2
#     return interval_sum(s, mid, node*2, left, right) + interval_sum(mid+1, e, node*2+1, left, right)
#
#
# init(0, n-1, 1)
# for i in range(m):
#     type, a, b = map(int,input().split())
#     if type == 0:
#         a -= 1
#         b -= 1
#         if a <= b:
#             print(interval_sum(0, n-1, 1, a, b))
#         else:
#             print(interval_sum(0, n - 1, 1, b, a))
#
#     else:
#         a -= 1
#         update(0, n-1, 1, a, b-arr[a])
#         arr[a] = b




