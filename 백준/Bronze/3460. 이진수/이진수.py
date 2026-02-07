import sys

n = int(input())

for i in range(n):
    a = int(input())
    b = 0
    # c = int(a[i])
    while a > 0:
        if a % 2 == 1:
            sys.stdout.write(str(b)+" ")
        a //= 2
        b += 1
    print()