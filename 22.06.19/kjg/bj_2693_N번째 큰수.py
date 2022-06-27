a = int(input())
nums = [sorted(list(map(int, input().split()))) for _ in range(a)]
for i in range(a):
    print(nums[i][-3])
