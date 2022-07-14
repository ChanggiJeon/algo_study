def solution(clothes):
    a = {}
    for c in clothes:
        if c[1] not in a:
            a[c[1]] = 2
        else:
            a[c[1]] += 1
    answer = 1
    for v in a.values():
        answer *= v
    
    return answer - 1