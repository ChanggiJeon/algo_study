from collections import deque
N, K = map(int, input().split())
q = deque()
visited = [0]*100001
path = [0]*100001

def find():
    q.append(N)
    while q:
        now = q.popleft()
        if now == K:
            ans = []
            print(visited[now])
            while now != N:
                ans.append(now)
                now = path[now]
            ans.append(now)
            for i in range(len(ans)):
                if i == len(ans)-1:
                    print(ans[-i-1])
                else:
                    print(ans[-i - 1], end=' ')
            return

        for next in (now-1, now+1, now*2):
            if 0 <= next <= 100000:
                if visited[next] == 0:
                    visited[next] = visited[now]+1
                    q.append(next)
                    path[next] = now
find()