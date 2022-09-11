from collections import deque
import sys
sys.stdin = open("E:/algorithm/baekjun/P16234/input.txt","r")
n,l,r = map(int,input().split())
dx = [-1,0,0,1]
dy = [0,-1,1,0]
board = [list(map(int,input().split())) for _ in range(n)]

def bfs(i,j):
    tmp =[]
    # tot = 0
    q = deque()
    q.append((i,j))
    tmp.append((i,j))
    # tot+=board[i][j]
    while(q):
        x,y = q.popleft()
        for i in range(4):
            new_x = x+dx[i]
            new_y = y+dy[i]
            if(0<=new_x<n and 0<=new_y<n and vst[new_x][new_y]==0):
                if  l<=abs(board[x][y]-board[new_x][new_y])<=r:
                    q.append((new_x,new_y))
                    vst[new_x][new_y]=1
                    tmp.append((new_x,new_y))
                    # tot+=board[new_x][new_y]
    return tmp
    # if(len(tmp)<=1): return False
    # else:
    #     val = tot//len(tmp)
    #     for tx,ty in tmp:
    #         board[tx][ty]=val
    #     return True
    


count = 0
while(True):
    flag=False
    vst = [[0]*(n+1) for _ in range(n+1)]

    for i in range(n):
        for j in range(n):
            if vst[i][j] ==1: continue
            vst[i][j] =1
            # if(bfs(i,j)): flag=True
            country = bfs(i,j)
            if len(country)>1:
                flag = True

                val = sum(board[x][y] for x,y in country)//len(country)
                for x,y in country:
                    board[x][y] = val
                

    if(flag): count+=1
    else: break
print(count)

