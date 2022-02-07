N = int(input())
M = [0]*10000
D= [0] * 10000
for i in range(N):
    M[i]=int(input())
D[0] = M[0]
D[1] = M[0]+M[1]
D[2] = max(M[2]+M[0],M[2]+M[1],D[1])

for i in range(3,N):
    D[i] = max(D[i-1],D[i-2]+M[i],D[i-3]+M[i-1]+M[i])
print(max(D))