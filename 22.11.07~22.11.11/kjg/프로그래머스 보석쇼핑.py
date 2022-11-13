def solution(gems):
    n = len(gems)
    kind = len(list(set(gems)))
    answer = [0, n - 1]
    dic = {gems[0]: 1, }
    s, e = 0, 0
    while s < n and e < n:
        if len(dic) < kind:
            e += 1
            if e == n:
                break
            dic[gems[e]] = dic.get(gems[e], 0) + 1

        else:
            if (e - s + 1) < (answer[1] - answer[0] + 1):
                answer = [s, e]
            if dic[gems[s]] == 1:
                del dic[gems[s]]
            else:
                dic[gems[s]] -= 1
            s += 1
    answer[0] += 1
    answer[1] += 1
    return answer