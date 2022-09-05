# n이 최대 100만임으로 이중for문으로 풀이 불가
# 참조 : https://velog.io/@waoderboy/백준-17298-오큰수-파이썬
# stack을 후보군을 가지고 있다가 늦은 업데이트를 하는 데 사용한다.

# 입력값
n = int(input())
arr = list(map(int, input().split()))

# 초기값
ans = [-1] * n
stack = list() # stack에는 내림차순으로 숫자가 쌓인다.

# 풀이
for i in range(n):
    # 현재 값이 stack의 마지막 값보다 크면 pop하고 ans 갱신
    # 더 큰값이 나올 때까지 탐색한다.
    while stack and arr[stack[-1]] < arr[i]:
        ans[stack.pop()] = arr[i] # 현재값이 오큰수
    stack.append(i)
print(*ans)