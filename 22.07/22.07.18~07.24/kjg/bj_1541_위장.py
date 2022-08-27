# -가 한번이라도 나오면 그뒤로는 다 마이너스
ti = list(input())
nums = []
a = ''
b = 1
for i in ti:
    if i.isalnum():
        a = a + i
    else:
        if len(a) > 0:
            nums.append(int(a) * b)
        a = ''
        if i == '-' and b == 1:
            b = -1
else:
    nums.append(int(a) * b)
print(sum(nums))