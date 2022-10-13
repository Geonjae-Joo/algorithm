import sys

sys.stdin = open("E:/algorithm/baekjun/P16499/input.txt")
input = sys.stdin.readline
# N = int(input())
# s = set()
# for i in range(N):
#     s.add(tuple(sorted(input().rstrip())))
# sys.stdout.write(str(len(s)))

n = int(input())
arr = [input() for _ in range(n)]
answer = []
for i in arr:
  answer.append("".join(sorted(i)))
print(answer)
print(len(set(answer)))
