
import sys


sys.stdin = open("E:/algorithm/baekjun/P14888/input.txt","r")
input = sys.stdin.readline
N = int(input())
nums = list(map(int,input().split()))
op = list(map(int,input().split()))
vst = [0]*4
# print(nums)
answerMin = 1e9
answerMax = -1e9

def dfs(result,flag,operate):
    global answerMax
    global answerMin
    vst[operate]+=1
    if(operate==0): result+=nums[flag]
    if(operate==1): result-=nums[flag]
    if(operate==2): result*=nums[flag]
    if(operate==3):
        if(result<0):
            result*=-1
            result//=nums[flag]
            result*=-1
        else:
            result//=nums[flag]
    for i in range(4):
        if(vst[i]<op[i]): dfs(result,flag+1,i)
    vst[operate]-=1
    if(flag==N-1):
        answerMin = min(answerMin,result)
        answerMax = max(answerMax,result)



for i in range(4):
    if(op[i]==0): continue
    dfs(nums[0],1,i)
print(answerMax)
print(answerMin)
