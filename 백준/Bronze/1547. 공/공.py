num = int(input())
first = 1
second = 2
third = 3
tmp = 0
for i in range(num):
    a, b = map(int, input().split())

    if a == first:
        if b == second:
            temp = first
            first = second
            second = temp
        else:
            temp = first
            first = third
            third = temp
    elif a == second:
        if b == first:
            temp = second
            second = first
            first = temp
        else:
            temp = second
            second = third
            third = temp
    else:
        if b == first:
            temp = third
            third = first
            first = temp
        else:
            temp = third
            third = second
            second = temp
print(first)
