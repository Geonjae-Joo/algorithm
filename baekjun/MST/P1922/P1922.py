import sys
sys.stdin = open("E:/algorithm/baekjun/MST/P1922/input.txt")
input = sys.stdin.readline
N = int(input())
M = int(input())
par = [i for i in range(N+1)]
def find(a):
    par_a = par[a]
    if par_a != a:
        par[a] = find(par_a)
        return par[a]
    else:
        return a

def union(a,b):
    a = find(a)
    b = find(b)
    if a!=b:
        par[a] =b
arr = []
for _ in range(M):
    a,b,c = map(int,input().split())
    arr.append((c,a,b))
arr = sorted(arr)

n = 0
tot = 0
for i in range(M):
    cost,a,b = arr[i]
    par_a = find(a)
    par_b = find(b)
    if par_a!=par_b:
        union(a,b)
        tot+=cost
        n+=1
    
sys.stdout.write(str(tot))
