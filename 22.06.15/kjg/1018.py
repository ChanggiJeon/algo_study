m, n = map(int,input().split())
chess = [list(input()) for _ in range(m)]
# 최소값의 최대크기는 행과 열의 곱보다 클 수 없다.
min_color = m * n
def cut_chess(y, x):
    global min_color
    # 시작이 검은색으로 지정할 때 색칠해야하는 수 
    cnt = 0
    # 시작이 흰색으로 지정할 때 색칠해야하는 수
    cnt2 = 0
    # 부울 값을 판단하기 위한 기준 설정
    point = chess[y][x] # 색상
    point_n = (y + x) % 2 # 현재 (행 + 열)의 짝수 홀수 구분
    
    for i in range(y, y + 8):
        for j in range(x, x + 8):
            # 기준점과 동일한 포인트면
            if (i + j) % 2 == point_n:
                # 색상이 동일할 때 아닐때를 따로 체크
                if chess[i][j] != point:
                    cnt += 1
                if chess[i][j] == point:
                    cnt2 += 1
            elif (i + j) % 2 != point_n:
                if chess[i][j] == point:
                    cnt += 1
                if chess[i][j] != point:
                    cnt2 += 1
            # 각 색상의 색칠 횟수가 기록된 최소값보다 클경우 탈출
            if cnt > min_color and cnt2 > min_color:
                return
    # 완료하면 각 색상중 최소값 구분
    # 기록된 최소값과 색상의 최소값 구분
    else:
        cnt = min(cnt, cnt2)
        min_color = min(min_color, cnt)

# 탐색하는 행동에 있어 8x8의 크기는 유지해야하기 때문에
# 탐색범위 제한
for i in range(m - 7):
    for j in range(n - 7):
        cut_chess(i,j)
print(min_color)