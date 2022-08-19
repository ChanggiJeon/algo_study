# '()', '(x)', '[]', '[x]'를 숫자로 변경하는 함수
def solve(s):
    # s == stack

    # 초기값
    tmp_stack = [s[0]]

    # 풀이
    for i in range(1, len(s)):
        # 닫는 괄호이면 () 혹은 [] 혹은 (x) 혹은 [x] 형태인지 확인한다.
        if s[i] == ')' or s[i] == ']':
            # 쌍이면 숫자로 바꿔서 넣는다.
            if s[i-1] == pair[s[i]]:
                tmp_stack.pop()
                if s[i] == ')':
                    tmp_stack.append(2)
                else:
                    tmp_stack.append(3)
                continue
            # 숫자를 감싸는 쌍이면 곱해서 넣는다.
            elif type(s[i-1]) == int and s[i-2] == pair[s[i]]:
                n = tmp_stack.pop()
                tmp_stack.pop()
                if s[i] == ')':
                    tmp_stack.append(n * 2)
                else:
                    tmp_stack.append(n * 3)
                continue
        # (), (x), [], [x]에 해당하지 않고 여는괄호이거나 숫자인 경우 그냥 추가
        tmp_stack.append(s[i])
    return tmp_stack


# 연속된 숫자를 더하는 함수
def sum_beside(s):
    # 초기값
    tmp_stack = list()
    l = len(s)

    # 풀이
    i = 0
    while i < l:
        # 현재 값이 인트면 int를 안만날때까지 탐색
        if type(s[i]) == int:
            n = s[i]
            # i+1이 l보다 작고 int면 값 누적
            while i + 1 < l and type(s[i + 1]) == int:
                n += s[i + 1]
                i += 1
            tmp_stack.append(n)
        # 현재값이 괄호면 그냥 추가
        else:
            tmp_stack.append(s[i])
        i += 1
    return tmp_stack


# 입력값
input_str = input()

# 초기값 설정
stack = list()
pair = {
    ')': '(',
    ']': '['
}

# 올바른 괄호열 체크 1 : 닫는 괄호로 시작하는 경우
if input_str[0] == ')' or input_str[0] == ']':
    print(0)
    exit()
# 올바른 괄호열 체크 2,3 : 괄호의 짝이 안맞는 경우 + 닫는 괄호가 더 많은 경우
check = []
for char in input_str:
    # str -> list
    stack.append(char)
    # 검사 시작
    if char == '(' or char == '[':
        check.append(char)
    #
    else:
        # 닫는 괄호가 더 많은 경우
        if not check:
            print(0)
            exit()
        # 짝이 안맞는 경우
        check_char = check.pop()
        if check_char != pair[char]:
            print(0)
            exit()
# 올바른 괄호열 체크 4 : 여는 괄호가 더 많은 경우
if check:
    print(0)
    exit()

# 풀이
while len(stack) > 1:
    stack = solve(stack)
    stack = sum_beside(stack)
# 마지막 하나 남은게 정답
print(stack.pop())