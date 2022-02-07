S = input()
lst = [S[i:] for i in range(len(S))]
for word in sorted(lst):
    print(word)
