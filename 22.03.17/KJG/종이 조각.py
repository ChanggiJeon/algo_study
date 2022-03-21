# 비트마스크는 각 지점의 포인트가 있는지 없는지를 0과1로 구분하여 
# 사용자가 원하는 연산을 진행하는 방법이다.
# 장점으로는
# 1. 수행시간이 빠르다
# 2. 코드가 짧다
# 3. 메모리 사용량이 적다 : 각위치를 1과 0으로 구분하기 때문 10자리라고 하더라도
# 비트마스크 사용시 1000000000 으로 표기될수 있다.
# 만약 2차원 배열이 아래와 같이 있다고 하자
# [1,2,3]
# [4,5,6]
# 이 때 선택된 포인트가 1,4라고 했을 때
# (포인트는 뒤에서 부터 읽어온다.)
# 001001 라고 표기 된다.
def bitmask():
    global maxAns
    # 아래와 같이 표기한다면
    # R*C 가 6일 경우
    # 1 에서 1000000이 됨을 의미하며
    # 1000000을 제외한 0000000,0000001,0000010,0000011, . . .  0111111까지 
    # 각 위치를 표현할 수 있다.
    for a in range(1<<R*C):
        # 사용된 포인트 수가 갱신될때 마다 합계는 초기화
        total = 0
        # 이 때 각 포인트가 켜져있을 경우 가로를 계산하고
        # 꺼져있다면 세로를 계산한다.
        # 가로 합 계산
        for r in range(R):
            rowsum = 0
            for c in range(C):
                idx = (C*r) + c
                # 가령 위 배열에서 [1,2,3]이 사용되었다면
                # a는 0000111 이라고 표기될 것이고
                # 아래 &연산자를 통해 0000001, 0000010, 0000100(idx 0,1,2) 거쳐
                # 1,12,123순으로 hori를 갱신한 다음 0001000 에 들어서면서 토탈에 합쳐지게 된다. 
                if a & (1<<idx) != 0:
                    rowsum = rowsum*10 + Map[r][c]
                else:
                    total += rowsum
                    rowsum = 0
            total += rowsum
        
        # 세로 합 계산
        for c in range(C):
            colsum = 0
            for r in range(R):
                idx = (C*r) + c
                # 위의 예시와 같이 [1,2,3]이 사용되었다면 0인 위치는 [4,5,6]이다
                # 현재 a 는 000111인 상태
                # idx의 순서는 0,3,1,4,2,5
                # 따라서 각각 4,5,6을 더하게 된다.
                if a & (1<<idx) == 0:
                    colsum = colsum*10 + Map[r][c]
                else:
                    total += colsum
                    colsum = 0
            total += colsum
        maxAns = max(maxAns,total)
        
        



R,C = map(int,input().split())
Map = [list(map(int,list(input()))) for _ in range(R)]
maxAns = 0
bitmask()
print(maxAns)

