lst = [1,1]

while len(lst) != 90:
    lst.append(sum(lst[:-1])+1)

print(lst[(int(input()))-1])