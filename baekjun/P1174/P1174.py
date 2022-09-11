from itertools import combinations
import math
import sys

sys.stdin = open("E:/algorithm/baekjun/P1174/input.txt","r")

N  = int(input())
level=1
tot = 0
resi = 0
for i in range(1,11):
    tot+=math.comb(10,i)
    if N<=tot:
        resi = N-tot+math.comb(10,i)
        break
    else:
        level+=1
if(level==11):
    print(-1)
else:
    c = combinations(r=level,iterable=[9,8,7,6,5,4,3,2,1,0])
    c = sorted(list(c))
    ans=0
    for n in c[resi-1]:
        ans+=n*10**(level-1)
        level-=1
    print(ans)
