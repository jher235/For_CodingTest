def findNum4and7(n):
    for i in range(n,0,-1):
        iSet = set(list(str(i)))
        if(checkSet>=iSet):
            print(i)
            return


n = int(input())

checkSet = set(['4','7'])

findNum4and7(n)