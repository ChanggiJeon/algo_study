
# 이 문제의 요지는 각 형제들 간의 거리가 가장 최소가 되는 것을 찾는 것이다.
# 1에서 부터 하나씩 올라가면 무조건 정답을 찾을 수 있지만 시간이 많이 걸리느 관계로 pass
n,s = map(int,input().split())
a = list(map(int, input().split()))
# 그리고 직선상 동생이 형보다 앞에 있을 수 도 있으므로 각 동생과의 거리를 절대값으로 도출한다
dif = list(set(abs(a[i] -s) for i in range(n)))
# 그리고 가장 가까운 거리가 형의 초기 이동범위라고 할 수 있다.
d_min = min(dif)
# 그리고 각 동생들의 위치를 순회하며 최대공약수를 찾는다.
# 최대 공약수는 유클리드 공식을 사용한다.

def uclid(a,b):
    while b:
        c = b
        b = a%b
        a = c
    return a

for i in range(len(dif)):
    d_min = uclid(dif[i],d_min)
print(d_min)
