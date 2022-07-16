# pypy로 제출 
# dfs로 적었으나 실상은 완전탐색임

a = int(input())
nums = list(map(int,input().split()))
cir = list(map(int,input().split()))
cnt = 0
max_n = -1 * (10 ** 9)
min_n = 10 ** 9
cir_arr = [''] * (a - 1)
for i in range(4):
    for j in range(cir[i]):
        if i == 0: 
            cir_arr[cnt] = '+'
        elif i == 1: 
            cir_arr[cnt] = '-'
        elif i == 2: 
            cir_arr[cnt] = '*'
        elif i == 3: 
            cir_arr[cnt] = '/'
        cnt += 1
visit = [0] * len(cir_arr)
ans = []
def dfs(k):
    global min_n, max_n
    if k == len(cir_arr):
        an = nums[0]
        for i in range(len(ans)):
            if ans[i] == '+':
                an += nums[i + 1]
            elif ans[i] == '-':
                an -= nums[i + 1]
            elif ans[i] == '*':
                an *= nums[i + 1]
            elif ans[i] == '/':
                an /= nums[i + 1]
                an = int(an)
        if an < min_n:
            min_n = an
            # print('!',ans)
        if an > max_n:
            max_n = an
            # print('!!',ans)
        return
    for i in range(len(cir_arr)):
        if not visit[i]:
            visit[i] = 1
            ans.append(cir_arr[i])
            dfs(k + 1)
            visit[i] = 0
            ans.pop()
dfs(0)
print(max_n)
print(min_n)