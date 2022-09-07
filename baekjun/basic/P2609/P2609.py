import sys

sys.stdin=open("E:/algorithm/baekjun/basic/P2609/input.txt","r")
input=sys.stdin.readline
a, b = map(int, input().split())



def lcd(i, j):
    while(i%j!=0):
        tmp =j
        j = i%j
        i = tmp
    return j
def lca(i,j):
    l = lcd(i,j)
    return int(i*j/l)
print(lcd(a,b))
print(lca(a,b))