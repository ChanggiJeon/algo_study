# 시간초과로 애먹었다 그 기준은 오른쪽과 아래쪽을 확인하면 
# 위쪽,왼쪽을 구분할 필요없기 때문인데 4방향 다 고려하면서 시간초과가 되었다.
# 그리고 현재 좌표에서 나올 수 있는 최대 길이가 현재 최대길이보다 작으면 빠져나가게 하여
# 시간을 줄였다.
# 시간을 해결하닌 인덱스 에러가 발생했는데
# if 문에서 and로 여러가지 조건을 적을 경우 가장 치명적인 조건을 나중에 적어서 발생했다.


import copy
N = int(input())
w = [list(input()) for _ in range(N)]
ans = 0
# 하,우
dx = [0,1]
dy = [1,0]

def many(y,x,i,m,cnt):
    
    if cnt == N:
        return
    nx= x + dx[i]
    ny= y + dy[i]
    if nx<N and ny<N and m[y][x]==m[ny][nx]:
        cnt = many(ny,nx,i,m,cnt+1)
    return cnt
def dps(arr):
    global ans
    cnt = 0
    for y in range(N):
        for x in range(N):
            
            d=[0,0] 
            if (N-y+1) > ans and y+1<N and arr[y][x] == arr[y+1][x]:
                d[0] = many(y+1,x,0,arr,cnt+1)
            if (N-x+1) > ans and x+1<N and arr[y][x] == arr[y][x+1]:
                d[1] = many(y,x+1,1,arr,cnt+1)
            candy = max(d[0]+1,d[1]+1)
            if ans < candy:
                ans = candy
                if candy == N:
                    break
for y in range(N):
        for x in range(N):
            for i in range(2):
                nx= x + dx[i]
                ny= y + dy[i]
                if nx<N and ny<N and w[y][x]!=w[ny][nx]:
                    w[y][x],w[ny][nx] = w[ny][nx],w[y][x]
                    dps(w)
                    w[y][x],w[ny][nx] = w[ny][nx],w[y][x]

print(ans)
