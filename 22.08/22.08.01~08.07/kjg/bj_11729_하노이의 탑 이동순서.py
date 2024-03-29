a = int(input())
# 하노이의 탑 이동순서를 설명하자면
# 작은 막대 위에 큰 막대가 올라가면 안된다
# 그렇다면 다음 막대는 어디로 올라가야 하는가?
# 3개의 고리 중 움직임이 없는 고리로 가야한다
# 그럼 그 고리는 어떻게 알 수 있을까?
# 하노이의 탑에 한정될 때 움직일 수 경우의 수는
# 1, 2, 3번고리이다. 이때 1번에서 3번으로 이동했을 때
# 2번 고리가 되는 데 이는 경우의 수가 3가지밖에 없기에 
# 확정지을 수 있는 방식이다.
# 그렇다면 전체 고리의 번호를 다 더한 후에 움직인 고리의 번호들을 빼면 
# 다음 이동할 고리를 알 수 있지 않을까
# 계산해보면 고리번호들의 합은 6이고 하노이의탑인 이상 
# 다른 고리 번호가 늘어날 가능성은 없으니 고정시키도록 한다.
#이제 이를 적용 시켜보자

# x는 현재 막대의 번호이고 
# 시작과 최종 도착지끝은 상황에 따라 바뀐다.
def hanoi(x, start, end):
    # 하지만 x번호가 움직이기 전에 x보다 작은 막대들이 우선적으로 먼저 움직여야한다
    # 따라서 고정값을 선언해 주자
    if x == 1:
        print(start,end)
        return
    # 그리고 초기상태에서 x번이 움직이려고 하면
    # x보다 작은 막대들이 먼저 움직여야하기에
    # 재귀를 통해 작은 막대들을 먼저 옮겨 x번 막대가 
    # 목표 고리에 갈 수 있도록에 자리를 만들어 준다
    hanoi(x - 1, start, 6 - start - end)
    # 그리고 이동가능하게 된다면 x를 목표고리로 이동시킨다.    
    print(start, end)
    # 그리고 이동되었던 나머지 작은 막대들을 이동시킨다.
    hanoi(x - 1, 6 - start - end, end)

# 막대가 1개 일 경우 이동횟수는 1 = 2 ** 1 -1
# 막대가 2개 일 경우 이동횟수는 3 = 2 ** 2 -1
# 막대가 3개 일 경우 이동횟수는 7 = 2 ** 3 -1
# 막대가 4개 일 경우 이동횟수는 15 = 2 ** 4 -1
# 따라서 횟수에 대한 공식은 2**n -1이다
print(2 ** a -1)
hanoi(a, 1, 3)