preoder = []

def postorder(array):
    if len(array) == 0:
        return []
    max_idx = len(array)
    
    for i in range(1,len(array)):
        if array[i] > array[0]:
            max_idx = i
            break
    return postorder(array[1:max_idx]) + postorder(array[max_idx:]) + [array[0]]




while True:
    try:
        a = input()
    except EOFError:
        break
    preoder.append(int(a))
print(preoder)
ans = postorder(preoder)
for i in ans:
    print(i)

    
