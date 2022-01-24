n = int(input())
my_q = []

arr = [input() for _ in range(n)]

for i in range(n):
    a = arr[i]
    if a[0] == 'p':
        # push일때
        if a[1] == 'u':
            # 5번째 숫자부터 마지막 숫자까지 하나의 값으로 append
            tmp = ''
            for j in range(5, len(a)):
                tmp += a[j]
            my_q.append(int(tmp))
        # pop 일때
        elif a[1] == 'o':
            # 큐가 비었으면
            if not my_q:
                print(-1)
            else:
                print(my_q.pop(0))

    elif a[0] == 's':
        print(len(my_q))
    elif a[0] == 'e':
        if my_q:
            print(0)
        else:
            print(1)
    elif a[0] == 'f':
        if not my_q:
            print(-1)
        else:
            print(my_q[0])
    elif a[0] == 'b':
        if not my_q:
            print(-1)
        else:
            print(my_q[-1])