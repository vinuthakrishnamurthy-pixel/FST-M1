#Player Initialisation

player1 = input( "Player 1 name " ) 
player2 = input ( "Player 2 name" )

while True:

# User Inputs

    player1_input = input (player1 + ",Choose your input - rock, paper or scissors?")
    player2_input = input (player2 + ",Choose your input - rock, paper or scissors?")

#Rule validation
    if player1_input==player2_input:
        print ("It's a tie!")
#Rock beats scissors
    elif player1_input=='rock':
        if player2_input=='scissors':
            print ("Rock wins!")
        else:
            print ("Paper Wins!")
#Scissors beats paper
    elif player1_input=='scissors':
        if player2_input=='paper':
            print ("Scissors wins!")
        else:
            print ("Rock Wins!")
#Paper beats rock
    elif player1_input=='paper':
        if player2_input=='rock':
            print ("Paper wins!")
        else:
            print ("Scissors Wins!")
    else:
        print("Invalid input! You have not entered rock, paper or scissors, try again.")
    
    # Game Repeats
    again = input ("Do you want to play again? Y/N:")
    if(again == "Y"):
        pass
    # If they say no, exit the game
    elif(again == "N"):
        raise SystemExit
    # If they say anything else, exit with an error message.
    else:
        print("You entered an invalid option. Exiting now.")
        raise SystemExit
