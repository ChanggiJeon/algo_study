# 현재 위치, 사이즈 받기
def solve(cr, cc, cn):
    # 전체가 동일한지 체크
    tmp = arr[cr][cc]
    for i in range(cn):
        for j in range(cn):
            if arr[cr + i][cc + j] == tmp: continue
            # 동일하지 않으면 9등분해서 재귀하고 리턴
            nn = cn // 3
            for x in range(3):
                for y in range(3):
                    solve(cr + nn * x, cc + nn * y, nn)
            return
    # 다 돌았는데 9등분하지 않고 온 경우
    check[tmp + 1] += 1


n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
# -1, 0, 1을 각각 리스트의 인덱스 0, 1, 2로 매칭
check = [0, 0, 0]
# 계산 시작
solve(0, 0, n)
for i in range(3):
    print(check[i])
