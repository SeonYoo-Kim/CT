cnt = int(input())
time = input().split()
Y = 0
M = 0
for i in range(len(time)):
    Y += 10 * ((int(time[i]) // 30) + 1)
    M += 15 * ((int(time[i]) // 60) + 1)
s = "Y" if Y < M else "M" if M < Y else "Y M"
print(s, min(Y, M))