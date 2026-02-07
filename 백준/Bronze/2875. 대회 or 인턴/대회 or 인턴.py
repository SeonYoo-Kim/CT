n, m, k = map(int, input().split())
t = 0

while True:
    if n < 2 or m < 1 or n + m < k + 3:
        break
    else:
        n -= 2
        m -= 1
        t += 1

print(t)