x = list(map(int, input().split()))
x.sort()
d = {'A': x[0], 'B': x[1], 'C': x[2]}
s = input()
print(d[s[0]], d[s[1]], d[s[2]])