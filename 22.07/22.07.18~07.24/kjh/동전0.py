# A의 i번째 값이 A의 i-1번째의 배수라는 것은 여러개의 i-1번째 동전으로 i번째 값을 만들 수 있다는 의미이다. -> 그리디로 풀 수 있다.

n, k = map(int, input().split())
coins = list(int(input()) for _ in range(n))
# 큰값부터 체크
coins.reverse()
coin_cnt = 0
for coin in coins:
    # k보다 동전의 값이 더 크면 넘어감
    if coin > k: continue

    # 동전이 몇개가 필요한지 저장 후 cnt 증가 & k감소
    tmp_cnt = k // coin
    coin_cnt += tmp_cnt
    k -= tmp_cnt * coin

    # k가 0이면 중단
    if not k: break

print(coin_cnt)