def counting(lst):
    global largest
    now = 'X'
    cnt = 0
    for i in range(N):
        for j in range(N):
            if now == lst[i][j]:
                cnt += 1
            else:
                if largest < cnt:
                    largest = cnt
                now = lst[i][j]
                cnt = 1
        if largest < cnt:
            largest = cnt
        now = 'X'
        cnt = 0
            
    now = 'X'
    cnt = 0
    for i in range(N):
        for j in range(N):
            if now == lst[j][i]:
                cnt += 1
            else:
                if largest < cnt:
                    largest = cnt
                now = lst[j][i]
                cnt = 1
        if largest < cnt:
            largest = cnt
        now = 'X'
        cnt = 0


N = int(input())
lst = [list(input()) for _ in range(N)]
largest = 0

for i in range(N):
    for j in range(N):
        if j+1 < N:
            lst[i][j], lst[i][j+1] = lst[i][j+1], lst[i][j]
            counting(lst)
            lst[i][j], lst[i][j+1] = lst[i][j+1], lst[i][j]
        if i+1 < N:
            lst[i][j], lst[i+1][j] = lst[i+1][j], lst[i][j]
            counting(lst)
            lst[i][j], lst[i+1][j] = lst[i+1][j], lst[i][j]
        if largest == N:
            break

print(largest)