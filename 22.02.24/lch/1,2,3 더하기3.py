base = [1, 2, 4, 7]
for i in range(4, 1000000):
    base.append((base[-1] + base[-2] + base[-3]) % 1000000009)
T = int(input())
for tc in range(T):
    n = int(input())
    print(base[n-1])