import copy

def solve_min(arr, c_list):
    global ans_min
    if ans_min:
        return

    if len(arr) == a + 1:
        ans_min = copy.deepcopy(arr)
        return

    for i in range(10):
        if c_list[i] == 1: continue

        idx = len(arr) - 1
        if arr_signs[idx] == '<':
            if arr[idx] > i: continue
        else:
            if arr[idx] < i: continue

        arr.append(i)
        c_list[i] = 1
        solve_min(arr, c_list)
        arr.pop()
        c_list[i] = 0


def solve_max(arr, c_list):
    global ans_max
    if ans_max:
        return

    if len(arr) == a + 1:
        ans_max = copy.deepcopy(arr)
        return

    for i in range(9, -1, -1):
        if c_list[i] == 1: continue

        idx = len(arr) - 1
        if arr_signs[idx] == '<':
            if arr[idx] > i: continue
        else:
            if arr[idx] < i: continue

        arr.append(i)
        c_list[i] = 1
        solve_max(arr, c_list)
        arr.pop()
        c_list[i] = 0


a = int(input())
arr_signs = list(input().split())
check_list = [0] * 10
ans_max = []
ans_min = []
arr_ans = []

for i in range(10):
    arr_ans.append(i)
    check_list[i] = 1
    solve_min(arr_ans, check_list)
    check_list[i] = 0
    arr_ans.pop()
    if ans_min:
        break
for i in range(9, -1, -1):
    arr_ans.append(i)
    check_list[i] = 1
    solve_max(arr_ans, check_list)
    check_list[i] = 0
    arr_ans.pop()
    if ans_max:
        break
print(''.join(str(_) for _ in ans_max))
print(''.join(str(_) for _ in ans_min))



