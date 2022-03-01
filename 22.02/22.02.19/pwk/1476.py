E, S, M = map(int, input().split())

while E != S:
    if E < S:
        E += 15
    else:
        S += 28

while E != M:
    if E < M:
        E += 420
    else:
        M += 19

print(E)