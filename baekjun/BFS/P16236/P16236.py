import heapq
import sys
def new_cmp_lt(self,a,b):
    return a[1]<b[1]

heapq.cmp_lt = new_cmp_lt

sys.stdin = open("E:/algorithm/baekjun/dijkstra/P16236/input.txt")

input = sys.stdin.readline
INF = sys.maxsize
dx = [-1,0,0,1]
dy = [0,-1,1,0]

N = int(input())
board = [list(map(int,input().split()))for _ in range(N)]
level =2
# dp = [INF for _ in range(N+1)]
ix=0
iy=0
time=0
count=0
for i in range(N):
    for j in range(N):
        if board[i][j]==9:
            ix=i
            iy=j
def bfs(ix,iy,level,count,time):
    end_flag=0
    q = []
    heapq.heappush(q,[time,ix,iy])
    vst[ix][iy]=1
    while(q):
        print(q)
        c = heapq.heappop(q)
        ct = c[0]
        cx = c[1]
        cy = c[2]
        if board[cx][cy]<level and board[cx][cy]!=0:
            end_flag=1
            count+=1
            if count==level:
                level+=1
                count=0
            board[cx][cy]=0
            break
        # print(cx,cy,ct)
        # print(q)

        for _ in range(4):
            nx = cx+dx[_]
            ny = cy+dy[_]
            if nx<0 or nx >=N or ny<0 or ny>=N: continue
            if vst[nx][ny]==1: continue
            nVal= board[nx][ny]
            if nVal >level: continue
            # if nVal ==level or nVal==0:
            vst[nx][ny]=1
            heapq.heappush(q,[ct+1,nx,ny])
            # else:
            #     # print('a')
            #     end_flag=1
            #     flag=1
            #     break
    return cx,cy,level,count,ct,end_flag
result=0
while(1):
    # for i in range(N):
        # print(board[i])
    
    vst = [[0]*N for _ in range(N)]
    ix,iy,level,count,time,end_flage = bfs(ix,iy,level,count,time)

    if not end_flage: break
    else: result = time
# print(time)
print(result)
            



# print(board)