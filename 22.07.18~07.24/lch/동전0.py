# 기본조건부터 입력
N, K = map(int, input().split())
base = [0 for _ in range(N)]
for i in range(N):
    base[i] = int(input())
cnt = 0
# 동전의 가치는 오름차순 이고 초기 값은 1, 이후는 임의의 배수 이다
# 예제는 규칙적 으로 되어 있지만 최종 답은 아닐 수 도 있기에 일반화 하면 안될것 같다

# N은 10이하 이고 동전의 가치는 2배 이상 오르니 현재 K값 에서 큰 순서로 하나씩 빼면 가능 하다
# 단 이게 최선은 아닐것, 문제 부터 풀고 분석 한 번 해보자
'''
while K != 0:
    if K >= base[N-1]:
        K -= base[N-1]
        cnt += 1
    else:
        for i in range(N):
            if base[i] == K:
                K -= base[i]
                cnt += 1
                break
            elif base[i] > K:
                K -= base[i-1]
                cnt += 1
                break
print(cnt)                
'''
# 답은 구할수 있으나 시간 초과가 나온다.
# 중간부터 반복 하거나 다른 방법으로

while K != 0:
    for i in range(N-1, -1, -1):
        if base[i] == K:
            K -= base[i]
            cnt += 1
            break
        elif base[i] < K:
            cnt += K // base[i]
            K = K % base[i]
            break
print(cnt)