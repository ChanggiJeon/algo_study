# 풀이1. 완전탐색

def greeting(idx, fatigue, happiness):
    global answer
    for i in range(idx, N):
        if fatigue_list[i] + fatigue < 100:
            greeting(i + 1, fatigue_list[i] + fatigue, happiness + happiness_list[i])
    answer = max(answer, happiness)
    return


N = int(input())
fatigue_list = list(map(int, input().split()))
happiness_list = list(map(int, input().split()))
answer = 0
greeting(0, 0, 0)
print(answer)
