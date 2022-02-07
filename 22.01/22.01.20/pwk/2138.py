N = int(input())
now = list(input())
want = list(input())

# case1 = 1번 클릭 / case2 = 2번 클릭
case1 = now.copy()
case2 = now.copy()
cnt1 = 1
cnt2 = 0

# case1에서 1번 클릭
case1[0] = str((int(case1[0])+1)%2)
case1[1] = str((int(case1[1])+1)%2)

#시뮬
for i in range(1, N):
    #case1번 처리
    if case1[i-1] != want[i-1]:
        case1[i-1] = str((int(case1[i-1])+1)%2)
        case1[i] = str((int(case1[i])+1)%2)
        if i != N-1:
            case1[i+1] = str((int(case1[i+1])+1)%2)
        cnt1 += 1
    #case2번 처리
    if case2[i-1] != want[i-1]:
        case2[i-1] = str((int(case2[i-1])+1)%2)
        case2[i] = str((int(case2[i])+1)%2)
        if i != N-1:
            case2[i+1] = str((int(case2[i+1])+1)%2)
        cnt2 += 1
        
if want == case1 and want == case2:
    print(min(cnt1, cnt2))
elif want == case1:
    print(cnt1)
elif want == case2:
    print(cnt2)
else:
    print(-1)