import sys
sys.stdin = open("E:/algorithm/baekjun/P2293/input.txt","r")
n,k = map(int,input().split())
coins = [0]*100001
max_coin = 0


def dfs(x,coinSum):
    global ans
    coinSum +=x
    if(coinSum==k): ans+=1
    elif(coinSum>k): return
    vst[x]+=1
    for i in range(len(coins)):
        if(vst[i]>=coins[i] or coinSum+i>k): continue
        dfs(i,coinSum)
    vst[x]-=1

    


for i in range(n):
    coin = int(input())
    max_coin = max(max_coin,coin)
    coins[coin] = k//coin
coins = coins[:max_coin+1]
print(coins)
vst = [0]*len(coins)
ans=0
dfs(0,0)
print(ans)