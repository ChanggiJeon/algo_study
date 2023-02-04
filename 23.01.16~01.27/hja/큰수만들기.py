number = "4177252841"
k = 4

def findMax(number, start, end):
    orderV = start
    maxV = number[start]
    for i in range(start, end):
        if number[i] == "9": ## 안 넣으면 시간초과
            orderV = i
            maxV = number[i]
            return orderV, maxV
        elif number[i] > maxV:
            orderV = i
            maxV = number[i]
    return orderV, maxV


def solution(number, k):
    start = 0
    answer = ''
    for end in range(k+1, len(number)+1):
        orderV, maxV = findMax(number, start, end)
        answer += str(maxV)
        start = orderV+1
    return answer

print(solution(number,k))