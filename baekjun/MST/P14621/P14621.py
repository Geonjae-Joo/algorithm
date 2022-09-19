import sys
sys.stdin = open("E:/algorithm/baekjun/MST/P14621/input.txt")
input = sys.stdin.readline

def find(a):
    if par[a]!=a:
        par[a] = find(par[a])
        return par[a]
    else:
        return a

def union(a,b):
    par_a = find(a)
    par_b = find(b)
    if par_a!=par_b:
        par[par_a]=par_b



N,M = map(int, input().split())
sex= [0]+list(input().split())
par = [i for i in range(N+1)]
adj = []
for _ in range(M):
    a,b,c = map(int,input().split())
    if sex[a]==sex[b]: continue
    adj.append((c,a,b))
adj = sorted(adj)

n=0
tot=0
for i in range(len(adj)):
    if n==N-1: break
    c,a,b = adj[i]
    par_a = find(a)
    par_b = find(b)
    if par_a!=par_b:
        union(a,b)
        n+=1
        tot+=c
if n==N-1:

    sys.stdout.write(str(tot))
else:
    sys.stdout.write("-1")
    


