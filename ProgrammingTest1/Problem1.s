allocate-registers n count one val loop end result remainder

read n

;; I start counting from 1 because every positive number already have 
;; a factor which is itself

li count 1 

li one 1

add val val n

li loop loopL
li end endL
li result resultL

loopL:
	sub val val one
	jeqz val end
	rem remainder n val
	jeqz remainder result
	j loop

resultL:
	add count count one
	j loop

endL:
	write count
	halt