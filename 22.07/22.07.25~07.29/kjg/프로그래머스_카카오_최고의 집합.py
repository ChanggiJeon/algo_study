array = [-1]
def solution(n, s):
    global array
    if n > s:
        answer = [-1]
    else:
        x = (s // n) + (s % n)
        dfs(x, s, 1, n, [x])
        answer = array
    return answer

def dfs(x, s, cnt, n, li):
    global array
    # print(x, s, cnt, n, li)
    ans = sum(li)
    if cnt == n:
        
        if ans == s:
            array = li[:]
            # print('!!')
            # print(array)
            return 1
        return
    check = 0
    for i in range(x,-1,-1):
        if ans + i <= s:
            check = dfs(i, s, cnt + 1, n, [i]+ li[:])
        if check == 1:
            return 1
solution(2,9)


# from collections import deque


# def solution(n, s):
#     answer = []
#     if n > s:
#         answer = [-1]
#     else:
#         x = (s // n) + (s % n)
#         q = deque()
#         q.append([1,[x]])
#         while q:
#             cnt, li = q.popleft()
#             ans = sum(li)
#             if cnt == n:
#                 if ans == s:
#                     answer = li[:]
#                     break
#                 continue
#             for i in range(1, li[0] + 1):
#                 if i + ans <= s:
#                     q.appendleft([cnt + 1,[i]+li[:]])
#     return answer
