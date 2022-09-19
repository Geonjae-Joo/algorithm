import sys
sys.stdin = open("E:/algorithm/baekjun/MST/P16202/input.txt","r")
def find(a):
    global par
    par_a = par[a]
    if par_a!=a:
        par[a] = find(par_a)
        return par[a]
    else:
        return a
def union(a,b):
    par_a = find(a)
    par_b = find(b)
    if par_a != par_b:
        par[par_a] = par_b

def mst(arr):
    global par
    count = 0
    tot = 0
    par = [i for i in range(N+1)]
    for edge in arr:
        if count == N-1:
            break
        i = edge[0]
        j = edge[1]
        cost= edge[2]
        par_i = find(i)
        par_j = find(j)
        if par_i != par_j:
            union(i,j)
            count+=1
            tot +=cost
    if count==N-1:
        return tot
    else:
        return 0
        


N,M,K = map(int,sys.stdin.readline().split())
# print(N)
board = []
par=[]
for i in range(M):
    tmp = list(map(int,sys.stdin.readline().split()))
    tmp.append(i+1)
    board.append(tmp)

flag = 1
for k in range(K):
    if flag==1:
        result = mst(board[k:])
        if result ==0:
            flag=0
            sys.stdout.write("0"+" ")
        else:
            sys.stdout.write(str(result)+" ")
    else:
        sys.stdout.write("0"+" ")






