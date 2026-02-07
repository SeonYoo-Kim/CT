t = int(input())
for _ in range(t):
    min = 100
    sum = 0
    a = list(map(int, input().split()))
    for i in range(7):
        x = int(a[i])
        if x % 2 == 0:
            sum += x
            if x < min:
                min = x
    print(sum, min)