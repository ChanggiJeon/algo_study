lst = sorted([int(input()) for _ in range(9)])
checks = [False] * 9

def solve(idx, result):
    if len(result) == 7:
        if sum(result) == 100:
            for i in range(7):
                print(result[i])
            exit()
        return
    
    for i in range(idx, 9):
        result.append(lst[i])
        solve(i+1, result)
        result.pop()
    
solve(0, [])
