'''
1 = 1
    1
    
    
2 = 2
    
    2
    
3 = 3
    12
    21
    3

4 = 3
    1+21    1+3
    
    31
    
5 = 4   131/32/23/212
    1+31
    2+12    2+3
    3+2
    
6 = 8   123/132/213/231/312/321/1212/2121
7 = 9
'''
result = [[1,0,0],[0,1,0],[1,1,1]]
for _ in range(100000):
    result.append([
        (result[-1][1] + result[-1][2])%1000000009,
        (result[-2][0] + result[-2][2])%1000000009,
        (result[-3][0] + result[-3][1])%1000000009
    ])
for _ in range(int(input())):
    print(sum(result[int(input())-1])%1000000009)
# for _ in range(int(input())):
#     n = int(input())
#     if n <= len(result):
#         print(sum(result[n-1]))
#         continue
#     while n > len(result):
#         result.append([
#             (result[-1][1] + result[-1][2])%1000000009,
#             (result[-2][0] + result[-2][2])%1000000009,
#             (result[-3][0] + result[-3][1])%1000000009
#         ])
#     print(sum(result[-1]))