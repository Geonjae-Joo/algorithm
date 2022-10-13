from collections import deque
import sys

sys.stdin = open("E:/algorithm/baekjun/P2636/input.txt")
input = sys.stdin.readline
mx,my = map(int,input().split())
board = [list(map(int,input().split())) for _ in range(mx)]
# for i in range(mx):
#     print(board[i])
dx = [-1,0,0,1]
dy = [0,1,-1,0]

def bfs(i,j): # cheese melt
    q = deque()
    q.append([i,j])
    vst[i][j]=1
    while(q):
        i,j = q.popleft()
        for m in range(4):
            x = i+dx[m]
            y = j+dy[m]
            if x<0 or x>=mx or y<0 or y>=my: continue
            if vst[x][y]==1: continue
            vst[x][y]=1
            if board[x][y]==0:
                q.append([x,y])
            else:
                board[x][y]=0
# def dfs(i,j): # count island
#     vst[i][j]=1
#     for m in range(4):
#         x = i+dx[m]
#         y = j+dy[m]
#         if x<0 or x>=mx or y<0 or y>=my: continue
#         if vst[x][y]==1 or pre_board[x][y]==0: continue
#         pre_board[x][y]=0
#         dfs(x,y)

time=0
# pre_board = copy.deepcopy(board)
while 1:
    s = 0
    for i in range(mx):
        s+=sum(board[i])
    if s==0: break
    pre_s = s
    # pre_board = copy.deepcopy(board)
    vst = [[0]*my for _ in range(mx)]
    bfs(0,0)
    time+=1


# for i in range(mx):
#     for j in range(my):
#         if pre_board[i][j]== 0: continue
#         dfs(i,j)
#         count+=1
sys.stdout.write(str(time)+"\n"+str(pre_s))

