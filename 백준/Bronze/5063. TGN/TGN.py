cnt = int(input())
for i in range(cnt):
    a, b, c = map(int, input().split())
    if a < (b - c):
        print("advertise")
    elif a > (b - c):
        print("do not advertise")
    else:
        print("does not matter")