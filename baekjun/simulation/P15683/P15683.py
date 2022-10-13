from copy import deepcopy
import sys

sys.stdin = open("E:/algorithm/baekjun/simulation/P15683/input.txt")
input = sys.stdin.readline
N,M = map(int,input().split())
board = [[0]*M for _ in range(N)]
cameras = []
for i in range(N):
    for j,n in enumerate(list(map(int,input().split()))):
        if n==0: continue
        board[i][j] = n
        if n==6: continue
        cameras.append([i,j,n])
# vst = [0 for _ in range(len(cameras))]
# for i in range(N):
#     print(board[i])
# print(cameras)
# print(vst)
def draw(b,x,y,up,left,down,right):
    tmp_b = deepcopy(b)
    if up:
        tmp_x = x
        while tmp_x>0:
            tmp_x-=1
            if tmp_b[tmp_x][y]==6: break
            if tmp_b[tmp_x][y] ==0: tmp_b[tmp_x][y]='#'
    if down:
        tmp_x = x
        while tmp_x<N-1:
            tmp_x+=1
            if tmp_b[tmp_x][y]==6: break
            if tmp_b[tmp_x][y] ==0: tmp_b[tmp_x][y]='#'

    if left:
        tmp_y = y
        while tmp_y>0:
            tmp_y-=1
            if tmp_b[x][tmp_y]==6: break
            if tmp_b[x][tmp_y] ==0: tmp_b[x][tmp_y]='#'


    if right:
        tmp_y = y
        while tmp_y<M-1:
            tmp_y+=1
            if tmp_b[x][tmp_y]==6: break
            if tmp_b[x][tmp_y] ==0: tmp_b[x][tmp_y]='#'

    return tmp_b


def dfs(b,cameraNum):
    global answer
    if cameraNum==len(cameras):
        count=0
        for i in range(len(b)):
            for j in range(len(b[0])):
                if b[i][j]==0: count+=1
        answer= min(answer,count)
        
    else:
        x,y,type = cameras[cameraNum]
        # vst[cameraNum]=1
        if type==1:
            dfs(draw(b,x,y,1,0,0,0),cameraNum+1)
            dfs(draw(b,x,y,0,1,0,0),cameraNum+1)
            dfs(draw(b,x,y,0,0,1,0),cameraNum+1)
            dfs(draw(b,x,y,0,0,0,1),cameraNum+1)
        elif type==2:
            dfs(draw(b,x,y,1,0,1,0),cameraNum+1)
            dfs(draw(b,x,y,0,1,0,1),cameraNum+1)
        elif type==3:
            dfs(draw(b,x,y,1,1,0,0),cameraNum+1)
            dfs(draw(b,x,y,0,1,1,0),cameraNum+1)
            dfs(draw(b,x,y,0,0,1,1),cameraNum+1)
            dfs(draw(b,x,y,1,0,0,1),cameraNum+1)
        elif type==4:
            dfs(draw(b,x,y,1,1,1,0),cameraNum+1)
            dfs(draw(b,x,y,1,1,0,1),cameraNum+1)
            dfs(draw(b,x,y,1,0,1,1),cameraNum+1)
            dfs(draw(b,x,y,0,1,1,1),cameraNum+1)
        else:
            dfs(draw(b,x,y,1,1,1,1),cameraNum+1)




        
answer=sys.maxsize
dfs(board,0)
print(answer)