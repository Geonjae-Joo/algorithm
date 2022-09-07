import sys
sys.stdin = open("E:/algorithm/baekjun/P13397/input.txt","r")
N,M = map(int,input().split())
nums = list(map(int,input().split()))
# print(nums)

def divide(x):
    cnt = 1

    localMin = nums[0]
    localMax = nums[0]
    for i in range(1,N):
        localMin = min(localMin,nums[i])
        localMax = max(localMax,nums[i])
        if(localMax-localMin)>x:
            localMax = nums[i]
            localMin = nums[i]
            cnt+=1
    return cnt



    return cnt
pt_s = 0
pt_e = 10000
result = 0
while(pt_s<=pt_e):
    mid = (pt_e+pt_s)//2
    r = divide(mid)
    #조건
    if(r<=M):
        pt_e = mid-1
        result = mid
    else:
        pt_s = mid+1

print(result)