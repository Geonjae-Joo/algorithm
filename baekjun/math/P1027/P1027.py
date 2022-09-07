import sys
sys.stdin = open("E:/algorithm/baekjun/P1027/input.txt","r")
N = int(input())
# print(N)
arr = list(map(int,input().split()))
# print(arr)
max_sight = 0
for i in range(N):

    in_sight=0
    grad = -1e9-1
    # if(i!=0): continue
    for l in range(i-1,-1,-1):
        new_grad = (arr[l]-arr[i])/(i-l)
        # print(new_grad)
        if(new_grad>grad ):
            
            in_sight+=1
            grad = new_grad
        # print(l)
    grad = -1e9-1
    for r in range(i+1,N):
        new_grad = (arr[r]-arr[i])/(r-i)
        # print(new_grad)
        if new_grad>grad:
            in_sight+=1
            grad = new_grad
        # print(r)
    # print(in_sight)
    max_sight = max(max_sight,in_sight)
print(max_sight)