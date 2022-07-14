def solution(phone_book):
    answer = True
    phone_book.sort()
    # 문자열의 정렬이라는 점을 주의하자
    # 숫자와 정렬방식이 달라
    #["119", "97674223", "1195524421"] 가
    # ["119", "1195524421", "97674223"] 로 정렬된다.
    for i in range(len(phone_book)-1):
        if len(phone_book[i]) < len(phone_book[i+1]):
            if phone_book[i + 1][:len(phone_book[i])] == phone_book[i]:
                answer = False
                break
    return answer