# 11057
DP는 어찌 풀어도 풀어도 어려운 거 같다.
특히 범위를 설정하는 부분이 말이다.
입력 값이 자릿수를 나타내는 것이라 더 이해하는 데 오래걸린 것 같다.
다행이 입력값이 늘어날 수록 해당 자릿 수의 숫자가 10개 씩 늘어난다고 생각하니 이해가 된 느낌이다.
첫 째 행은 법칙을 적용할 수 없기에 기본 값으로써 입력하고
둘 째 행부터 적용한다.
j와 k의 최소값은 0이고 최대값은 9이다.
현재 자릿수가 N이고 첫째 자리가 j일때 나올수 있는 값을 (N-1)자릿수에 나올 수 있는 j와 같거나 큰k값을 모두 더하는 방식으로 진행한다.