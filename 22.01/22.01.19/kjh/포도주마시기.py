n = int(input())
arr = list(int(input()) for _ in range(n))
DP_arr = [0] * 3
# 1번째 포도주를 마신 경우
DP_arr[1] = arr[0]

# n이 1이면 index error 발생
if n > 1:
    # 2번째 포도주를 안마신 경우
    # 포도주를 안마시는 경우 카운트가 무조건 초기화 됨으로 전체 경우의 수 중 가장 큰값을 2에 넣어준다.
    # 단, 바로 넣지말고 다른 수를 다 계산한 후에 마지막에 추가한다.
    reset = max(DP_arr)
    # 2번째 포도주를 마신 경우
    DP_arr[0] = DP_arr[1] + arr[1]
    DP_arr[1] = DP_arr[2] + arr[1]
    DP_arr[2] = reset

    # 3번째 포도주부터 끝까지 반복하면 됨
    # 안마신 경우 최대값 reset에 저장하고
    # 마신 경우 한칸씩 이동
    for i in range(2, n):
        reset = max(DP_arr)
        DP_arr[0] = DP_arr[1] + arr[i]
        DP_arr[1] = DP_arr[2] + arr[i]
        DP_arr[2] = reset

print(max(DP_arr))