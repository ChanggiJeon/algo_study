def GCD(a, b):
    x = min(a, b)
    y = max(a, b)
    for i in range(x, 0, -1):
        if x%i == 0 and y%i == 0:
            gcd = i
            break
    return gcd

t = int(input())
for tc in range(t):
    base = list(map(int, input().split()))
    total = 0
    for i in range(1, base[0]):
        for j in range(i+1, base[0]+1):
            total += GCD(base[i], base[j])
    print(total)