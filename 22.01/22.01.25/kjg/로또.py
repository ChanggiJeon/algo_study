def force(arr,cnt):
    if cnt == 6:
        print(*lst)
        return

    for i in range(cnt,len(arr)):
        if cnt==0 or (not visit[i] and lst[-1]<arr[i]):
            visit[i] = True
            lst.append(arr[i])
            force(arr,cnt+1)
            visit[i] = False
            lst.pop()

N=[]        
while True:
    n = list(map(int,input().split()))
    
    if n[0] == 0:
        break
    else:
        n = n[1:]
        N.append(n)
for a in range(len(N)):
    lst = []   
    visit = [0]*(len(N[a]))
    force(N[a],0)
    if a < len(N)-1:
        print()
        