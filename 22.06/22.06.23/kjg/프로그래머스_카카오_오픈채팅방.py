a = int(input())
for _ in range(a):
    b = int(input())
    c = sorted(list(map(int, input().split())))
    d = [0] * b
    for i in range(b):
        if i % 2 == 0:
            d[i // 2] = c[i]
        else:
            d[-(i // 2 + 1)] = c[i]
    e = [0] * b
    for j in range(b):
        e[j] = abs(d[j] - d[(j + 1) % b])
    print(max(e))