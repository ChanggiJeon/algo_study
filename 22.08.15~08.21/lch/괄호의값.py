base = list(input())
stack = []
ss = 0
dd = 0

# + 숫자
# 시작이 ) 라면????
# ([]]]][[[[]) 라면?

# 짝이 안맞으면 불가능

def check(l1):
    a = 0
    b = 0
    c = 0
    d = 0
    for j in range(len(l1)):
        if l1[j] == '(':
            a += 1
        elif l1[j] == ')':
            b += 1
        elif l1[j] == '[':
            c += 1
        elif l1[j] == ']':
            d += 1
    if a != b or c != d : return 0

    if l1[0] == ')' or l1[0] == ']' or l1[-1] == '(' or l1[-1] == '[' : return 0

    return 1

if check(base) == 0:
    print(0)
else:
    stack.append(base[0])
    for i in range(1, len(base)):
        if base[i-1] == '(':
            if base[i] == ')':
                stack.pop()
                stack.append(int(2))
            elif base[i] == ']':
                print(0)
                break
            else:
                stack.append(base[i])

        elif base[i-1] == '[':
            if base[i] == ']':
                stack.pop()
                stack.append(int(3))
            elif base[i] == ')':
                print(0)
                break
            else:
                stack.append(base[i])
        else:
            stack.append(base[i])

        if stack[-1] ==']':
            if stack[-2] == '(':
                print(0)
                break
            if type(stack[-2]) == int:
                if stack[-3] == '(':
                    print(0)
                    break
                if stack[-3] == '[':
                    stack.pop()
                    ss = stack.pop()
                    stack.pop()
                    stack.append(ss*3)

        elif stack[-1] ==')':
            if stack[-2] == '[':
                print(0)
                break
            if type(stack[-2]) == int:
                if stack[-3] == '[':
                    print(0)
                    break
                if stack[-3] == '(':
                    stack.pop()
                    ss = stack.pop()
                    stack.pop()
                    stack.append(ss*2)

        if type(stack[-1]) == int:
            if len(stack) == 1: continue
            if type(stack[-2]) == int:
                ss = stack.pop()
                dd = stack.pop()
                stack.append(ss + dd)

    print(*stack)