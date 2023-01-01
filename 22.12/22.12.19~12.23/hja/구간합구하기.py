# binary index tree(fenwich tree) (i & -i)

# i번째까지 누적 합
def prefix_sum(i):
    result = 0
    while i>0:
        result += tree[i]
        i -= (i & -i)
    return result

# i번째 수를 dif만큼 더하기
def update(i, dif):
    while i <= n:
        tree[i] += dif
        i += (i&-i)

# start부터 end까지 구간 합 계산
def interval_sum(start, end):
    return prefix_sum(end) - prefix_sum(start - 1)

n, m, k = map(int, input().split())

arr = [0] * (n+1)
tree = [0] * (n+1)

for i in range(1, n+1):
    number = int(input())
    arr[i] = number
    update(i, number)

for _ in range(m+k):
    a, b, c = map(int, input().split())
    if a == 1:
        update(b, c - arr[b])
        arr[b] = c
    else:
        print(interval_sum(b,c))
def prefix_sum(i):
    result = 0
    while i>0:
        result += tree[i]
        i -= (i & -i)
    return result

def update(i, dif):
    while i <= n:
        tree[i] += dif
        i += (i&-i)

def interval_sum(start, end):
    return prefix_sum(end) - prefix_sum(start - 1)

n, m, k = map(int, input().split())

arr = [0] * (n+1)
tree = [0] * (n+1)

for i in range(1, n+1):
    number = int(input())
    arr[i] = number
    update(i, number)

for _ in range(m+k):
    a, b, c = map(int, input().split())
    if a == 1:
        update(b, c - arr[b])
        arr[b] = c
    else:
        print(interval_sum(b,c))