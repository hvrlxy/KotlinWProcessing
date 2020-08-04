def insertionSort(aList):
    for i in range (1,len(aList)):
        n = aList[i]
        m = i - 1
        while m >=0 and n < aList[m]:
            aList[i] = aList[m]
            aList[m] = n
            m -= 1
            i -= 1
    print (aList)
                
def bubbleSort (aList):
    for i in range (0, len(aList) -1):
        for j in range (0, len(aList) - i -1):
            m = aList[j]
            n = aList[j +1]
            if m>n:
                aList[j +1] = m
                aList[j] = n
    print (aList)

def selectionSort (aList):
    newList = []
    for i in range (0,len([aList])-1):
        newList.insert(i,min(aList))
        aList.remove(newList[i])
    print (newList)

