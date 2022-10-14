import sys
input = sys.stdin.readline
sys.setrecursionlimit(10 ** 6)
def set_num(r,c,d,cnt,final):
    if cnt > final:
        return
    if (r == 0 and c == 0) or (r == 0 and c == m + 1) or (r == n + 1 and c == 0) or (r == n + 1 and c == m + 1):
        nr = r + dr[(d + 1) % 4]
        nc = c + dc[(d + 1) % 4]
        set_num(nr,nc,(d + 1) % 4,cnt,final)
    else:
        nr = r + dr[d % 4]
        nc = c + dc[d % 4]
        arr[r][c] = cnt
        point.append([r,c,cv[d]])
        set_num(nr,nc,d,cnt + 1,final)

def what_num(r,c,d):
    # print(r,c,d)
    if arr[r][c] == -2:
        nr = r + lr[d]
        nc = c + lc[d]
    elif arr[r][c] == -3:
        d = cv2[d]
        nr = r + lr[d]
        nc = c + lc[d]
    if arr[nr][nc] > 0:
        print(arr[nr][nc], end=" ")
    else:
        what_num(nr,nc,d)

n, m = map(int,input().split())
arr = [[-1] * (m + 2) for _ in range(n + 2)]


# 하, 우 ,상, 좌 번호 세팅용
dr = [1,0,-1,0]  #y축
dc = [0,1,0,-1] # x축
cv = [3,0,2,1]

# 상,하,좌,우 레이저 발사용
lr = [-1,1,0,0]
lc = [0,0,-1,1]
cv2 = [3,2,1,0]
point = []
set_num(1,0,0,1,2 *(n + m))

for i in range(1,n + 1):
    arr2 = list(map(int,input().split()))
    for j in range(len(arr2)):
        if arr2[j] == 0:
            arr[i][j + 1] = -2
        else:
            arr[i][j + 1] = -3
# for a in arr:
#     print(a)
# print(point)

for r,c,d in point:
    r = r + lr[d]
    c = c + lc[d]
    # print('start:',arr[r][c],'!',nr,nc)
    # what_num(nr,nc,d)
    while True:
        if arr[r][c] == -2:
            r = r + lr[d]
            c = c + lc[d]
        elif arr[r][c] == -3:
            d = cv2[d]
            r = r + lr[d]
            c = c + lc[d]
        if arr[r][c] > 0:
            print(arr[r][c], end=" ")
            break
