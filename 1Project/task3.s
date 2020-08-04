;; file: task3.s
;; author: Ha Le
;; date: September 17th 2019
;;
;; This program reads two number and perform exponentiation. 
;; If the program notice an even exponent, it will reduce the exponent by half and 
;; square the number, reduce the time it takes to execute the equation.

allocate-registers b e zero one two while-loop if else pow comparison end remainder

read b ; read in the arguments
read e

li zero 0 ; load constants 0,1,2 used in several places
li two 2
li one 1
li pow 1  ; set the counting variable to 1

li while-loop loopL
li if ifL
li else elseL
li end endL

loopL:
	sgt comparison e zero
	jeqz comparison end    ; jump to end the loop if e = 0
	rem remainder e two
	jeqz remainder if      
	j else

ifL:
	;; for e % 2 == 0
	mul b b b
	div e e two
	j while-loop

elseL:
	;; for e % 2 == 1
	mul pow pow b
	sub e e one
	j while-loop

endL:
	write pow ; display the result
	halt