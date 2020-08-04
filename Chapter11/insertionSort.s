allocate-registers input n num1 num2 num
allocate-registers one zero
allocate-registers comparison Array Count nonPositiveTest
allocate-registers saveData insertionSortCondition insertionSort insertionSort1
allocate-registers insertionSort2 insertionSort3 swapPlace displayData
allocate-registers displayDataLoop endProgram resetCount

li one 1
li zero 0

li saveData saveDataL
li insertionSortCondition insertionSortConditionL
li resetCount resetCountL
li insertionSort insertionSortL
li insertionSort1 insertionSort1L
li insertionSort2 insertionSort2L
li insertionSort3 insertionSort3L
li swapPlace swapPlaceL
li displayData displayDataL
li displayDataLoop displayDataLoopL
li endProgram endProgramL

saveDataL:
	read input
	sgt nonPositiveTest input zero
	jeqz nonPositiveTest insertionSortCondition
	st input Array
	add Array Array one
	add n n one 								; count how many numbers read in
	j saveData

insertionSortConditionL:
	jeqz n endProgram
	sgt comparison n one
	jeqz comparison displayData

	li Array 0									; set Array back to 0

resetCountL:
	li Count 1

insertionSortL:
	add Array Array one
	ld num Array
	li num1 0
	add num1 num1 num 

insertionSort1L:
	sub Array Array Count
	ld num2 Array
	add Count Count one

insertionSort2L:	
	slt comparison num1 num2
	jeqz comparison swapPlace
	st num2 Array
	add Array Array Count
	st num1 Array

insertionSort3L:
	sle comparison Count Array
	jeqz comparison resetCount
	sge comparison Array n
	jeqz comparison insertionSort1
	j displayData

swapPlaceL:
	st num1 Array
	add Array Array Count
	st num2 Array
	j insertionSort3

displayDataL:
	li Array 0
	li Count 0

displayDataLoopL:
	ld num Array
	write num 
	add Array Array one
	add Count Count one
	slt comparison Count n
	jeqz comparison endProgram
	j displayDataLoop

endProgramL:
	halt
