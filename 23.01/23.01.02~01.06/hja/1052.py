
n, k = map(int,input().split())
cnt = 0
while bin(n)[2:].count('1') > k:
    n += 1
    cnt += 1

print(cnt)


# cnt = 0
# finalMaxSquare = 0
#
# if k > n:
#     print(-1)
# elif k == n:
#     print(0)
# else:
#     while cnt != k:
#         maxSquare = 1
#         while n > maxSquare:
#             maxSquare *= 2
#         maxSquare //= 2
#         n -= maxSquare
#         cnt += 1
#         finalMaxSquare = maxSquare
#
#     print(finalMaxSquare - n)
