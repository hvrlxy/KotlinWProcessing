/*******************************************************************************
 *  Name:    Ha Le
 ******************************************************************************/

Project: Kotlin & processing basics

Operating system (such as OS X, Linux, or Windows WSL): OS X
Text editor (such as TextWrangler):  Sublime Text
Hours to complete assignment:  6 hours


/**********************************************************************
 *  What is the relationship between the number of steps n of the
 *  random walk and the mean squared distance? By relationship, we mean
 *  something like
 *                       mean squared distance = 126 n^9
 *
 *  Briefly justify your answer based on computational experiments.
 *  Describe the experiments and list several data points.
 *********************************************************************/
To test the relationship between n and the mean square distance, we will run the program using a significantly large number for trials to get the most accurate mean square distance. We will try to run the program using trials = 100000. 

Below is several data points gathered from the experiment:

$ processing-kt RandomWalkersKt 1500 100000
mean square distance = 1499.2117
(n = 1500, mean square distance = 1499.2117)

$ processing-kt RandomWalkersKt 1000 100000
mean square distance = 1000.1608
(n = 1000, mean square distance = 1000.1608)

$ processing-kt RandomWalkersKt 2000 100000
mean square distance = 2008.584
(n = 2000, mean square distance = 2008.584)

$ processing-kt RandomWalkersKt 320 100000
mean square distance = 318.6123
(n = 320, mean square distance = 318.6123)

We can see from the data above, as n grows, the mean square distance grows according to the formula: mean square distance = n


/**********************************************************************
 *  Did you receive help from classmates, past MCS 178 students, or
 *  anyone else? If so, please list their names.
 **********************************************************************/

Yes or no? Yes

Maddie Sandish
Filip Belik


/**********************************************************************
 *  Did you encounter any serious problems? If so, please describe.
 **********************************************************************/

Yes or no? No


/**********************************************************************
 *  List any other comments here.                                     
 **********************************************************************/

 I put the code for functions bear1 and bear2 in different .kt file. Function bear1 is in Bears.kt and function bear2 is in Bear2.kt.
