import math
n, w, h = map(int, input().split())
s = math.sqrt(w**2 + h**2)
for _ in range(n):
    a = int(input())
    if a <= s:
        print("DA")
    else:
        print("NE")