from heapq import heappush,heappop
import sys
sys.stdin = open("E:/algorithm/baekjun/dijkstra/P4485/input.txt")
input = sys.stdin.readline
INF = sys.maxsize

def d_func():
    pq = []
    heappush(pq,(board[0][0],0,0))
    dp[0][0] = board[0][0]
    while(pq):
        cur_c,cy,cx = heappop(pq)
        for i in range(4):
            ny = cy+dy[i]
            nx = cx+dx[i]
            if(0<=ny<N and 0<=nx<N and vst[ny][nx]==0 ):
                next_c = cur_c+board[ny][nx]
                if(next_c<dp[ny][nx]):
                    dp[ny][nx] = next_c
                    heappush(pq,(next_c,ny,nx))
                    vst[ny][nx]=1
    
tc=1
while(1):
    N = int(input())
    if N==0: break
    dx = [-1,0,0,1]
    dy = [0,-1,1,0]
    # adj
    board = [list(map(int,input().split())) for _ in range(N)]
    vst = [[0]*N for _ in range(N)]
    dp = [[INF]*N for _ in range(N)]
    # print(dp)
    d_func()

    sys.stdout.write("Problem "+str(tc)+": "+str(dp[N-1][N-1])+"\n")
    tc+=1