'''
메모리 초과 : prime_nums에 모든 숫자를 다 넣는게 안되나 봅니다.
'''
# N = int(input())
# prime_nums = set([i for i in range(2,N+1)])

# for i in range(2,N+1):
#     if i in prime_nums:
#         prime_nums -= set([j for j in range(2*i, N+1, i)])

# prime_nums = list(prime_nums)
# cnt = 0
# for i in range(len(prime_nums)):
#     num = prime_nums[i]
#     add_idx = 1
#     while num <= N:
#         if num == N:
#             cnt += 1
#             break
#         if i+add_idx == len(prime_nums):
#             break
#         num += prime_nums[i+add_idx]
#         add_idx += 1

# print(cnt)

'''
시간초과 : prime_nums를 True/False로 구성하는건 성공
전체를 계속 돌리면서 탐색하는게 너무 오래 걸리나 봅니다.
'''
# N = int(input())
# prime_nums = [True]*(N+1)

# for i in range(2, N+1):
#     if prime_nums[i]:
#         for j in range(2*i, N+1, i):
#             prime_nums[j] = False

# cnt = 0
# for i in range(2, N+1):
#     if not prime_nums[i]:
#         continue
#     num = i
#     if num == N:
#         cnt += 1
#         break
#     for j in range(i+1, N+1):
#         if num == N:
#             cnt += 1
#             break
#         if not prime_nums[j]:
#             continue
#         num += j
        
# print(cnt)

'''
prime_nums를 True/False로 탐색하고 소수만 가지는 리스트를 생성
탐색
'''
N = int(input())
prime_nums = [True]*(N+1)
prime_nums_result = []

for i in range(2, N+1):
    if prime_nums[i]:
        prime_nums_result.append(i)
        for j in range(2*i, N+1, i):
            prime_nums[j] = False
            
cnt = 0
for i in range(len(prime_nums_result)):
    num = prime_nums_result[i]
    add_idx = 1
    while num <= N:
        if num == N:
            cnt += 1
            break
        if i+add_idx == len(prime_nums_result):
            break
        num += prime_nums_result[i+add_idx]
        add_idx += 1

print(cnt)