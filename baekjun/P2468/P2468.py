from collections import deque
import sys 
sys.stdin = open("E:/algorithm/baekjun/P2468/input.txt","r")
N = int(input())
dx = [-1,0,0,1]
dy = [0,1,-1,0]

m = [list(map(int,input().split()))for i in range(N)]

def bfs(i,j):
    q = deque()
    q.appendleft((i,j))
    while(q):
        x,y = q.pop()
        vst[x][y]=1
        for k in range(4):
            new_x = x+dx[k]
            new_y = y+dy[k]
            if(0<=new_x<N and 0<=new_y<N and vst[new_x][new_y]==0):
                q.appendleft((new_x,new_y))
# print(m)
# print(max_level)
max_landCount=0
for level in range(1,101):
    vst=[[0]*N for i in range(N)]
    landCount = 0
    for i in range(N):
        for j in range(N):
            if m[i][j] <=level:
                vst[i][j] = 1
    # print(vst)
    for i in range(N):
        for j in range(N):
            if(vst[i][j]==1):continue
            # print(i,j)
            bfs(i,j)
            landCount+=1
            # print(vst)
    # print(landCount)
    if landCount> max_landCount: max_landCount = landCount
print(max_landCount)    

# print(vst)