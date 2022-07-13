n, m = map(int, input().split())
arr_n = set()
arr_m = set()
for _ in range(n + m):
    arr_n.add(input())
for _ in range(m):
    arr_m.add(input())
arr_nm = sorted(list(arr_n & arr_m))
arr_nm_len = len(arr_nm)
print(arr_nm_len)
for i in range(arr_nm_len):
    print(arr_nm[i])