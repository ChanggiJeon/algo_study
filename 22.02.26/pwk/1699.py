'''  백트래킹 실패 : 시간초과  '''
# def solve(num, cnt):
#     global min_cnt
#     if cnt >= min_cnt:
#         return
#     if num == 0:
#         min_cnt = cnt
#         return
    
#     for i in range(int(num**0.5)-1 , -1, -1):
#         if i == 0 and cnt + num >= min_cnt:
#             return
#         solve(num - lst[i], cnt + 1)

# lst = []
# for i in range(1, 317):
#     lst.append(i**2)

# N = int(input())
# min_cnt = N
# solve(N,0)
# print(min_cnt)

N = int(input())
lst = [False for i in range(100001)]
lst[0] = True
base = []
queue = []
cnt = 0
for i in range(1,317):
    lst[i**2] = 1
    base.append(i**2)
    queue.append(i**2)
    cnt += 1

while cnt != 100000:
    num = queue.pop(0)
    for i in base:
        if num+i <= 100000 and not lst[num+i]:
            lst[num+i] = lst[num] + 1
            queue.append(num+i)
            cnt += 1

print(lst[N])

