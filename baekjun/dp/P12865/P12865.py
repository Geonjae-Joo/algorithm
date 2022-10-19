import sys
sys.stdin = open("E:/algorithm/baekjun/dp/P12865/input.txt")
input = sys.stdin.readline
N,K = map(int,input().split())
items = [list(map(int,input().split())) for _ in range(N)]
# items.sort()
dp = [[0 for _ in range(K+1)] for __ in range(N)]

# for i in range(N):
#     print(dp[i])

for i,item in enumerate(items):
    w,v = item

    for k in range(1,K+1):
        if i==0:
            if k-w<0:continue
            dp[i][k] =v
        elif k-w>=0:
            dp[i][k]=max(dp[i-1][k],dp[i-1][k-w]+v)
        else:
            dp[i][k] = dp[i-1][k]
sys.stdout.write(str(dp[-1][-1]))

# print()    
# for i in range(N):
#     print(dp[i])