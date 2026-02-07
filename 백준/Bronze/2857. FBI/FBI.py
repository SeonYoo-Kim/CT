flg = True
for i in range(5):
    name = input()
    if "FBI" in name:
        flg = False
        print(i+1, end=' ')

if flg:
    print("HE GOT AWAY!")