
while True: 
    player1 = input("Player 1 : Enter 1: Rocks , 2: Paper    or 3: Scissors")
    player2 = input("Player 2 : Enter 1: Rocks , 2: Paper    or 3: Scissors")
    
    if (player1=="1" and player2=="1") or (player1=="2" and player2=="2") or (player1=="3" and player2 == "3"):
        print("It's a draw")
    elif (player1 == "1" and player2 == "2") or (player1 == "2" and player2 == "3") or (player1 == "3" and player2 == "1"):
        print("Player 2 wins")
    elif (player2 == "1" and player1 == "2") or (player2 == "2" and player1 == "3") or (player2 == "3" and player1 == "1"):
        print("Player 1 wins")
    else:
        print("WRONG INPUT")

    quit = input("Enter yes if you want to quit")
    if (quit == "yes"):
        break