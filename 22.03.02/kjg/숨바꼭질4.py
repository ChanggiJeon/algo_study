# 처음에 결과를 만들었더니 메모리초과
# 데이터를 가볍게 해서 제출했더니 오답 왜그런가 했더니 범위설정 미스
# 그리고 추가로 깨달음점 bfs는 dfs랑 달리 먼저 기록되는 것이 최단 기록

from collections import deque
M,N = map(int,input().split())
Map = [0]*100001
dist = [0]*100001
# print(Map)
point = deque()
point.append(M)
while point:
    subin = point.popleft()
    dir = [subin+1,subin-1,subin*2]
    if subin == N:
        break
    for i in dir:
        # print(i)
        if 0<=i<=100000 and dist[i] == 0:
            point.append(i)
            dist[i] = dist[subin]+1
            Map[i] = subin
arr=[]
temp = N 
for _ in range(dist[N]+1):
    arr.append(temp)
    temp = Map[temp]
print(dist[N])
print(' '.join(map(str,arr[::-1])))