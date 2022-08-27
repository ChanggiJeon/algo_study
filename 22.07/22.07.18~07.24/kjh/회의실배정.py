# 입력값 설정
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

# 초기값 설정
# 시작시간 기준 오름차순 정렬
arr.sort()
# 첫번째 회의 일단 시작
end_time = arr[0][1]
cnt = 1

for i in range(1, n):
    # 현재 회의의 시작시간이 end_time 이후이면 새 회의 시작 (+ 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.)
    if arr[i][0] >= end_time:
        cnt += 1
        end_time = arr[i][1]
        continue
    # 현재 회의의 끝나는 시간이 end_time 이전이면 회의 교체(cnt 증가x)
    if arr[i][1] < end_time:
        end_time = arr[i][1]
print(cnt)