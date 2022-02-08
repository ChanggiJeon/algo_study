# 오랜 만에 하니 데이터 저장방식이 헤깔렸다.

a = [int(input()) for _ in range(9)]
total = sum(a)
for i in range(9):
    for j in range(i+1,9):
        if total-(a[i]+a[j]) == 100:
            num1,num2 = a[i],a[j]
            a.remove(num1)
            a.remove(num2)
            a.sort()
            for s in a:
                print(s)
            break
    if len(a) < 9:
        break


