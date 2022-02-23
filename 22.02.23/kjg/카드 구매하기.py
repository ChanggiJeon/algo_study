# 어찌 dp는 할 때 마다 어렵지?

num = int(input())
price = list(map(int,input().split()))
max_price = [0]* (num+1)
max_price[1] = price[0]
answer = 0
for x in range(2,num+1):
    for a in range(1,x+1):
        if max_price[x] < max_price[x-a] + price[a-1]:
            max_price[x] = max_price[x-a] + price[a-1]
print(max_price[-1])
