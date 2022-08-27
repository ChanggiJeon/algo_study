import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
a = int(input())
graph = [[] for _ in range(a + 1)]
visit = [0] * (a + 1)
for i in range(a):
    o, n, m = input().split()
    if n != '.':
        graph[ord(o) - 64].append(ord(n) - 64)
    else:
        graph[ord(o) - 64].append(0)
    if m != '.':
        graph[ord(o) - 64].append(ord(m) - 64)
    else:
        graph[ord(o) - 64].append(0)
def pre(x):
    if x == 0:
        return
    print(chr(x + 64), end="")
    for i in graph[x]:
        pre(i)
pre(1)
print()
def ino(x):
    if x == 0:
        return
    ino(graph[x][0])
    print(chr(x + 64), end="")
    ino(graph[x][1])
ino(1)
print()
def past(x):
    if x == 0:
        return
    past(graph[x][0])
    past(graph[x][1])
    print(chr(x + 64), end="")

past(1)
print()