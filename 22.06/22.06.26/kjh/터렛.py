# 참고 : https://ooyoung.tistory.com/111
# 원의 방정식을 알아야 풀 수 있는 문제였다... 레이더처럼 원 모양의 이미지를 생각해서 터렛으로 주제를 정한 것 같다.
import math

T = int(input())
for tc in range(1, T+1):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())
    # 두 점 사이의 거리
    d = math.sqrt((x1 - x2) ** 2 + (y1 - y2) ** 2)
    # 두 점이 동심원이고 반지름이 같을 때 : -1
    if d == 0 and r1 == r2:
        print(-1)
    # 두 원이 내접 또는 외접 할때 : 1
    elif abs(r1 - r2) == d or r1 + r2 == d:
        print(1)
    # 두 원이 서로 다른 두 점에서 만날 때 => 두 원 사이의 거리가 내접할 때는 최소값이고 외접할 때는 최대값임으로 그 사이에 위치한 경우가 두 원이 겹치는 경우이다. : 2
    elif abs(r1 - r2) < d < (r1 + r2):
        print(2)
    else:
        print(0)
