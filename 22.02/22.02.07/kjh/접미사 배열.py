S = input()
L = len(S)
ans = []

# 접미사 잘라서 ans에 넣기
for i in range(L):
    ans.append(S[i:L])
# 오름차순 정렬
ans.sort()
# 프린트
for i in range(L):
    print(ans[i])