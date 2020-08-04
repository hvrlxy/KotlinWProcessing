import random
def RPSGame():
    options = ["rock", "paper", "scissors"]
    i = getGameChoice(options)
    you = getUserChoice()

    if (i == "rock" and you == "scissors") or (i == "scissors" and you == "paper") or (i == "paper" and you == "rock"):
        result = " I win! \nGood luck next time!!!"
    elif (i == you):
        result = " It's a tie!!!"
    else:
        result = " You win! \nCongratulations!!!"

    print ("You choose %s" %(you) +  " and I choose %s." %(i) + "%s." %(result))

def getGameChoice(aList):
    i = random.randint(0,2)
    return aList[i]

def getUserChoice():
    print("Please choose between \"rock\", \"paper\" or \"scissors\"")
    userChoice = input()
    if userChoice == "rock" or userChoice == "paper" or userChoice == "scissors":
        return userChoice
    else:
        getUserChoice()

    
