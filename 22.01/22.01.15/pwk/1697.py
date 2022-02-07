'''
평범한 BFS문제
문제 다 풀어놓고 N==K인 경우를 생각 안해서 한참 해맸네요;;
'''

N, K = map(int, input().split())
history = [0]*100001
if N == K:
    print(0)
    exit()

queue = [N]
while queue:
    pos = queue.pop(0)
    next_pos = [pos+1, pos*2, pos-1]
    if K in next_pos:
        print(history[pos] + 1)
        break
    for i in next_pos:
        if 0 <= i <= 100000:
            if not history[i]:
                history[i] = history[pos]+1
                queue.append(i)