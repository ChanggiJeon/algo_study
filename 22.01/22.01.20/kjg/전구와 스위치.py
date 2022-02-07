N = int(input())
C = list(input())
W = list(input())

# 문제의 요지는 1에서 스위치를 누르고 가는냐 안누르고 가느냐이다.
# 구현할때 인자값을 동일한 인자의 리스트를 넣어주어야 하는데 딥카피를 생각못하고 그냥 그냥하다가 코드 싹다 바꿨다 ㅠㅠ
# join 쓰지말자
def zero(li):
    cnt = 1
    li[0] = str(1-int(li[0]))
    li[1] = str(1-int(li[1]))
    for i in range(1,N):
        if li[i-1] == W[i-1]:
            continue
        else:
            cnt += 1
            li[i-1] = str(1-int(li[i-1]))
            li[i] = str(1-int(li[i]))
            if i < N-1:
                li[i+1] = str(1-int(li[i+1]))
    
    if li == W:
        return cnt
    return 99999999

def one(li):
    cnt = 0
    for i in range(1,N):
        if li[i-1] == W[i-1]:
            continue
        else:
            cnt += 1
            li[i-1] = str(1-int(li[i-1]))
            li[i] = str(1-int(li[i]))
            if i < N-1:
                li[i+1] = str(1-int(li[i+1]))
    if li == W:
        return cnt
    return 99999999       

ans = min(zero(C[:]),one(C[:]))
if ans == 99999999:
    ans = -1
print(ans)