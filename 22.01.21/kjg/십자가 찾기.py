# 휴 오랜만에 한 번에 풀었다.
# 하지만 채점 속도가 너무 느려 식은 땀 날뻔
N, M = map(int, input().split())
w = [list(input()) for i in range(N)]
wc = [['.']*M for _ in range(N)]
ans=[]
dx= [0,0,-1,1]
dy= [-1,1,0,0]

def force(x,y,l):
    cnt = 0
    
    for i in range(4):
        nx = x + (l*dx[i])
        ny = y + (l*dy[i])
        if 0<=nx<M and 0<=ny<N:
            if w[ny][nx] == '*':
                cnt += 1
        # 하나라도 틀리면 십자가 형성이 되지 않으므로
        if cnt==i:
            break
        # 4방위 전부 통과하면
        elif cnt == 4:
            # 현재 포인트를 비교그림에 적용 후 나머지 적용
            wc[y][x] = '*'
            for i in range(4):
                nx = x + (l*dx[i])
                ny = y + (l*dy[i])
                wc[ny][nx] = '*'
            # 그리고 더 큰 십자가가 되는 지 확인
            force(x,y,l+1)
            #그리고 십자가는 큰 순서대로 기록됨으로 현재 십자가는 확인 후 추가
            cro = [y+1,x+1,l]
            ans.append(cro)

for y in range(N):
    for x in range(M):
        if w[y][x] == '*':
            
            force(x,y,1)
if wc==w:
    print(len(ans))
    for i in ans:
        print(*i)
else:
    print(-1)

