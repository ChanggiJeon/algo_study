# 시간 초과로 어떤 가지치기를 해야하는 가 고민을 했지만 풀 수가 없어 풀지못했다.
# 소수를 구하는 방법을 조사했고 결과
# 에라토스테네스의 체를 모르면 풀 수 없는 문제였다고 생각한다.
# 이런 사전 지식이 필요한 알고리즘을 위해 더 많은 문제를 접하고 
# 많은 공식들을 숙지할 필요가 있을 것 같다.
N = int(input())
sosu =[]
cnt = 0
m=[False,False]+[True]*(N-1)
for i in range(2,N+1):
    if m[i]:
        sosu.append(i)
        for j in range(2*i,N+1,i):
            m[j]=False

start=0
end=0
while end<= len(sosu):
    ans = sum(sosu[start:end])
    if ans < N:
        end +=1
    elif ans >N:
        start += 1
    else:
        cnt +=1
        end +=1
print(cnt)
