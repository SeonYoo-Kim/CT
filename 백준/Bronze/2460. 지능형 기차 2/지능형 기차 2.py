on = 0
full = 0

for i in range(10):
    a, b = map(int, input().split())
    on += b
    on -= a
    if full <= on:
        full = on
print(full)
