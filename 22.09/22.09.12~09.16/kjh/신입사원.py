import sys

# 입력값
T = int(sys.stdin.readline())
for tc in range(T):
    n = int(sys.stdin.readline())
    arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]

    # 초기값(서류 1등은 무조건 채용)
    hired = 1

    # 1. 서류심사 순위 기준 정렬
    arr.sort()

    # 2. 서류심사로 정렬이 되었기 때문에 면접심사에서 우위에 있어야만 채용된다.
    cur_grade = arr[0][1]
    for i in range(1, n):
        if arr[i][1] < cur_grade:
            cur_grade = arr[i][1]
            hired += 1
    print(hired)