import sys

sys.stdin = open("E:/algorithm/baekjun/BFS/P13460/input.txt")
input = sys.stdin.readline
N,M = map(int,input().split())
board = [list(str(input()).strip()) for _ in range(N)]
ir=[]
ib=[]
hole = []
for i in range(len(board)):
    for j in range(len(board[0])):
        if board[i][j]=='R': ir=[i,j]
        elif board[i][j]=='B': ib=[i,j]
        elif board[i][j]=='O': hole=[i,j]








for i in range(N):

    print(board[i])

