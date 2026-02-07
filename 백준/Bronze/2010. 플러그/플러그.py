import sys

count = int(sys.stdin.readline())
computers = 0

for i in range(count):
    computers += int(sys.stdin.readline())
print(computers - count + 1)
