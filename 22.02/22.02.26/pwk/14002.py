N = int(input())
lst = list(map(int, input().split()))
# 각 위치에서 가장 긴 증가하는 부분수열을 저장
result = [[lst[0]]]

for i in range(1, N):
    # 현재 숫자와 이번에 저장할 부분수열을 초기화
    now_num = lst[i]            # 사실 필요X
    now_result = [now_num]      # now_num이 가장 작은수일때, 이렇게 초기화해야함
    for j in range(i):
        # 앞에서 나온 작은수들에 대해
        if lst[j] < now_num:
            # 만들어 뒀던 수열들 중에 제일 긴놈 골라서
            if len(result[j]) >= len(now_result):
                now_result = result[j].copy()
                now_result.append(now_num)
    result.append(now_result)

result = sorted(result, key=lambda x:len(x), reverse=True)
print(len(result[0]))
print(*result[0])