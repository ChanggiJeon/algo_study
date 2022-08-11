N, M = map(int, input().split())
base = [list(map(int, input().split())) for _ in range(N)]

# 한쪽으로 밀착 시켜서 계산
# 양쪽은 같은 개수 이니 3면을 구해서 2배를 해준다
# 바닥은 N*M
# 정면과 옆쪽을 구해야 하는데 최대값을 적용하면 가려지는 부분이 생긴다

# 바로앞의 블럭보다 크면 +를 해준다
# 그럼 최대값 적용이 아닌 처음부터 하나씩 얹어가는 방식

bottom = N*M
front = 0
side = 0

ans = 0

for i in range(N):
    for j in range(M):
        if j == 0:
            front += base[i][j]
        else:
            front += max(0, base[i][j] - base[i][j-1])

        if i == 0:
            side += base[i][j]
        else:
            side += max(0, base[i][j] - base[i-1][j])

ans = 2*(front + side + bottom)
print(ans)