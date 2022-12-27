a, b =  map(int,input().split())
cnt = 0
while a != b:
    if a > b:
        cnt = -1
        break
    elif b % 2 != 0 and b % 10 != 1:
        cnt = -1
        break
    else:
        if b % 2 == 0:
            b //= 2
            cnt += 1
        else:
            b //= 10
            cnt += 1

print(cnt+1)
