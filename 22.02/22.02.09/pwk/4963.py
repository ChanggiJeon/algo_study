dr = [-1,-1,-1,0,0,1,1,1]
dc = [-1,0,1,-1,1,-1,0,1]

def check(r,c):
    arr[r][c] = 0
    
    for i in range(8):
        nr = r + dr[i]
        nc = c + dc[i]
        if 0<=nr<h and 0<=nc<w and arr[nr][nc]:
            check(nr,nc)
    
while True:
    w,h = map(int, input().split())
    if w == 0 and h == 0:
        exit()
    arr = [list(map(int, input().split())) for _ in range(h)]
    count = 0
    for i in range(h):
        for j in range(w):
            if arr[i][j]:
                count += 1
                check(i,j)
    print(count)