1. 가장 큰 증가 부분 수열

```
백트래킹을 이용해서 모든 경우의 수를 다 찾아내면 되기는 하나 매우 비효율적임
DP 접근으로 효율적으로 푸는 방법
 - 원본 배열에서 현재 위치 이전 인자들 중 현재 위치보다 더 작은 값을 갖는 모든 인자들에 대해
   (증가 부분 수열 검사)
 - 누적합의 값이 최대가 되는 값으로 갱신한다.
 - 갱신된 전체 최대값 리스트에서 가장 큰 값을 출력
deepcopy : from copy import deepcopy
```

2. M과 N

```
가장 기본적인 백트래킹 문제였다.
```
3. 숨바꼭질
```
queue와 deque(Double Ended Queue)의 차이
queue의 단점 : 공간효율성
 - enqueue와 dequeue의 횟수가 커지면서 queue에 점점 많은 데이터가 쌓이게 되고 queue가 무거워지면 앞에 데이터를 dequeue했을 때 뒤에 있는 모든 데이터를 한칸씩 땡겨야함으로 비효율적임
 - deque는 양쪽에서 입출력이 가능하도록 설계가 되어있기 때문에 위 문제에 걸리지 않음
deque : from collections import deque
```

