def solution(clothes):
    count = dict()
    # toc = type of cloth
    for name, toc in clothes:
        # 딕셔너리의 get 함수는 첫번째 인자값을 키값으로 찾아서 없으면 두번째 인자값을 디폴트로 추가한다.
        count[toc] = count.get(toc, 0) + 1
    # 경우의 수를 곱하기 위해 1로 시작
    answer = 1
    for toc in count:
        answer *= count[toc] + 1 # 안입는 경우를 포함하여 +1의 경우의 수로 계산
    answer -= 1
    return answer