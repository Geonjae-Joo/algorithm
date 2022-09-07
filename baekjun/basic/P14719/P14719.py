import sys

sys.stdin = open("E:/algorithm/baekjun/P14719/input.txt","r")
input = sys.stdin.readline

H,W = map(int,input().split())
m = list(map(int,input().split()))
print(m)


answer = 0
for i in range(1,W-1):
    leftMax = max(m[:i])
    rightMax = max(m[i+1:])
    lowerWall = min(leftMax,rightMax)
    if m[i]<lowerWall:
        answer+=lowerWall-m[i]

print(answer)
