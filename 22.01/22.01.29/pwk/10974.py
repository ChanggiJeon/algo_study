N = int(input())
lst = [False]*N

def solve(cnt, num):
    if cnt == N:
        print(' '.join(str(num)))
    
    for i in range(N):
        if not lst[i]:
            lst[i] = True
            solve(cnt+1, num*10+i+1)
            lst[i] = False

solve(0, 0)