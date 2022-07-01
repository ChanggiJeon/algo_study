N = int(input())
# 일단 데이터 저장부터
base = [0 for _ in range(N)]
ans = [1 for _ in range(N)]
for i in range(N): 
    base[i] = list(map(int, input().split()))

# i번째 사람을 기준으로 j를 돌려서 덩치가 큰사람이 있으면 등수+1
for i in range(N):
    for j in range(N):
        if base[i][0] < base[j][0] and base[i][1] < base[j][1]:
            ans[i] += 1
            
# 형식에 맞게 출력
for i in range(N):
    if i == N-1:
        print(ans[i])
    else:
        print(ans[i],end=" ")
