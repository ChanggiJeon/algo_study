from collections import deque

n = int(input())
arr = [input() for _ in range(n)]
my_deque = deque()

# 큐 만든거 가져와서 front/back 수정
for i in range(n):
    a = arr[i]
    if a[0] == 'p':
        # push일때
        if a[1] == 'u':
            # push_front일때
            if a[5] == 'f':
                # 11번째 숫자부터 마지막 숫자까지 하나의 값으로 appendleft
                tmp = ''
                for j in range(11, len(a)):
                    tmp += a[j]
                my_deque.appendleft(int(tmp))
            # push_back일때
            if a[5] == 'b':
                # 10번째 숫자부터 마지막 숫자까지 하나의 값으로 append
                tmp = ''
                for j in range(10, len(a)):
                    tmp += a[j]
                my_deque.append(int(tmp))

        # pop 일때
        elif a[1] == 'o':
            # 큐가 비었으면
            if not my_deque:
                print(-1)
            # pop_front일때
            elif a[4] == 'f':
                print(my_deque.popleft())
            # pop_back일때
            elif a[4] == 'b':
                print(my_deque.pop())

    elif a[0] == 's':
        print(len(my_deque))
    elif a[0] == 'e':
        if my_deque:
            print(0)
        else:
            print(1)
    elif a[0] == 'f':
        if not my_deque:
            print(-1)
        else:
            print(my_deque[0])
    elif a[0] == 'b':
        if not my_deque:
            print(-1)
        else:
            print(my_deque[-1])