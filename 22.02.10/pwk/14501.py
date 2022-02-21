from audioop import maxpp


def solve(check_lst):
    global max_price
    if len(check_lst) == N:
        price = 0
        for i in range(N):
            if check_lst[i]:
                price += lst[i][1]
        if price > max_price:
            max_price = price
        return
    
    check_lst.append(0)
    solve(check_lst)
    check_lst.pop()
    
    day = len(check_lst)
    if len(check_lst) + lst[day][0] <= N:
        check_lst.append(1)
        for _ in range(lst[day][0]-1):
            check_lst.append(0)
        solve(check_lst)
        for _ in range(lst[day][0]):
            check_lst.pop()
    
    
N = int(input())
lst = [list(map(int, input().split())) for _ in range(N)]
max_price = 0
solve([])
print(max_price)