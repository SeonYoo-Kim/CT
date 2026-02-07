num = int(input())
sum = 0
for i in range(num):
    a, b = map(int, input().split())
    sum += b % a
print(sum)