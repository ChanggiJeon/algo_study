a = input()
ans = ''

for i in range(len(a)):
    if a[i] == ' ':
        ans += ' '
    elif 65 <= ord(a[i]) <= 77:
        ans += chr(ord(a[i]) + 13)
    elif 78 <= ord(a[i]) <= 90:
        ans += chr(ord(a[i]) - 13)
    elif 97 <= ord(a[i]) <= 109:
        ans += chr(ord(a[i]) + 13)
    elif 110 <= ord(a[i]) <= 122:
        ans += chr(ord(a[i]) - 13)
    else:
        ans += a[i]
print(ans)