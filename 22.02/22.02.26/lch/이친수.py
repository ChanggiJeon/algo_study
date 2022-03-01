N = int(input())
base = [0, 1, 1]
for i in range(3, 91):
    base.append(base[i-1]+base[i-2])
print(base[N])