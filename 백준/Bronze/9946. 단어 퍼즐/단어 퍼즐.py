
tryCount = 0

while(True):
    tryCount += 1

    n = input()
    m = input()

    if(n=="END" and m=="END"):
        break

    nchList = list(n)
    mchList = list(m)

   
    if(sorted(nchList) == sorted(mchList)):
        print(f"Case {tryCount}: same")
    else:
        print(f"Case {tryCount}: different")

    