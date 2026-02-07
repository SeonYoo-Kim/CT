a, b, c = map(int, input().split())
if b-a==0 and c-b==0:
    print("0")
elif b-a >= c-b:
    print(b-a-1)
else:
    print(c-b - 1)