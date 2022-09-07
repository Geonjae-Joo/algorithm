
import sys


sys.stdin = open("E:/algorithm/baekjun/P14888/input.txt","r")
input = sys.stdin.readline
N = int(input())
nums = list(map(int,input().split()))
op = list(map(int,input().split()))
vst = [0]*4
maxAnswer=0
minAnswer=10**9

# print(N)
# print(nums)
# print(op)

def dfs(num,flag,operate):

    global maxAnswer
    global minAnswer
    # print(operate)
    # print(flag)

    vst[operate]+=1
    if(operate==0): num+=nums[flag]
    elif(operate==1): num-=nums[flag]
    elif(operate==2): num*=nums[flag]
    else:
        if(num>=0):num //=nums[flag]
        else:
            num = -1*num
            num //=nums[flag]
            num = -1*num
    for i in range(4):
        if(vst[i]<op[i] ):dfs(num,flag+1,i)
    vst[operate]-=1
    if(flag==N-1):
        # print('a')
        # print(num)
        if(maxAnswer<num): maxAnswer = num
        if(minAnswer>num): minAnswer = num



for i in range(4):
    if(op[i]!=0):
        dfs(nums[0],1,i)

print(maxAnswer)
print(minAnswer)