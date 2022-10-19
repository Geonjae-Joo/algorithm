import sys

sys.stdin = open("E:/algorithm/baekjun/dp/P9084/input.txt")
input = sys.stdin.readline
T = int(input())

#tc
for tc in range(T):
    N = int(input())
    coins = list(map(int,input().split()))
    # coins.sort(reverse=True)
    M = int(input())
    # if tc!=1: continue
    # print(coins)
    coins.sort(reverse=True)
    dp = [[0 for _ in range(M+1)] for __ in range(N)]
    for i,coin in enumerate(coins):
        # if i!=0:
        #     dp[i]=deepcopy(dp[i-1])
        for m in range(M+1):
            if m==0:
                dp[i][m]=1
            elif i==0:
                if m%coin==0:
                    dp[i][m]=1
            else:
                if m-coin<0: continue
                dp[i][m] = dp[i-1][m]+dp[i][m-coin]
    print(dp[-1][-1])
    # print([i for i in range(M+1)])
    # for i in range(N):
    #     print(dp[i])