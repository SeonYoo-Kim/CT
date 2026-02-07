num = input()
answer = input().split()
total_score = 0
score = 0

for i in range(len(answer)):
    if int(answer[i]) == 1:
        score += 1
        total_score += score
    else:
        score = 0
print(total_score)
