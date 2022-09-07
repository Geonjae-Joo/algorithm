import sys 

sys.stdin = open("E:/algorithm/baekjun/P1302/input.txt","r")
N  =int(input())
d = {}
for i in range(N):
    s = input()
    if s in d.keys():
        d[s]+=1
    else:
        d[s]=1
d=sorted(d.items(),key = lambda item:item[1],reverse=True)
preVal = d[0][1]
ans_list =[]
for k,v in d:
    if(preVal!=v): break
    ans_list.append(k)
print(sorted(ans_list)[0])

