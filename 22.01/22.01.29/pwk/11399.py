N = int(input())
lst = sorted(list(map(int, input().split())))

result = 0
for i in range(N):
    result += lst[i] * (N-i)
    
print(result)