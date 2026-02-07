import sys
n = int(input())

for i in range(n):
    for j in range(n + i):
        if i == n - 1:
            sys.stdout.write("*")
        else:
            if j == (n * 2 - 1) // 2 - i or j == (n * 2 - 1) // 2 + i:
                sys.stdout.write("*")
            else:
                sys.stdout.write(" ")
    print()