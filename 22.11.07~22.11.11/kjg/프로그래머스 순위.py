def solution(n, results):
    count = 0
    win, los = {}, {}

    for i in range(1, n + 1):
        win[i], los[i] = set(), set()
    for i in range(1, n + 1):
        for re in results:
            if re[0] == i:
                win[i].add(re[1])
            if re[1] == i:
                los[i].add(re[0])
        for wi in los[i]:
            win[wi].update(win[i])
        for lo in win[i]:
            los[lo].update(los[i])
    print(win, los)
    for i in range(1, n + 1):
        if len(win[i]) + len(los[i]) == n - 1:
            count += 1

    return count