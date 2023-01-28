a = [-16,27,65,-2,58,-92,-71,-68,-61,-33]


def solution(a):
    answer = 0
    if len(a) <= 2:
        return len(a)
    else:
        start = a[0]
        end = a[-1]
        for i in range(1, len(a)-1):
            if start > a[i]:
                answer += 1
                start = a[i]
            if end > a[-1-i]:
                answer += 1
                end = a[-1-i]
        if start != end:  ## 짝수
            return answer + 2
        else: ## 홀수
            return answer + 1

print(solution(a))