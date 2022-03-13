# 수학 문제는 빠르게 답을 보고 공부하는게 정신건강에 이롭다.
# [n팩토리얼에서 m의 배수]
# n팩토리얼에서 m의 배수는 n // m개다.
# ex) 100! 에서 5의 배수는 20개
# 하지만 중간중간 25와 같은 제곱수가 껴있음으로 이를 결과값에 더해줘야한다.
# n팩토리얼에서 m의 제곱수의 배수는  n // (m^k) (k는 2부터 m^k가 n보다 작은 모든 자연수)
# 따라서, n팩토리얼에서 m의 배수는 n // (m^k) (k는 1부터 m^k가 n보다 작은 모든 자연수)의 누적합이다.
def solve(n, m):
    cnt = 0
    while n:
        n = n // m
        cnt += n
    return cnt


n, r = map(int, input().split())
# nCr = n! / (n-r)! * r! 임으로 nCr에서 2의 개수는 n!의 2의 개수에서 (n-r)!과 r!의 2의 개수를 뺀 값이다.(5도 동일)
ans = min((solve(n,2) - solve(n-r,2) - solve(r,2)), (solve(n,5) - solve(n-r,5) - solve(r,5)))
print(ans)
