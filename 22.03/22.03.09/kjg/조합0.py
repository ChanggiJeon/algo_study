# 이해가 안가서 쉐도우코딩을 해봤으나 여전히 원리를 잘 모르겠다.

N,M = map(int,input().split())

def five(a):
    answer = 0
    while a:
        a = a//5
        answer += a
    return answer

def two(a):
    answer = 0
    while a:
        a = a//2
        answer += a
    return answer

five_count = five(N) - five(M) - five(N-M)
two_count = two(N) - two(M) - two(N-M)

if M ==0:
    print(0)
else:
    print(min(five_count,two_count))
