# 시간 제한 1초, S와 A의 최댓값이 10^9인 순간 풀 수 없음을 직감했다.

# (수빈이의 위치 - 동생의 위치)의 절댓값들의 최대공약수가 모든 동생을 찾기 위한 d의 최댓값이다.(이걸 어케 생각해내지..?)

# 아무튼 최대공약수 = 유클리드 호제법
def gcd(x, y):
    if y == 0:
        return x
    else:
        return gcd(y, x % y)


n, s = map(int, input().split())
arr = list(map(int,input().split()))
# 수빈 위치 - 동생 위치 절대값 모으기
L = len(arr)
abs_arr = []
for i in range(L):
    abs_arr.append(abs(s - arr[i]))
# 최대공약수 구하기
ans = 0
for i in range(L-1):
    for j in range(i+1, L):
        tmp = gcd()

