# 입력값
n = int(input())
arr = list(int(input()) for _ in range(n))

# 초기값
i = 1
stack = list()
ans = list()

# 풀이
for j in range(n):
    num = arr[j]
    while True:
        # i가 n + 1보다 커지면 무한 루프에 빠짐(영원히 찾을 수 없음)
        if i > n + 1:
            print('NO')
            exit()
        # 마지막 값이 현재 찾는 값과 같으면 pop
        if stack and stack[-1] == num:
            stack.pop()
            ans.append('-')
            break
        # 다르면 push
        else:
            stack.append(i)
            ans.append('+')
            i += 1

for p in ans:
    print(p)