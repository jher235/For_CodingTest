n = int(input())

def fibdp(n):
    f = [0]*(n+1)
    f[1] = 1
    f[2] = 1
    count=0
    for i in range(3,n+1):
        f[i] = f[i-1]+f[i-2]
        count = count+1
    print("{} {}".format(f[n], count))



fibdp(n)