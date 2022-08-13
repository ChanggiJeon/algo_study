def solve(x1, y1, p1, q1, x2, y2, p2, q2):
    # 'd' = 접점이 없는 경우 -> 한 사각형의 시작점이 다른 사각형의 끝점보다 더 큰 경우
    if x1 > p2 or x2 > p1 or y1 > q2 or y2 > q1:
        print('d')
        return

    # 'c' = 접점이 하나인 경우 -> 마주보는 꼭지점이 일치
    if (x1, y1) == (p2, q2) or (p1, q1) == (x2, y2) or (x1, q1) == (p2, y2) or (p1, y1) == (x2, q2):
        print('c')
        return

    # 'b' = 접점이 선분인 경우 -> x 또는 y 좌표가 하나라도 같으면 선분임(예외는 d or c에서 처리됨)
    if x1 == x2 or x1 == p2 or y1 == y2 or y1 == q2 or p1 == x2 or p1 == p2 or q1 == y2 or q1 == q2:
        print('b')
        return

    # 'a' = 접점이 4개인 경우(직사각형을 만드는 경우) -> 나머지
    print('a')
    return


for i in range(4):
    # 입력값
    A, B, C, D, E, F, G, H = map(int, input().split())
    solve(A, B, C, D, E, F, G, H)