allocate-registers n k ; the arguments
allocate-registers one ; constant one
allocate-registers sp ; stack point
allocate-registers comparison
allocate-registers val ; result
allocate-registers baseCase loop end

read n
read k

li one 1

li sp 0

st n sp
add sp sp one
st k sp
add sp sp one

li baseCase baseCaseL
li loop loopL
li end endL

loopL:

	jeqz sp end

	sub sp sp one
	ld k sp
	sub sp sp one
	ld n sp

	jeqz k baseCase
	sne comparison n k
	jeqz comparison baseCase

	sub n n one
	st n sp
	add sp sp one
	sub k k one
	st k sp
	add sp sp one
	st n sp
	add sp sp one
	add k k one
	st k sp
	add sp sp one
	j loop

baseCaseL:
	add val val one
	j loop

endL:
	write val
	halt

