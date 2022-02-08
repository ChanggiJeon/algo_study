arr = list(int(input()) for _ in range(9))
ans = []

for i in range(9):
    for j in range(i+1, 9):
        if sum(arr) - (arr[i] + arr[j]) == 100:
            ans = [arr[i], arr[j]]

arr.remove(ans[0])
arr.remove(ans[1])
arr.sort()
for i in range(7):
    print(arr[i])