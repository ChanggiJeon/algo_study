a = int(input())
array = list(map(int,input().split()))
A = 0
def s(ans):
    global A
    if len(array) == 2:
        if ans > A:
            A = ans
        return
    
    for i in range(1, len(array) - 1):
        V = array[i - 1] * array[i + 1]
        b = array.pop(i)
        s(ans + V)
        array.insert(i, b)
s(0)
print(A)
    


    