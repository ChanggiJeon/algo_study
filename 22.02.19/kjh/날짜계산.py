e, s, m = map(int, input().split())
stack = [(1, 1, 1)]
year = 1
while True:
    a, b, c = stack.pop()
    if a == e and b == s and c == m:
        break

    year += 1
    if a == 14:
        na = 15
    else:
        na = (a + 1) % 15

    if b == 27:
        nb = 28
    else:
        nb = (b + 1) % 28

    if c == 18:
        nc = 19
    else:
        nc = (c + 1) % 19

    stack.append((na, nb, nc))

print(year)

