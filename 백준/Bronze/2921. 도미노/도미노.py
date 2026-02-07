n = int(input())
sum = 0
for _ in range(n):
    sum += 1.5 * n * (n + 1)
    n -= 1
print(int(sum))