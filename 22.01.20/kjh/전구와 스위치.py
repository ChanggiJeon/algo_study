n = int(input())
arr1 = input()
arr2 = input()
a = []
a2 = []
b = []
for i in range(n):
    a.append(int(arr1[i]))
    a2.append(int(arr1[i]))
    b.append(int(arr2[i]))
# 첫번째 전구를 눌렀을 떄
a[0] = 1 - a[0]
a[1] = 1 - a[1]
cnt = 1
# 두번째 전구부터 이전 전구 값이 고정됨
for i in range(1, n):
    # 이전 전구 값이 다르면 바꿔준다.
    if b[i-1] != a[i-1]:
        cnt += 1
        a[i - 1] = 1 - a[i - 1]
        a[i] = 1 - a[i]
        # 마지막 전구일 때 인덱스 에러 처리
        if i < n-1:
            a[i + 1] = 1 - a[i + 1]
# 마지막까지 갔을 때 원하는 답이면 ans에 입력
ans = -1
if a == b:
    ans = cnt

# 첫번째 전구를 안눌렀을 때
cnt = 0
for i in range(1, n):
    if b[i-1] != a2[i-1]:
        cnt += 1
        a2[i - 1] = 1 - a2[i - 1]
        a2[i] = 1 - a2[i]
        if i < n-1:
            a2[i + 1] = 1 - a2[i + 1]
# 다 돌았을 때 답을 찾음
if a2 == b:
    # 위에서 답 못찾고 밑에서 찾았을 때
    if ans == -1:
        ans = cnt
    # 위에서 답 찾았는데 밑에서도 찾았을 때
    elif ans > cnt:
        ans = cnt
print(ans)