from collections import deque

n, k = map(int, input().split())
q = deque()
q.append(n)
v = [0] * 100001

# 방문로그를 q에 같이 실어 주었더니 시간초과;
# while True:
#     cn, log = q.popleft()
#     log.append(cn)
#     for nn in (cn * 2, cn + 1, cn - 1):
#         if nn == k:
#             print(len(log))
#             log.append(nn)
#             for i in range(len(log)):
#                 print(log[i], end=' ')
#             exit()
#
#         if 0 <= nn <= 100000 and not v[nn]:
#             v[nn] = 1
#             q.append((nn, log[:]))

# 방문로그를 따로 만들어서 출력 시 역참조 하면서 출력
# 이에 따라 방문기록은 누적방문횟수로 변경
log = [0] * 100001
while q:
    cn = q.popleft()
    # 종료 조건 : 도착점 도착
    if cn == k:
        # 누적방문횟수 출력
        print(v[cn])
        ans = []
        # cn이 출발점과 같아질때까지 거슬러 올라가면서 ans에 저장
        while cn != n:
            ans.append(cn)
            # 돌아가기
            cn = log[cn]
        # 출발점 넣기(log에 출발점은 안찍힘)
        ans.append(n)
        # 역순으로 참조하였음으로 순서 뒤집기
        ans.reverse()
        print(' '.join(map(str, ans)))
        break
    # 위에거(순간이동 먼저하면)는 틀렸다고 나옴 ㄷㄷ.. 시간초과도 아니고 틀렸다... 왜인지는 모르겠다...
    # for nn in (cn * 2, cn + 1, cn - 1):
    for nn in (cn - 1, cn + 1, cn * 2):
        # 다음 위치의 범위, 방문 확인
        if 0 <= nn <= 100000 and not v[nn]:
            # 다음 위치가 도착지면
            # 방문 횟수 체크
            v[nn] = v[cn] + 1
            # 다음 위치 확인
            q.append(nn)
            # 다음 위치의 log에 어디서 왔는지 표기
            log[nn] = cn