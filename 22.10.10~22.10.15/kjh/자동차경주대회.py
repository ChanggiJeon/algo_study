import sys
from copy import deepcopy

# 입력값
max_distance = int(sys.stdin.readline())
number_of_shop = int(sys.stdin.readline())
shop_distance = list(map(int, sys.stdin.readline().split())) + [0]
shop_time = [0] + list(map(int, sys.stdin.readline().split())) + [0]

# 초기값
DP = [[] for _ in range(number_of_shop + 2)] # DP = [[누적 정비 시간(t), 남은 거리(d), 방문한 정비소리스트(arr)]
DP[0] = [0, max_distance, []]

# 풀이
for i in range(number_of_shop + 2):
    # 현재 위치에서 이동가능한 index
    next_index = i
    # 현재(current) 위치 초기값
    ct = DP[i][0]
    cd = max_distance
    carr = DP[i][2]
    # 도착 지점이면 정답 출력
    if i == number_of_shop + 1:
        print(ct)
        print(len(carr) - 1)
        ans_arr = carr[:-1]
        print(*ans_arr)
        break
    while True:
        # 일단 거리 계산(shop_distance의 인덱스가 1 작음)
        cd -= shop_distance[next_index]
        # 음수면 이동가능 범위 초과
        if cd < 0:
            break
        # 음수 아니면 다음 위치로 이동
        next_index += 1
        narr = deepcopy(carr)
        # 범위 체크
        if next_index == number_of_shop + 2:
            break
        # 이동한 위치에서의 누적 정비 시간
        nt = ct + shop_time[next_index]

        # 다음 위치에 DP 값이 이미 있으면(방문한 적 있으면) 비교해서 갱신
        if DP[next_index]:
            t, d, arr = DP[next_index]
            # 1. t가 더 작은가?
            if nt < t:
                narr.append(next_index)
                DP[next_index] = [nt, cd, narr]
            # 2. t가 같을 때, d가 더 큰가?
            elif nt == t:
                if cd > d:
                    narr.append(next_index)
                    DP[next_index] = [nt, cd, narr]
        # 방문한 적 없으면 바로 추가(일단 방문)
        else:
            narr.append(next_index)
            DP[next_index] = [nt, cd, narr]
