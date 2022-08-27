# 선택 정렬(O(n^2))
def selection_sort(length, number_list):
    for i in range(length):
        min_idx = i
        for j in range(i + 1, length):
            if number_list[j] < number_list[min_idx]:
                min_idx = j
        number_list[i], number_list[min_idx] = number_list[min_idx], number_list[i]
    return number_list


# 입력값
n = int(input())
arr = list(map(int, input().split()))

sorted_arr = selection_sort(n, arr)

ans = 0
stack = 0
for i in range(n):
    num_now = sorted_arr[i]
    stack += num_now
    ans += stack
print(ans)