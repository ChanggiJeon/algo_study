# 입력값
input_str = input()

# 파싱
number_str = ''
arr = []
for char in input_str:
    if char == '-' or char == '+':
        arr.append(int(number_str))
        arr.append(char)
        number_str = ''
    else:
        number_str += char
# 마지막 숫자 입력
arr.append(int(number_str))

# 최솟값 찾기 : -다음부터 다음 -까지 더해서 빼기
ans = 0
minus_stack = 0
minus_check = False
for i in range(len(arr)):
    # 마이너스 만나면 스택 털고 초기화
    if arr[i] == '-':
        minus_check = True
        ans -= minus_stack
        minus_stack = 0
    # 숫자일 때
    elif arr[i] != '+':
        # 마이너스 상태이면
        if minus_check:
            # 마이너스 스택 쌓기
            minus_stack += arr[i]
        # 마이너스 상태 아니면
        else:
            # ans에 쌓기
            ans += arr[i]
# 마무리 스택 털기
ans -= minus_stack
print(ans)

