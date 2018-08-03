import random

guessNumber = 0
randomNum = random.randint(1,9)
guess = randomNum - 1

while guess != randomNum:
    guess = input("Guess a number that I am thinking    ")
    if (guess == "exit"):
        break
    elif (int(guess) == randomNum):
        print("You are right. You got it in " + str(guessNumber) + " of tries.")
        break
    else:
        print("NOPE! you have tried " + str(guessNumber) + " number of times. TRY AGAIN")
        guessNumber = guessNumber+1