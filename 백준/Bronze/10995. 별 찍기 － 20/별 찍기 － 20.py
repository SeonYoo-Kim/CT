import sys

n = int(input())
for i in range(n):
    for j in range(n):
        if i % 2 == 0:
            sys.stdout.write("* ")
        else:
            sys.stdout.write(" *")
    print()
