import string

lower_lst = string.ascii_lowercase
upper_lst = string.ascii_uppercase

for char in input():
    if char in lower_lst:
        print(lower_lst[(lower_lst.index(char)+13)%26], end='')
    elif char in upper_lst:
        print(upper_lst[(upper_lst.index(char)+13)%26], end='')
    else:
        print(char, end='')