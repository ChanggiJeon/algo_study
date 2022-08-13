n = int(input())
rank = []
for i in range(n):
    car_name = input()
    rank.append(car_name)
cnt = 0
for j in range(n):
    goal_car = input()
    if rank[j] != goal_car:
        cnt += 1
        target = rank.pop(rank.index(goal_car))
        rank.insert(j,target)

print(cnt)

