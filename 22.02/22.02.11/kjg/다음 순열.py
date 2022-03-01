# 브루트포스로 코드를 짜다가 이걸로 짜선 시간초과 뜨겠다 싶어 고민

cnt = 0
N = int(input())
M = list(map(int,input().split()))
C = [i for i in range(1,N+1)]
D = C[::-1]
cnt=0
if M == D:
    # 순서대로 나열한 리스트를 역순으로 저장한 리스트랑 동일하면 -1
    print('-1')
else:
    # 아니면 변경포인트 수색
    # 수색을 하는 기준은 현재 지점보다 다음지점이 작은면 해당 포인트를 저장
    # 기본은 0
    for i in range(N-1,0,-1):
        if M[i] > M[i-1]:
            cnt = i-1
            break
    # 확정된 수색포인트를 기점으로
    # 수색포인트 보다 작은 숫자를 가진 지점 탐색후
    # 자리교환
    # 자리 교환된 포인트 기점까지와 나머지 숫자들을 정렬하면
    # 다음 순열이 나타난다.
    for i in range(N-1,0,-1):
        if M[cnt] < M[i]:
            M[cnt],M[i] = M[i],M[cnt]
            a = M[:cnt+1] + sorted(M[cnt+1:])
            print(*a)
            break