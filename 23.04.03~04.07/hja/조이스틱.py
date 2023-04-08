name = 'JEROEN'


def solution(name):
    answer = 0

    list_n = [min(abs(ord('A')-ord(n)), 26-abs(ord('A')-ord(n))) for n in name]
    answer += sum(list_n)

    min_move = len(name) - 1  # 최소 좌우 이동 횟수는 길이 - 1

    for i in range(len(name)):

        # 연속된 A 문자열 찾기
        next = i + 1
        while next < len(name) and name[next] == 'A':
            next += 1
        min_move = min([min_move, 2 * i + len(name) -
                       next, i + 2 * (len(name) - next)])

    answer += min_move

    return answer


print(solution(name))
