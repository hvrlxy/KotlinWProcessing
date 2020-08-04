;; file: task2.s
;; author: Ha Le
;; date: September 17th 2019
;;
;; This program reads a number and its exponent, execute exponentiation and produce the result

allocate-registers b e pow zero one comparison loop end

read b ; read in the arguments
read e

li pow 1 ; set the counting variable to 1
li one 1 ; load constant 1

li loop loopL
li end endL

loopL:
	sgt comparison e zero
	jeqz comparison end
	mul pow pow b
	sub e e one
	j loop

endL:
	write pow ; display the result
	halt