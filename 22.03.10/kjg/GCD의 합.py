N = int(input())

def uclid(a,b):
    while b:
        c = b
        b = a%b
        a = c
    return a


for i in range(N):
    answer = 0
    nums = list(map(int,input().split()))
    for j in range(1,len(nums)-1):
        for k in range(j+1,len(nums)):
            answer += uclid(nums[j],nums[k])
    print(answer)