n = int(input())
arr = [int(input()) for _ in range(n)]
L = len(arr)
# 1. 산술평균
print(round(sum(arr)/L))

# 2. 중앙값
arr.sort()
print(arr[L//2])

# 3. 최빈값
i = 0
ans = []
max_cnt = 0
while i < L:
    ni = i + 1
    while ni < L and arr[i] == arr[ni]:
        ni += 1
    tmp_cnt = ni - i
    # 같으면 추가(여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다는 조건 때문)
    if max_cnt == tmp_cnt:
        ans.append(arr[i])
    # 더 빈도가 높은 값을 발견 시 리스트를 통째로 갱신
    elif max_cnt < tmp_cnt:
        max_cnt = tmp_cnt
        ans = [arr[i]]
    i = ni
# 답이 하나면 출력
if len(ans) == 1:
    print(ans[0])
# 빈도가 같은 값이 여러개인 경우, 두번째로 작은 값 출력
else:
    ans.sort()
    print(ans[1])

# 4. 범위
print(arr[-1] - arr[0])