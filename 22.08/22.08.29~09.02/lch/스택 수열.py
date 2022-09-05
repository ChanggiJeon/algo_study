n = int(input())
base = []
for i in range(n):
    base.append(int(input()))
stack = []
ans = []
j = 1
state = 0
# 처음엔 해석이 조금 헷갈리네
# 1~n 까지 숫자를 스택에 넣어서 base를 만들수 있느냐 판단하고 패턴

# 입력해야 하는 수가 현재 i 보다 크다면?

# 형태는 잡혔는데  pop을 할때만 i를 증가시켜야 하고 뷸가능할때 no를 출력하는 코드도 추가해야한다

for i in range(n):
    if state == 1:
        break
    while True:
        if j > n + 1:
            state = 1
            break
        #append 할수 없으면 에러가 생기니 그전에 끊어야 한다
        if len(stack) != 0 and stack[-1] == base[i]:
            stack.pop()
            ans.append('-')
            #pop을 할때까지 쌓는다
            break
        else:
            # i 값이 그대로 이므로 새로운 변수를 써야겠다
            stack.append(j)
            ans.append('+')
            j += 1
if state == 1:
    print('NO')
else:
    for i in ans:
        print(i)
