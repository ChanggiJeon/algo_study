a = int(input())
ti = list(map(int,input().split()))
ti.sort()
cu_ti = 0
sum_ti = 0
for i in ti:
    cu_ti += i
    sum_ti += cu_ti
print(sum_ti)
