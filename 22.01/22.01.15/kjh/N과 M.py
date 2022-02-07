# N개의 자연수 중에서 M개를 고른 수열 구하기.
def solve(ans):
    global visited

    if len(ans) == M:
        print(*ans)
        return

    for i in range(N):
        if visited[i] == 1: continue
        ans.append(arr[i])
        visited[i] = 1
        solve(ans)
        visited[i] = 0
        ans.pop()


N, M = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
visited = [0] * N
solve([])