while True:
    a = input()
    if a == '0':
        break
    one = zero = others = 0

    blank = len(a) + 1
    one = a.count('1')
    zero = a.count('0')
    others = len(a) - one - zero

    print(blank + 2 * one + 4 * zero + 3 * others)


