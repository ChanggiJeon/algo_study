#최소 신장 트리 - 크루스칼 알고리즘
n = 4
costs = [[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]

def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]


def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


def solution(n, costs):
    parent = [0] * (n + 1)

    for i in range(1, n + 1):
        parent[i] = i
    list_costs = []

    for i in range(len(costs)):
        x = costs[i][0]
        y = costs[i][1]
        z = costs[i][2]
        list_costs.append([z, x, y])

    list_costs.sort()
    result = 0
    for costs in list_costs:
        cost, a, b = costs

        if find_parent(parent, a) != find_parent(parent, b):
            union_parent(parent, a, b)
            result += cost

    return result
print(solution(n, costs))