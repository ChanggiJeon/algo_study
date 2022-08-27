N = int(input())
in_car = [input() for _ in range(N)]
out_car = [input() for _ in range(N)]
cnt = 0
roop = 1

while roop == 1:
    for i in range(len(in_car)):
        if out_car[i] != in_car[i]:
            in_car.remove(out_car[i])
            out_car.pop(0)
            cnt += 1
            break
    else: roop = 0

print(cnt)

#value error 발생