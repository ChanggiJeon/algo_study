N, K = map(int,input().split())
arr = [list(input()) for _ in range(N)]
# print(ord('z')) # a == 97 z == 122
# print(chr(97))
ans = 0
def combination(y, idx):
    global cnt
    if cnt == len(y):
        brute(y)
        return
    for i in range(idx,26):
        if chr(i + 97) in arr_str:
            continue
        tar = chr(i + 97)
        if tar not in y:
            combination(y+[tar], i + 1)
    
def brute(list):
    global ans
    cnt = 0
    c = arr_str + list
    for i in range(len(arr)):
        # print(''.join(arr[i][:4]))
        # print( ''.join(arr[i][-4:]))
        if ''.join(arr[i][:4]) == 'anta' and ''.join(arr[i][-4:]) == 'tica':
            d = set(arr[i][4:-4])
            # print(len(d))
            for j in d:
                if j not in c:
                    break
            else:
                cnt += 1
    else:
        if ans < cnt:
            ans = cnt
        
if K >= 5:
    cnt = K - 5
    arr_str = ['a','c','i','n','t']
    combination([],0)
    print(ans)
else:
    print(0)


