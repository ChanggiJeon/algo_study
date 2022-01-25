def pick(lst):
    # 6개를 완성하면 출력
    if len(lst) == 7:
        print(*lst[1:])
        return
    
    for i in range(len(case)):
        if i == 0: continue
        if case[i] > lst[-1]:
            lst.append(case[i])
            pick(lst)
            lst.pop()
    

while True:
    case = input()
    if case == '0':
        break
    case = list(map(int, case.split()))
    pick([0])
    print()
    