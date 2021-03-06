# a, b의 최소 공배수는 a의 배수이면서 동시에 b의 배수여야 한다.
# a의 배수전체를 리스트에 담고 b의 배수를 검사한다.
# a * b 안에 최소공배수는 반드시 존재한다. -> 시간초과

# [유클리드 알고리즘]
# 최대공약수 구하는 알고리즘
# a 나누기 b의 나머지를 a에 저장
# a와 b의 값을 서로 바꿈
# 나머지가 0이 될 때까지 반복
# 나머지가 0이 되면 마지막으로 나온 나머지가 최대 공약수

# [최소 공배수]
# a와 b를 곱하고 최대 공약수로 나누면 최소 공배수


T = int(input())
for tc in range(1, T+1):
    a, b = map(int, input().split())
    c, d = a, b

    while d != 0:
        c = c % d
        c, d = d, c

    print(a * b // c)
