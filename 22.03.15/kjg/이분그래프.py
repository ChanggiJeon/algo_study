from collections import deque

# 이분그래프 개념은 생소해서 정답을 가지고 코드의 의미들을 분석해보려고 한다.
# dfs로 진행할 경우
# 각 인자의 의미는 인덱스와, 이분하는 포인트이다(2가지로 나눌 수 있으면 충분)
# 결과 fail

def dfs(idx,bip):
    #방문한 위치에 색상을 입혀준다.
    visit[idx] = bip
    # 그리고 현재 좌표를 다 읽어내려가고
    for i in Map[idx]:
        # 보유하고 있는 노드 중에 방문하지 않으면 
        if visit[i] == 0:
            # dfs로 넘긴다
            # 많이 생략되었지만 해당 함수의 결과값이 TRUE,FALSE 두가지기에 아래와 같은 코드로 쓰인것 같다.
            # 다음 노드에서 이분그래프가 아님이 판별되었다면 FALSE를 리턴
            # 구분포인트를 뒤집어서 dfs 실행
            if not dfs(i,-bip):
                return False
        # 여기는 방문예정지가 현재와 포인트와 동일한 포인트이면 이분그래프가 아님으로 False
        elif visit[i] ==visit[idx]:
            return False
    # 이모든 과정을 소화하면 이분 그래프이다
    return True

def bfs():
    q = deque()
    # group은 bfs에서 사용하는 bip 라고 생각하면된다.
    group = 1
    # 그래프 여부
    biparatite = True
    print(Map)
    for i in range(V):
        if visit[i] == 0:
            q.append(i)
            visit[i] = group
            
        while q:
            # print(q)
            v= q.popleft()
            for j in Map[v]:
                print(j,visit[j])
                if visit[j] == 0:
                    q.append(j)
                    visit[j] = visit[v]*(-1)
                elif visit[j]==visit[v]:
                    print(j)
                    biparatite = False
                    return biparatite
        return biparatite


N = int(input())


for _ in range(N):
    V,E = map(int,input().split())
    Map = [[] for _ in range(V+1)]
    visit = [0] * (V+1)
    for _ in range(E):
        x,y = map(int,input().split())
        Map[x].append(y)
        Map[y].append(x)

    bipartite = False
    biparatite = bfs()
    # for i in range(V):
    #     visit[i] = 1
    #     # biparatite = dfs(i,1)
        
    #     if not biparatite:
    #         break
    print("YES" if biparatite else 'NO')
    # 이분그래프 나타내는 척도
