# 접근 : 현재 위치한 주유소 가격보다 더 낮은 가격의 주유소까지만 주유한다.(없으면 끝까지 갈 수 있도록 주유)

# 입력값
n = int(input())
dist_arr = [0]
dist_arr.extend(list(map(int, input().split())))
station_arr = list(map(int, input().split()))

# 풀이
ans = 0
i = 0
# i < n으로 하는 경우, 마지막 정류장이 가장 저렴할 때 무한 루프에 빠짐
while i < n - 1:
    cost = station_arr[i]
    dist = 0
    for j in range(i + 1, n):
        # 가격이 더 싼 주유소가 있으면 이동할 거리만큼 현재 주유소에서 주유하고 이동
        if station_arr[j] < cost:
            # 거리 추가 후 주유(계산)
            dist += dist_arr[j]
            ans += cost * dist
            # 이동
            i = j
            break
        # 가격이 더 비쌀경우
        else:
            # 거리 추가
            dist += dist_arr[j]
        # 마지막 주유소까지 더 싼 주유소가 없으면 현재 위치에서 다 넣고 종료
        if j == n - 1:
            ans += cost * dist
            i = n
print(ans)