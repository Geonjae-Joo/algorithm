from heapq import heappush, heappop
import sys

sys.stdin = open("E:/algorithm/baekjun/dijkstra/P10473/input.txt")
input = sys.stdin.readline
INF = sys.maxsize
# 1s, 256mb n<=100 x,y<=500.00
def distance(xa,ya,xb,yb):
    return ((xa-xb)**2+(ya-yb)**2)**0.5
def minTime(xa,ya,xb,yb):
    direct = distance(xa,ya,xb,yb)
    directTime = direct/5
    if(direct>=50):
        canonTime = directTime-8
    else:
        canonTime = 2+(50-direct)/5
    print(min(directTime,canonTime))
    return min(directTime,canonTime)

def mincCanonToTarget():
    # t = dp[0]+minTime(tarx,tary,board[0][0],board[0][1])
    # for i in range(1,N):
    #    t = min(t,dp[i]+minTime(tarx,tary,board[i][0],board[i][1]))
    for i in range(N):
        dp[i]+=minTime(tarx,tary,board[i][0],board[i][1])
    return min(dp)

inix,iniy = map(float,input().split())
tarx,tary = map(float,input().split())


N = int(input())

board = [list(map(float,input().split())) for _ in range(N)]

answer = INF
#1번
for vorNum in range(N):
    # vorNum=0
    dp = [INF for _ in range(N)]
    vst = [0 for _ in range(N)]
    iniCost = distance(inix,iniy,board[vorNum][0],board[vorNum][1])/5
    print(iniCost)
    dp[vorNum]=iniCost
    vst[vorNum]=1
    pq = []
    heappush(pq,(iniCost,vorNum))
    while(pq):
        curCost,curNum = heappop(pq)
        curx = board[curNum][0]
        cury = board[curNum][1]
        for i in range(N):
            if i==vorNum: continue
            nx,ny = board[i]
            nCost = minTime(curx,cury,nx,ny)
            vst[vorNum]=1
            if(vst[i]==0 and nCost<dp[i]):
                # vst[i]=1
                dp[i] = nCost
                heappush(pq,(nCost,i))
    print(dp)
    answer = min(answer,mincCanonToTarget())
    # print(dp)
print(answer)