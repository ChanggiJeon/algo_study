N = int(input())
lst = list(map(int, input().split()))

best = lst[0]
now = lst[0]
for num in lst[1:]:
    if now < 0:
        now = num
    else:
        now += num
    if best < now:
        best = now

print(best)