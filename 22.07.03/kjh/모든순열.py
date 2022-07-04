n = int(input())
arr = []

# 재귀함수를 이용한 모든 순열 구하기
def perm():
    # 종료 조건 : 길이가 n인 수열에 도달하면
    if len(arr) == n:
        # 한줄로 출력 후 리턴
        print(*arr)
        return
    # 길이가 n 미만일 때, 1~n까지 숫자를 차례대로 하나씩 넣기
    for i in range(1, n + 1):
        # 중복 제거
        if i in arr: continue
        arr.append(i)
        perm()
        arr.pop()

perm()