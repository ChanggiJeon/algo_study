# GCD가 최대공약수라는 걸 처음 알았다...
# 최대공약수 구하는 법 = 유클리드 알고리즘 = GCD 구하는 법
# tip: math.gcd가 사용 가능하다면 사용하도록 하자
def gcd(x, y):
    if y == 0:
        return x
    else:
        return gcd(y, x % y)


T = int(input())
for tc in range(T):
    arr = list(map(int, input().split()))
    n = arr.pop(0)
    ans = 0
    # 두개씩 쌍을 선택(i, j)
    for i in range(n-1):
        # i 다음거부터 끝까지
        for j in range(i+1, n):
            ans += gcd(arr[i], arr[j])
    print(ans)