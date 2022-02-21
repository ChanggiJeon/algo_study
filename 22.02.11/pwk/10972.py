N = int(input())
before = list(map(int, input().split()))
for i in range(N-1, 0, -1):
    if before[i] > before[i-1]:
        result = before[:i-1]
        next = before[i-1:]
        break
else:
    print(-1)
    exit()

k = next[0]
next = sorted(next)
for i in range(len(next)):
    if next[i] > k:
        result.append(next[i])
        next.pop(i)
        result.extend(next)
        break
print(*result)