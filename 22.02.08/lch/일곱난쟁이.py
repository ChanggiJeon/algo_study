list = []
for i in range(9):
    list.append(int(input()))
list.sort()
f1, f2 = 0, 0
total = sum(list)
for i in range(8):
    for j in range(i+1, 9):
        if total - (list[i] + list[j]) == 100:
            f1 = i
            f2 = j
list.pop(f2)
list.pop(f1)
for i in range(7):
    print(list[i])
