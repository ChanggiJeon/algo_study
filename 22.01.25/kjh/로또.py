def solve(arr, start):
    # 중단 조건 : arr이 6개 채워지면
    a = len(arr)
    if a == 6:
        for i in range(6):
            if i == 5:
                print(arr[i])
            else:
                print(arr[i], end=' ')
        return

    for i in range(start, k):
        # 값 넣기
        arr.append(s[i])
        # 현재 위치 이후의 값부터 추가해야함으로 start = i+1
        solve(arr, i+1)
        # 재귀 이후 방금 넣은거 빼기
        arr.pop()


while True:
    s = list(map(int, input().split()))
    k = s.pop(0)
    if k == 0:
        break
    s.sort()
    solve([], 0)
    print()