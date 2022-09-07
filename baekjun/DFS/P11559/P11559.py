import sys

sys.stdin = open("E:/algorithm/baekjun/P11559/input.txt","r")
dx= [-1,0,1,0]
dy = [0,1,0,-1]
m = [[i for i in input()] for j in range(12)]
ans = 0
# print(m)


def dfs(x,y,char):
    # print(x,y,char,vst[x][y])
    vst[x][y] = True
    chain.append([x,y])
    for i in range(4):
        newX = x+dx[i]
        newY = y+dy[i]
        # print(newX,newY,m[newX][newY],vst[newX][newY])
        # print(newX,newY)
        if (0<=newX<12 and 0<=newY<6 and vst[newX][newY]==False and m[newX][newY]==char):
            dfs(newX,newY,char)
    # vst[x][y]=False
    
def down():
    for j in range(6):
        tmp=[]
        for i in range(11,-1,-1):
            if(m[i][j]!='.'): tmp.append(m[i][j])
        tmpCount = 11
        for i in range(12):
            if(i<len(tmp)):
                m[tmpCount][j] = tmp[i]
            else: m[tmpCount][j] = '.'
            tmpCount-=1



while(True):
    vst = [[False]*6 for i in range(12)]
    # print(vst)
    isDone = True
    for i in range(11,-1,-1):
        for j in range(6):
            if(m[i][j]!='.'and vst[i][j]==False):
                chain =[]
                dfs(i,j,m[i][j])
                # print(chain)
                if(len(chain)>=4):
                    isDone = False
                    for iN,jN in chain:
                        m[iN][jN] = '.'
    down()

    if isDone: break
    ans+=1
print(ans)
