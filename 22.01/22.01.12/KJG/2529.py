k = int(input())
giho = input().split()
mx,mn = "",""
used= [False]*10

def compare(i,j,k):
    if k == '<':
        return i<j
    else:
        return i>j
    

def answer(cnt,x):
    global mn,mx
    if cnt == k+1:
        # 밑에서부터 올라가기 때문에 가장 먼저 나오는 숫자가 최소값
        if not len(mn):
            mn = x
        # 그리고 최소값이 존재한다면 그 이후로 성립하는 모든 수는 최대값 후보
        else:
            mx = x
        return
    for i in range(10):
        if not used[i]:
            # 여기서 str을 쓰는 이유는 현재 기록되는 숫자가 문자형식이고 한자리 숫자는 문자의 비교문으로도 구분 가능하다
            if cnt == 0 or compare(x[-1],str(i),giho[cnt-1]):
                used[i] = True
                answer(cnt+1,x+str(i))
                used[i] = False

answer(0,"")
print(mx)
print(mn)