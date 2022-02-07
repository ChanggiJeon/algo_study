pw = input()
answer = ""
for i in pw:
    if i.isalpha():
        if ord(i) >= ord('a'):
            i = chr(((ord(i) - ord('a') + 13) % 26) + ord('a'))
        else:
            i = chr(((ord(i) - ord('A') + 13) % 26) + ord('A'))
    answer += i
print(answer)