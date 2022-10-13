import sys

sys.stdin = open("E:/algorithm/baekjun/simulation/P20057/input.txt")
input = sys.stdin.readline

dx =[0,1,0,-1]
dy =[-1,0,1,0]

N = int(input())
board = [list(map(int,input().split()))for _ in range(N)]
totDust = 0
for i in range(N):
    totDust+=sum(board[i])
def check_move(i,j,dust):
    if 0<=i<N and 0<=j<N:
        board[i][j]+=int(dust)
    
def move(x,y,direct):
    global outDust
    delx = dx[direct]
    dely = dy[direct]
    nx = x+delx
    ny = y+dely
    dust = board[nx][ny]
    board[nx][ny]=0

    move_dust=dust
    if delx==0:

        check_move(nx-1,ny-dely,0.01*dust)
        check_move(nx-1,ny,0.07*dust)
        check_move(nx-1,ny+dely,0.1*dust)

        check_move(nx-2,ny,0.02*dust)

        check_move(nx+1,ny-dely,0.01*dust)
        check_move(nx+1,ny,0.07*dust)
        check_move(nx+1,ny+dely,0.1*dust)

        check_move(nx+2,ny,0.02*dust)
    else:
        check_move(nx-delx,ny-1,0.01*dust)
        check_move(nx,ny-1,0.07*dust)
        check_move(nx+delx,ny-1,0.1*dust)

        check_move(nx,ny-2,0.02*dust)

        check_move(nx-delx,ny+1,0.01*dust)
        check_move(nx,ny+1,0.07*dust)
        check_move(nx+delx,ny+1,0.1*dust)

        check_move(nx,ny+2,0.02*dust)

    check_move(nx+2*delx,ny+2*dely,0.05*dust)
    dust -= int(0.05*dust)+2*int(0.01*dust)+2*int(0.02*dust)+2*int(0.07*dust)+2*int(0.1*dust)
    check_move(nx+delx,ny+dely,dust)
    return nx,ny


x = N//2
y = N//2
dist = 1
cornerFlag = 0
direct = 0
while 1:
    for d in range(dist):
        x,y = move(x,y,direct)
        if x==0 and y==0: break
        # for i in range(N):
        #     print(board[i])
        # print()
    if x==0 and y==0: break
    direct+=1
    direct%=4
    if cornerFlag:
        dist+=1
        cornerFlag=0
    else:
        cornerFlag=1
remainDust=0
for i in range(N):
    remainDust+=sum(board[i])
print(totDust-remainDust)
