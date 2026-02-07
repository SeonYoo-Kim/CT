t = int(input())
for _ in range(t):
    n = int(input())
    score = 0
    grade = 0
    for _ in range(n):
        c, g = map(float, input().split())
        score += c * g
        grade += c
    print(int(grade), f"{score/grade:.1f}")