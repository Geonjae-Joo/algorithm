from copy import deepcopy
import sys
sys.stdin = open("E:/algorithm/baekjun/P17143/input.txt")
input = sys.stdin.readline

R,C,M = map(int,input().split())
board = [[0]*(C+1) for _ in range(R+1)]
for _ in range(M):
    r,x,s,d,z = map(int,input().split())

    board[r][x] = [s,d,z]
def move():
    global board
    new_board = [[0]*(C+1) for _ in range(R+1)]

    for i in range(1,R+1):
        for j in range(1,C+1):
            if board[i][j]==0: continue
            speed,d,z = board[i][j]
            if d==1 or d==2:
                gridSize = R
                pos = i
                direct= -1 if d==1 else 1
            else:
                gridSize = C
                pos = j
                direct= -1 if d==4 else 1
            #initialize
            if direct==1:
                speed+=pos-1
            else:
                speed+=gridSize-1+gridSize-pos
            direct=1
            speed%=(2*gridSize-2)
            if speed>=gridSize:
                direct*=-1
                speed%=(gridSize-1)
                pos = gridSize-speed
            else:
                pos = speed+1
            if d==1 or d==2:
                x = pos
                y = j
            else:
                y = pos
                x =i
            if new_board[x][y]!=0 and new_board[x][y][2]>=z: continue
            new_board[x][y] = [board[i][j][0],direct,z]
    board=deepcopy(new_board)
answer=0
# for man in range(1,C+1):
#     #man collect
#     for row in range(1,R+1):
#         if board[row][man] !=0:
#             _,_,z  = board[row][man]
#             print(z)
#             answer+=z
#             board[row][man]=0
move()
move()
for i in range(1,R+1):
    print(board[i])
print(answer)
