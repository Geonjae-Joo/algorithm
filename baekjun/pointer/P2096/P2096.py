import sys
sys.stdin = open("E:/algorithm/baekjun/pointer/P2096/input.txt")
input = sys.stdin.readline

N = int(input())
maxdp = [[0]*3 for i in range(2)]
mindp = [[0]*3 for i in range(2)]

a,b,c = map(int,input().split())
maxdp[0] = [a,b,c]
mindp[0] = [a,b,c]
for y in range(1,N):
    a,b,c = map(int,input().split())

    maxdp[1][0] = max(maxdp[0][0],maxdp[0][1])+a
    maxdp[1][1] = max(maxdp[0][0],maxdp[0][1],maxdp[0][2])+b
    maxdp[1][2] = max(maxdp[0][1],maxdp[0][2])+c
   
    mindp[1][0] = min(mindp[0][0],mindp[0][1])+a
    mindp[1][1] = min(mindp[0][0],mindp[0][1],mindp[0][2])+b
    mindp[1][2] = min(mindp[0][1],mindp[0][2])+c
    for i in range(3):
        maxdp[0][i]=maxdp[1][i] 
        mindp[0][i] = mindp[1][i]

sys.stdout.write(str(max(maxdp[0]))+" "+str(min(mindp[0])))