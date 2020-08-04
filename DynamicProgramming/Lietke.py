def subSet(n,k):
    startList= [i for i in range(1,k+1)]
    print(startList)
    endList = [i for i in range(n-k+1,n+1)]
    while startList != endList:
        i = k - 1
        while (i > -1) and (startList[i] == n + 1 - k + i):
            i = i -1
        startList[i] = startList[i]+1
        for j in range (i+1,k):
            startList[j] = startList[j-1]+1
        print (startList)

def permutation(n):
    startList = [i for i in range (1, n+1)]
    print(startList)
    endList = [i for i in range (n,0,-1)]
    while endList != startList:
        i = n - 2
        while (i > -1) and (startList[i] > startList[i+1]):
            i -= 1
        k = n-1
        while startList[k] < startList[i]:
            k -= 1
        swap(startList,k,i)
        a = i + 1
        b = n - 1
        while a<b:
            swap(startList,a,b)
            a += 1
            b -= 1
        print(startList)

def swap(aList, indexX, indexY):
    x = aList[indexX]
    y = aList[indexY]
    aList[indexX] = y
    aList[indexY] = x
            
def subSet2(n,k):
    startList = [i for i in range (1, k+1)]
    print(startList)
    for i in range (1,k+1):
        for j in range(startList[i - 1] + 1, n - k + i):
            startList[i] = j
            print (startList)
            
def arrange(n,k):
    startList = [i for i in range (1, k+1)]
    booleanList = [i == i for i in range (1, 20)]
       
    for j in range (1,n+1):
        if i == k:
            print (startList)
        else:
            booleanList[j] = False
            i += 1
            arrange(i+1)
            
    
