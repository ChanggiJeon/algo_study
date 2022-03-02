N, K = map(int, input().split())
visited = [False] * 100001
visited[N] = True
queue = [(N,'')]
while queue:
    pos, oper = queue.pop(0)
    
    if pos == K:
        result = oper
        break
    
    if pos*2 <= 100000 and not visited[pos*2]:
        visited[pos*2] = True
        queue.append((pos*2,oper+'*'))
    if pos+1 <= 100000 and not visited[pos+1]:
        visited[pos+1] = True
        queue.append((pos+1, oper+'+'))
    if pos-1 >= 0 and not visited[pos-1]:
        visited[pos-1] = True
        queue.append((pos-1, oper+'-'))

print(len(result))
print(N, end=' ')
for oper in result:
    if oper == '*': N *= 2
    elif oper == '+': N += 1
    else: N-= 1
    print(N, end=' ')
