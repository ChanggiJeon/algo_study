l, r = input().split()
if len(l) == len(r):
    cnt = 0
    while True:
        for i in range(len(l)):
            if l[i] != r[i]:
                break
            else:
                if l[i] == '8':
                    cnt += 1
        break
    print(cnt)
else:
    print(0)

