# 정렬은 안쓰면 좀 번거로운 문제

N = input()
b = []
for i in range(len(N)):
    b.append(N[i:])
sorted(b)
for a in sorted(b):
    print(a)