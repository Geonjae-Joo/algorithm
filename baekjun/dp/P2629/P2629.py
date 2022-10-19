import sys

sys.stdin = open("E:/algorithm/baekjun/dp/P2629/input.txt")
input = sys.stdin.readline

N = int(input())
balls = list(map(int,input().split()))
total = sum(balls)
testCount = int(input())
test = list(map(int,input().split()))

dp = [['N' for _ in range(40001)] for __ in range(N)]
for i,ball in enumerate(balls):
    for w in range(1,total+1):
        if i==0:
            dp[i][ball]='Y'
        else:
            
            dp[i][ball]='Y'
            if dp[i-1][w]=='Y':
                dp[i][w]='Y'
                dp[i][abs(ball-w)]='Y'
                if ball+w<=total: dp[i][ball+w]='Y'
for i in range(testCount):
    sys.stdout.write(dp[-1][test[i]]+" ")
            
