cards = int(input())
mine = list(map(int, input().split()))
checks = int(input())
nums = list(map(int, input().split()))

mine.sort()
def binary(array, target, start,end):
    while start <= end:
        mid = (start + end) // 2
        
        if array[mid] == target:
            # 2차 도전 index가 시간초과 원인으로 보임
            return mid
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid +1
    return None
# print(mine)
for i in nums:
    if binary(mine, i , 0, cards - 1) is not None:
        print(1, end = " ")
    else:
        print(0, end = " ")