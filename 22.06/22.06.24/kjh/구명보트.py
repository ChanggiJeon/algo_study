### 방문 체크 방식으로 문제는 해결하였으나 효율성 테스트 통과 X
def solution(people, limit):
    people.sort()
    count_people = len(people)
    v = [0] * count_people
    answer = 0

    for i in range(count_people - 1, -1, -1):
        # 아직 남아있는 모든 사람에 대해서만 검사
        if not v[i]:
            # 남아있는 사람중 가장 무거운 사람 우선 태우고
            tmp_limit = limit - people[i]
            v[i] = 1
            # 더 태울 수 있는지 확인
            if count_people == sum(v):
                answer += 1
                break
            least_weight = people[v.index(0)]
            # 태울 수 있는 사람중 가장 몸무게가 적은 사람이 tmp_limit을 초과하면 더 못태움
            if least_weight > tmp_limit:
                answer += 1
                continue

            # 더 태울 수 있는 경우
            # 태울 수 있는 사람이 한 명만 남은 경우 : 태우고 끝
            if count_people == sum(v) + 1:
                answer += 1
                break

            # 태울 수 있는 사람이 여러명인 경우
            for j in range(count_people):
                # tmp_limit 초과 시 가능 여부와 상관없이 이전 index에 해당하는 사람 보냄
                if tmp_limit < people[j]:
                    v[tmp_index] = 1
                    answer += 1
                    break
                # tmp_limit 이하일 경우 남아 있으면 index 저장
                else:
                    if not v[j]:
                        tmp_index = j

    return answer

### 구글에서 그리디한 방식으로 효율성까지 해결한 완벽한 코드 분석
# 체크 포인트 1 : limit을 최대로 채워서 보내야 가장 효율적이라고 생각했으나 정렬된 상태의 리스트임으로 뒤에서부터 계산할 때 현재 max 값이 가장 큰 값임으로 min 값을 굳이 아껴 둘 필요가 없음
# -> 현재의 max + min 값이 항상 최대임!!
# 체크 포인트 2 : 방문 처리가 아닌 index를 활용
def solution(people, limit) :
    count = 0
    people.sort()

    # a는 앞에서부터 출발
    a = 0
    # b는 뒤에서부터 출발
    b = len(people) - 1
    while a < b:
        # max + min 값이 limit보다 작으면 두명 태워서 보냄
        if people[b] + people[a] <= limit:
            a += 1
            # count는 두명을 보낸 횟수
            count += 1
        # max + min 값에 상관없이 max에 해당하는 놈은 보냄
        b -= 1
    # count는 두 명을 태워 보냈을 때만 증가했음으로 전체 인원수에서 두 명을 보낸 횟수를 빼주면 총 몇번을 보내야하는지 나옴
    return len(people) - count