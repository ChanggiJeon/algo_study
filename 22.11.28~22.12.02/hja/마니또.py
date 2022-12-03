import sys
sys.setrecursionlimit(10**6)

def checkManito(graph, v, visited):
    global result
    global res
    if visited[v] == True:
        res += 1
        return
    else:
        visited[v] = True
        result += 1
        if not visited[graph[v][1]]:
            checkManito(graph,graph[v][1],visited)


tc = 1
while True:
    n = int(input())
    peopleList = []
    if n == 0:
        break
    else:
        for i in range(n):
            a, b = input().split()
            peopleList.append([a,b])

        for i in range(n):
            for j in range(n):
                if peopleList[i][0] == peopleList[j][1]:
                    peopleList[i][0] = i
                    peopleList[j][1] = i


    result = 0
    res = 0
    visited = [False]*n
    for i in range(n):
        checkManito(peopleList,i,visited)


    print(tc, result - res)
    tc += 1


