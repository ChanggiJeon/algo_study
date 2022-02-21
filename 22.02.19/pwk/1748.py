N = int(input())

result = 0
if N < 10:
    result = N
elif N < 100:
    result += 9
    result += 2 * (N-9)
elif N < 1000:
    result += 9
    result += 2 * 90
    result += 3 * (N-99)
elif N < 10000:
    result += 9
    result += 2 * 90
    result += 3 * 900
    result += 4 * (N-999)
elif N < 100000:
    result += 9
    result += 2 * 90
    result += 3 * 900
    result += 4 * 9000
    result += 5 * (N-9999)
elif N < 1000000:
    result += 9
    result += 2 * 90
    result += 3 * 900
    result += 4 * 9000
    result += 5 * 90000
    result += 6 * (N-99999)
elif N < 10000000:
    result += 9
    result += 2 * 90
    result += 3 * 900
    result += 4 * 9000
    result += 5 * 90000
    result += 6 * 900000
    result += 7 * (N-999999)
elif N < 100000000:
    result += 9
    result += 2 * 90
    result += 3 * 900
    result += 4 * 9000
    result += 5 * 90000
    result += 6 * 900000
    result += 7 * 9000000
    result += 8 * (N-9999999)
else:
    result += 9
    result += 2 * 90
    result += 3 * 900
    result += 4 * 9000
    result += 5 * 90000
    result += 6 * 900000
    result += 7 * 9000000
    result += 8 * 90000000
    result += 9
print(result)