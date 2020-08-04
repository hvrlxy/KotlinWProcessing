/**********************************************************************
 *  readme template
 *  Global Sequence Alignment
 **********************************************************************/

Name: Ha Le

Hours to complete assignment (optional):

/**********************************************************************
 *  Describe any serious problems you encountered.                    
 **********************************************************************/


/**********************************************************************
 *  For each data file, fill in the edit distance computed by your
 *  program and the amount of time it takes to compute it.
 **********************************************************************/

data file         distance    dp time (seconds)    mem time (seconds)
-----------------------------------------------------------------------
ecoli3000.txt		125			8.055				8.490
ecoli5000.txt		160			34.559				33.550
ecoli7000.txt		194			90.7				93.249
ecoli10000.txt		223			259.822				258.393


/**********************************************************************
 *  Because both top-down and bottom-up dynamic programming uses a
 *  two-dimensional table, we expect that the time complexity should be
 *  quadratic.  Does the data above seem to support this hypothesis? Use
 *  the doubling hypothesis to explain how you arrived at your answer.
 **********************************************************************/
Yes. Compare the ecoli 3000 and the ecoli 5000 file results. In reality,
we can observe that the time complexity ratio is 8.055/34.559 = 0.23 and 
8.490/33.550 = 0.253. The functions have to go through the nested for loops
3000 and 5000 times respectively, so theoretical , it would take 3000^2/
5000^2 = 0.36, which equals to approximately 1.44 times the reality time 
complexity. Compare the ecoli 5000 and ecoli 7000, the reality time complexity
is 34.559/90.700 = 0.38 and 33.550/93.249 = 0.359, and the theoretically time
ratio should be 5000^2/7000^2 = 0.5102, which is roughly 1.44 times the
real time ratio. So we can conclude that the time complexity should be 
a quadratic function with the slope = 1.44.


/**********************************************************************
 *  As a function of the string length N (assume M = N), estimate the
 *  running time of your (dp & mem) programs (and the sample) in seconds.
 *  Your answer should have the form a * N^2 for some constant a.
 *
 *  What is the largest N your program can handle if it is limited to 1
 *  day of computation? Assume you have as much main memory as you need.
 **********************************************************************/

a = 9.07 * 10^(-7)

1 day has 86400 seconds so :
largest N = 308640.723


/**********************************************************************
 *  List whatever help (if any) that you received. You don't need to
 *  include the course materials or lectures, but do include any
 *  additional help your received from people other than course staff,
 *  and include their names.
 **********************************************************************/


/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/
