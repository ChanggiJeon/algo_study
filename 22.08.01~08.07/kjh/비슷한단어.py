def solve(key_word, check_word):
    # 한글자씩 확인해서 키워드에 있으면 제거
    check = True
    for c in check_word:
        if c in key_word:
            key_word.remove(c)
        # 키워드에 없으면 check_word가 두개이상 다른지 검사
        else:
            # 한번 체크했는지 확인 후 안했으면 체크
            if check:
                check = False
            # 한번 체크 했으면 두번째는 비슷한 단어 불가능
            else:
                return False
    # 다 끝났을 때 key_word가 두개이상 남았는지 검사
    if len(key_word) > 1:
        return False
    return True


# 입력값
n = int(input())
key = input()
# 키워드를 리스트 형태로 변환(remove 매서드 사용하기 위함)
key_arr = list()
for char in key:
    key_arr.append(char)
# 키워드 제외 (n-1)
words_arr = list(input() for _ in range(n-1))

# 풀이
ans = 0
for word in words_arr:
    # 키워드 깊은복사
    if solve(key_arr[:], word):
        ans += 1
print(ans)