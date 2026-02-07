import sys
input = sys.stdin.readline 
for _ in range(3):
    n = int(input())
    sum = 0
    for _ in range(n):
        a = int(input())
        sum += a
    if sum > 0:
        print("+")
    elif sum < 0:
        print("-")
    else:
        print("0")