r,c = map(int, input().strip().split(" "))
mlist = [0]*9



sortlist = [0]*9

for k in range(r):
    line = input().strip()
    i=1
    while(line[i]=="."):
        i+=1
    if line[i] == 'F': continue
    num = int(line[i])
    mlist[num-1]=i
    
slist = sorted(set(mlist), reverse=True)
j=1

for i in slist:
    for k in range(9):
        if(i==mlist[k]):
            sortlist[k] = j

    j+=1

for i in range(9):
    print(sortlist[i])