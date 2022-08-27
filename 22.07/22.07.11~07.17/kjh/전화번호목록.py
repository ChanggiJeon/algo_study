def solution(phone_book):
    # 접두어(시작점 기준)임으로 정렬하여 비교하면 존재 유무를 체크할 수 있다.
    phone_book.sort()
    for i in range(len(phone_book) - 1):
        num_now = phone_book[i]
        # 문자열 데이터 임으로 앞에 숫자의 길이만큼 잘라서 같은지 비교
        num_next = phone_book[i + 1][:len(num_now)]
        if num_now == num_next:
            return False
    return True