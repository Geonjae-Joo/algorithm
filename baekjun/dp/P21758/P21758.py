import sys
sys.stdin = open("E:/algorithm/baekjun/dp/P21758/input.txt")
input = sys.stdin.readline

N = int(input())
arr = list(map(int,input().split()))
dp_l =[]
dp_r =[]
l=0
r=0
max_idx=0
for i in range(len(arr)):
    l+=arr[i]
    r+=arr[N-i-1]
    if arr[i]>arr[max_idx]:
        max_idx = i
    dp_l.append(l)
    dp_r.insert(0,r)
#left right
num_lr= dp_r[0]-arr[0]-arr[N-1]+arr[max_idx]
#left left
num_ll=0
for i in range(1,N):
    num_ll = max(num_ll,dp_l[N-1]-arr[0]+dp_l[N-1]-dp_l[i]-arr[i])
    if i==N-1 or arr[i+1]>=arr[i]: break
num_rr=0
for i in range(N-2,-1,-1):
    num_rr = max(num_rr,dp_r[0]-arr[N-1]+dp_r[0]-dp_r[i]-arr[i])
    if i==0 or arr[i-1]>=arr[i]: break

answer = max(num_lr,num_ll,num_rr)

print(answer)

