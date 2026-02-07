import sys
n = int(input())

for i in range(n):
    for j in range(n+i):
        if j == n - i - 1 or j == n + i - 1:
            sys.stdout.write("*")
        else:
            sys.stdout.write(" ")
    print()