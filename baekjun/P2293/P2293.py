import sys
sys.stdin = open("E:/algorithm/baekjun/P2293/input.txt","r")
n,k = map(int,input().split())
coins = [0]*100001
max_coin = 0


for i in range(n):
    n = int(input())
    max_coin = max(max_coin,n)
    coins[n]+=1
coins = coins[:max_coin+1]

