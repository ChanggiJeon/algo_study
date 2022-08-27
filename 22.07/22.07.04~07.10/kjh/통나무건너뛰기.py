# 그리디한 접근 : 성(castle)모양으로 통나무를 정렬하면 최소 난이도가 구해지지 않을까?
# 어떻게 성 모양으로 정렬할 것인가? -> 오름차순 정렬 후 짝수 인덱스와 홀수 인덱스를 나누고 홀수 인덱스를 뒤집어서 붙여준다.
T = int(input())
for tc in range(1, T + 1):
    n = int(input())
    arr = list(map(int, input().split()))
    arr.sort()
    even_arr = []
    odd_arr = []
    for i in range(len(arr)):
        if i % 2 == 0:
            even_arr.append(arr[i])
        else:
            odd_arr.append(arr[i])
    odd_arr.reverse()
    even_arr.extend(odd_arr)

    # 인접한 두 수의 최대차 ans 찾기
    ans = 0
    for i in range(len(arr)):
        # 마지막이면 처음거랑 비교
        if i == len(arr) - 1:
            if abs(even_arr[i] - even_arr[0]) > ans:
                ans = abs(even_arr[i] - even_arr[0])
            break
        if abs(even_arr[i] - even_arr[i+1]) > ans:
            ans = abs(even_arr[i] - even_arr[i+1])
    print(ans)