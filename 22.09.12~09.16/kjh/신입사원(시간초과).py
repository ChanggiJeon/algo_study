# 입력값
T = int(input())
for tc in range(T):
    n = int(input())
    arr = [list(map(int, input().split())) for _ in range(n)]

    # arr의 전체를 돌면서 첫번째 값들을 비교해서 현재보다 크면 두번째 값도 비교
    cnt = 0
    for i in range(n):
        for j in range(n):
            if arr[i][0] > arr[j][0]:
                if arr[i][1] > arr[j][1]:
                    # 두 값이 모두 크면(순위가 낮으면) 결코 채용될 수 없음
                    cnt += 1
                    break
    print(n - cnt)
# 시간 초과