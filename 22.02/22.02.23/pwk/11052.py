N = int(input())
lst = list(map(int, input().split()))
lst.insert(0,0)

for i in range(2, N+1):
    for j in range(1,i):
        if lst[i] < lst[j] + lst[i-j]:
            lst[i] = lst[j] + lst[i-j]

print(lst[-1])