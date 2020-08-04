;; file: task1.s
;; author: Ha Le
;; date: September 17th 2019
;;
;; This program reads two numbers and displays the sum of their square


allocate-registers a b a2 b2 sumSquare 

read a ; read in the arguments
read b
mul a2 a a ; find the square of the first number
mul b2 b b ; find the square of the second number
add sumSquare a2 b2 ; add the square of the two numbers
write sumSquare ; display the result
halt
