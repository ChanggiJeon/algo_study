def solve(idx):
    global result_arr

    # 중단조건 : 이번이 6번째 숫자인 경우
    if len(result_arr) == 5:
        result_arr.append(arr[idx])
        for j in range(6):
            if j == 5:
                print(result_arr[j])
                break
            print(result_arr[j], end=" ")
        return

    # 1~5번째인 경우 배열에 넣어준다.
    result_arr.append(arr[idx])

    # 재귀 : 현재 인덱스의 다음 숫자부터 끝까지 하나씩 넣어주고 끝나면 빼준다.
    for i in range(idx + 1, k):
        solve(i)
        result_arr.pop()


while True:
    # 입력값
    input_arr = input()
    # 0이면 끝내는 조건 체크
    if len(input_arr) == 1:
        break
    arr = list(map(int, input_arr.split()))
    k = arr.pop(0)

    # 풀이 시작
    # 출력할 숫자를 담는 배열
    result_arr = list()
    for i in range(k-5):
        solve(i)
        result_arr.pop()
    print()