N = int(input())

lst = [1]*10
result = [1]*10

for _ in range(N-1):
    for i in range(10):
        result[i] = sum(lst[:i+1])
    lst = result.copy()

print(sum(result)%10007)