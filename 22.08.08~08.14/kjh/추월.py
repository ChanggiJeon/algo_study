# n만큼 돌면서 딕셔너리에 {차번호 : 입장순서}로 저장
# n만큼 다시 돌면서 입장순서가 더 작아진(빨라진) 차를 찾는다.
# 단, 더 작아진 차가 한대 발생할때마다 입장순서에 +1씩 더해서 비교해야한다.(추월한 차량 카운트)

# 입력값
n = int(input())
_dict = dict()
for i in range(n):
    _dict[input()] = i

# 추월 검사
ans = 0
cnt = [0] * n # 각 차량마다 추월당한 자동차의 누적 수 (index = 입장순서)
for i in range(n):
    order = _dict[input()]
    # 내 순서 + 나를 추월한 차량수가 현재 순번이면 나는 추월안한거임
    if order + cnt[order] == i:
        continue
    # 다르면 추월한거임 -> 내가 추월한 차량들 cnt 누적하고 ans 증가
    else:
        for j in range(order):
            cnt[j] += 1
        ans += 1

print(ans)