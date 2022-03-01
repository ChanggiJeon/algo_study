# 0 -> 1
# 1 -> 1
# 2 -> 2
# 3 -> 4
# 4 -> 7
# 5 -> 13
# 6 -> 24
# 7 -> 44

result = [1,1,2]

TC = int(input())
for _ in range(TC):
    N = int(input())
    while not N < len(result):
        result.append((result[-1] + result[-2] + result[-3])%1000000009)

    print(result[N])