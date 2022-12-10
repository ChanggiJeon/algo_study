def perfect(i, st):
    a = 0
    b = 0
    if len(st) == n:
        for s in st:

            if s in mo:
                a += 1
            else:
                b += 1
        if a > 0 and b > 1:
            print(st)

        return
    for i in range(i, m):
        if arr[i] in mo:
            a = 1
        else:
            b = 1
        perfect(i + 1, st + arr[i])

mo = ["a","e","i","o","u"]

n,m = map(int,input().split())
arr = sorted(list(input().split()))
perfect(0, "")

