import random

def guessingGame():
    count = 0
    secretNum = random.randint(1,21)
    print("Hello! Please guess a number from 0 to 20")

    guess = int(input())
    while guess != secretNum:
        if guess < secretNum:
            print("Bigger")
        else:
            print("Smaller")
        count += 1
        guess = int(input())

    print("Number of guess: " + str(count))
    if count < 5:
        print("Great job!")
    else:
        print ("Good luck next time!")
