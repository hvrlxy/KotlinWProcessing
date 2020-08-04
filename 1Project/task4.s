;; file: task4.s
;; author: Ha Le 
;; date: September 17th 2019
;;
;; This program reads two number and perform exponetiation using recursive method

allocate-registers a e ; arguments
allocate-registers one ; load constant one
allocate-registers sp ; load stack point
allocate-registers baseCase, store ; these hold labels lines
allocate-registers val ; the result
allocate-registers cont ; load the continuation

read a  ; read the arguments in
read e

li one 1 

li sp 0 ; set the stackpoint to 0

li baseCase baseCaseL
li store storeL
li cont endL ; set the continuation

storeL:
	jeqz e baseCase ; if e = 0

	st a sp
	add sp sp one
	sub e e one
	st cont sp
	add sp sp one
	li cont loadL
	j store

loadL:
	sub sp sp one
	ld cont sp
	sub sp sp one
	ld a sp

	mul val val a
	j cont

baseCaseL:
	;; the e = 0 case
	add val val one
	j cont

endL:
	write val ; display the result
	halt
