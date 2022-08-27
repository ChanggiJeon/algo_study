# 풀이 : 각 원소의 차가 최소일 때 원소의 곱은 최대가 된다.
def solution(n, s):
    rest = s % n
    answer = [s // n] * n
    for i in range(rest):  # rest는 항상 n보다 작다.
        answer[n - i - 1] += 1
    # n이 s보다 크면 1이상의 값을 가질 수 없다.
    if n > s:
        answer = [-1]

    return answer