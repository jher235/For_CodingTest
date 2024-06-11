

def checkPerfectNum(n):
    harfN = n//2
    sumOfDivisor=0
    divisor = []

    for i in range(1,harfN+1):
        if(n % i ==0):
            divisor.append(i)
            sumOfDivisor += i
    
 
    if(sumOfDivisor == n):
        print(f"{n} = {divisor[0]}", end=" ")
        for j in range(1, len(divisor)): 
            print(f"+ {divisor[j]}", end=" ")
        print()
    else:
        print(f"{n} is NOT perfect.")

    



while(True):
    n = int(input())
    if(n==-1):
        break
    checkPerfectNum(n)


