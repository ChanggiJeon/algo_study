'''
풀이 : 그냥 사전순대로 중복 없이 순열 만들어 출력하면 됩니다.

+ 전 사전순을 잘못 봐서 lst를 str로 그대로 넣고 돌려서 8번 틀렸네요...
    문자열 1111 / 999 
    숫자 999 / 1111
    순서대로 옵니다. 조심하세요...
'''

N, M = map(int, input().split())
lst = list(map(int, input().split()))
lst = sorted(lst)
check = [False]*N

def solution(result):
    if len(result) == M:
        print(' '.join(map(str, result)))
        return
    for i in range(N):
        if not check[i]:
            check[i] = True
            result.append(lst[i])
            solution(result)
            result.pop()
            check[i] = False

solution([])