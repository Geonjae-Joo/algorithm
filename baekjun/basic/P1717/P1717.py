import sys
sys.setrecursionlimit(10**6)
sys.stdin = open("E:/algorithm/baekjun/basic/P1717/input.txt")
N,M = map(int,sys.stdin.readline().split())
par = [i for i in range(N+1)]

def find(a):
    par_a = par[a]
    if par_a!=a:
        par[a] = find(par_a)
        return par[a]
    else:
        return a

def union(a,b):
    par_a = find(a)
    par_b = find(b)
    if par_a!=par_b:
        par[par_a] = par_b

for _ in range(M):
    t,i,j = map(int,sys.stdin.readline().split())
    if t==0:
        union(i,j)
    else:
        par_a = find(i)
        par_b = find(j)
        if par_a == par_b:
            sys.stdout.write("YES"+"\n")
        else:
            sys.stdout.write("NO"+"\n")
