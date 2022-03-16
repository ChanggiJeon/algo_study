# dfs로 풀어보려다가 뭐같이 폭망 
# 결국 종현님꺼 보고 참고
# def dfs(x,y,d,cr,cd,cl):
#     print(x,y)
#     if visit[y][x]:
#         return
#     visit[y][x] = 1
#     nx = x + dx[d]
#     ny = y + dy[d]
#     if 0<=nx<X and 0<=ny<Y and Map[ny][nx] == Map[y][x]:
#         print('d:',d)
#         if d == 0:
#             dfs(nx,ny,d,cr+1,cd,cl)
#         elif d == 1:
#             dfs(nx,ny,d,cr,cd+1,cl)
#         elif d == 2 :
#             print('cr:',cr,'cl',cl)
#             if cr>=cl+1:
#                 dfs(nx,ny,d,cl,cd,cl+1)
#             elif cl+1>cr:
#                 visit[y][x] = 0
#                 dfs(x,y,d+1,cr,cd,cl)     
#         elif d == 3:
#             if cd-1 > 0 :
#                 dfs(nx,ny,d,cr,cd-1,cl)
#             else:
#                 print('Yes')
#                 exit()
#     else:
#         print(d+1)
#         if d == 0 and cr> 0:
#             visit[y][x] = 0
#             dfs(x,y,d+1,cr,cd,cl)
#         elif d == 1 and cr > 0 and cd>0:
#             visit[y][x] = 0
#             dfs(x,y,d+1,cr,cd,cl)
#         elif d == 2 and cl >0:
#             visit[y][x] = 0
#             dfs(x,y,d+1,cr,cd,cl)
#     print(x,y,'end')




Y,X = map(int,input().split())
Map = [list(input()) for _ in range(Y)]
visit = [[0]*X for _ in range(Y)]
#상하좌우
dx = [0,0,-1,1]
dy = [-1,1,0,0]
cyc = False
c=[]


for y in range(Y):
    for x in range(X):
        if visit[y][x]:continue
        # same = Map[y][x] 
        c.append((x,y,-1,-1))
        while c:
            cx, cy, px, py = c.pop()
            if visit[cy][cx]:
                cyc = True
                break
            visit[cy][cx] = 1 
            for i in range(4):
                nx = cx + dx[i]
                ny = cy + dy[i]
                if nx >= X or nx < 0 or ny >= Y or ny < 0: continue
                if Map[ny][nx] != Map[cy][cx]:continue
                if (nx,ny) == (px,py): continue
                c.append((nx,ny,cx,cy))
        if cyc:
            break
    if cyc:
            break
if cyc:
    print('Yes')
else:
    print('No')