# 초기값 설정
n = int(input())
arr = list(map(int, input().split()))
ordered_arr = sorted(arr)
num_cnt = {}
i = 0
cnt = 0

# 정렬된 리스트의 인덱스 == (Xi > Xj)를 만족하는 서로 다른 좌표의 개수
# 단, 값이 중복되는 경우를 고려해야함 -> i와 cnt 분리
# 백만에 해당하는 데이터를 반복문으로 계속 돌리면 100% 시간초과임 -> 딕셔너리 사용
while i < n:
    nexti = i + 1
    while nexti < n and ordered_arr[nexti] == ordered_arr[i]:
        nexti += 1
    num_cnt[ordered_arr[i]] = cnt
    i = nexti
    cnt += 1

# 만들어진 딕셔너리에서 arr 반복문 돌면서 나온 값을 키값으로하는 밸류값을 찾아서 한줄로 출력
for i in range(n):
    print(num_cnt[arr[i]], end=" ")