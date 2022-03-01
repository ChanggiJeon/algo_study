def solve(start):
    result = 0
    for i in range(N):
        if i in start:
            for j in range(N):
                if j in start:
                    result += arr[i][j]
        else:
            for j in range(N):
                if not j in start:
                    result -= arr[i][j]
    return result


def matching(idx, start):
    global min_result
    if idx >= N:
        return
    if len(start) == N//2:
        result = solve(start)
        if abs(result) < min_result:
            min_result = abs(result)
        return
    
    start.append(idx)
    matching(idx + 1, start)
    start.pop()
    matching(idx + 1, start)


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
min_result = 100000
matching(0,[])
print(min_result)