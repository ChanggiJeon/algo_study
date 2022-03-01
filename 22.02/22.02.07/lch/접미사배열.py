s = input()
index = []
for i in range(len(s)):
    index.append(s[i:])
index.sort()
for j in range(len(s)):
    print(index[j])
