# N = 1일때 : 0~9까지 10개 가능
# N = 2, 3 일 때,
# 1의자리 수가 0일 때, 가능한 두자리수 00 (1) 세자리수 000 (1) // 0일 땐 무조건 경우의 수 1개임
# 1의자리 수가 1일 때, 가능한 두자리수 01, 11 (2) 세자리수 001, 011, 111 (3)
# 1의자리 수가 2일 때, 가능한 두자리수 02, 12, 22 (3) 세자리수 002, 012, 022, 112, 122, 222 (6)
# 1의자리 수가 3일 때, 가능한 두자리수 03, 13, 23, 33 (4) 세자리수 003, 013, 023, 033, 113, 123, 133, 223, 233, 333 (10)
# 자리수가 증가할 때, 현재 끝자리 수의 현재 자리수에서 나올 수 있는 경우의 수는 현재 끝자리 수 이하의 숫자들의 이전 자리수들에서 나올 수 있는 경우의 수의 누적합과 같다.

N = int(input())
# N >= 1임으로 시작값은 1 (1의 자리수인 경우)
DP_arr = [1] * 10
# 1의 자리인 경우제외, N-1번 반복
for i in range(N-1):
    for j in range(1, 10):
        DP_arr[j] += DP_arr[j-1]
print(sum(DP_arr) % 10007)