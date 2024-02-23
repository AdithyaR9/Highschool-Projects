# Basic Projects

Created: December 2018 - June 2019
Uploaded: July 30 2021
Consolidated: February 23 2024

HelloUser:
    This is a simple Scanner Application I created when I first learned about Scanners in Java. It asks the user for his/her name and then greets the user with the name they gave. 

Circle: 
    This is a Scanner Application that askes the user for a desired circle radius. It then prints out the circumference, and area of a circle with the user-provided radius.

ClassPercentile:
    This is a Scanner Application that requests the students class size, and class rank. Using those parameters, the application prints out the user's class percentage (ex. you are in top 40%).

Multiples:
    This is a Scanner Application that takes in a number from the user and the number of multiples that the user would like to see of the number they provided. The program will then, using the giver number parameter, print out the specified number of multiples of that number.

SentenceInfo:
    This is a String Application that requests a sentence from the user. The application then prints out information about the sentence, including word count, character count, vowel count, and consonant count.

StringExplosion:
    This is a String Application that allows the user to enter a sentence and then prints the altered form of the sentence using on the following rules:
    - Alteration Rules:
    - Words of even length
        - 2 letter words are converted to all caps 
                Ex: it = IT
        - 4 letter words are replaced with **** 
                Ex: dogs = ****
        - 6 letter words
            - Letters at locations (0 and 5) and (2 and 3)
                Ex: spring = gpirns
            - 8+ letter words are broken into two words of equal length
                Ex: iterator = iter ator
    - Words of odd length
        - 1 letter words are replaced with %
                Ex: A = % 
        - 3 letter words
            - Replace the 1st letter with <
            - Replace the last letter with >
                Ex: cat = <a>
        -  5 letter words
            - All lowercase letters are changed to uppercase

PigLatinConverter:
    This is a String Application that allows the user to enter a sentence that the application then converts and prints out in Pig Latin using hte following rules

    - Basic Rules:
    - if the word starts with a consonant then move the leading consonants to the end of the word and then add “ay” to the end of the word
    - If the word starts with a vowel add “way” to the end of the word
    - Special Case Rules:
    - When a y is the first letter treat it as a consonant. Treat all y’s after the first letter of a word as vowels
    - If the words first vowel is a ‘u’ and the letter before it is a ‘q’, move everything up to and including the u to the end of the word and then add “ay”

TicTacToe-Console:
    This is a tic tac toe game that plays inside the console. It takes in each player's row and column for their desired move, and then displays the board in the console using the characters '-' and '|' in a specific way with 'X' and 'O' to represent the players.  (I created this when I first learned about arrays and 2D arrays and how they could be used to make grid-based games, like Chess and Checkers.)

MazeGame:
    This is a Game Application, that plays in the console, that allows the user to navigate a maze until they reach the end. 

    I created this when I first learned about arrays and 2D arrays and how they could be used to make grid-based games, like Chess and Checkers. 

    - The user will have the following options: move up, move down, move left and move Right.
    - Each time before a user moves the program will display the maze with the player’s location represented with an ‘X’. 
    - When the player reaches the end of the maze the program will display how many moves it took him/her to solve it.

    - Maze Symbols:
    - ‘S’ – Starting Point
    - ‘E’ – Ending Point
    - ‘W’ – Wall  
    - ‘-‘ – Path
    - Controls:
    - ‘w’–up
    - ‘s’ – down
    - ‘a’ – left
    - ‘d‘ – right

ConnectFour:
    This is a Game Application, that plays in the console, that allows the user to play Connect four; the user can either play with another person on the same computer, or they can play aginst a simple AI that will try its best to prevent the user from winning. 

    - 'R' represents the Red Player (P1)
    - 'B' representes the Blue Player (P2 or AI/cpu)

    *I created this in order to incorporate my more advanced knowledge of arrays, that I had learned about a couple months prior, with some new things I had learned about AIs. I wanted to try to create my own basic AI that could play with a real person in a game. 

DataSetArrayList:
    This is an ArrayList Program, that runs in the console that allows a user to manipulate a set of integer values. The program displays a menu with possible options to manipulate the list. 

    *I created this to try to put into practice the ArrayLists that I had just learned about. 

    Menu Options:
    - Add values – add values until 0 is entered
        - Each value is added to the end of the ArrayList. 
        - Zero is not added.
    - Change a value –Changes the value at a given location. 
        - Prints an error if the index is invalid.
    - Insert a value – Adds a single value at a given location.
        - Prints an error if the index is invalid.
    - Get Index – Prints the value at a given location. 
    - Prints an error if the index is invalid.
    - Get Size – Prints the number of elements in the ArrayList
    - Print – Displays all the values in the ArrayList
    - Total – Prints the total of all the values in the ArrayList
    - Average – Prints the average of all the values in the ArrayList
    - Remove a value – Attempts to remove a value given.
        - If the remove was successful print “remove successful”
        - If the remove was unsuccesful print “value not found”.
    - Remove a location – Removes the value at a given location and prints the value that was removed.
    - Prints an error if the index is invalid.
    - Clear –Empties the ArrayList
    - Exit – Exits the program

SeatingChartCreator:
    This is a seating chart program, that runs in the console, that allows the user to enter in a list of names and the number of seats available in the class. The program then creates a seating chart, assigning each student a seat number, and prints it.

    *I created this to continue exploring and experimenting with the advanced capabilites of ArrayLists compared to standard arrays.

Hangman:
    This is a Game Application, that plays in the console, that allows the user to play hangman with the computer. The computer will provide a sentence, and the user with play hangman - trying to figure out that sentence, letter by letter.

        - Before each guess the user will see what the sentence looks like based on the current letters they have guessed, the guessed vowels, the guessed consonants and the number of guesses that the user has before the game ends.
        - The game will end once the user has run out of guesses or has guessed all the letters in the sentence correctly.

    *I created this to see the ability of ArrayLists in creating fun games

ZombieDice:
    *I created this game to try to apply the programming skills and knowledge I had acquired to a game that I was not very familiar with and to test my capabilities.        I wanted to see the extent of my ability and to see how Object Oreinted programming to could allow for cleaner, more organized and better code. 

    This Game Application, played in the console, allows the user to play the board game Zombie Dice with two to five players. The game will start by getting players’ names and then generates a random turn order.

    How the game works:
    - The game consists of 13 dice 
    - 6 Green Dice
        - Faces: 2xRunners, 3xBrains, 1xShots
    - 4 Yellow Dice
        - Faces: 2xRunners, 2xBrains, 2xShots
    - 3 Red Dice
        - Faces: 2xRunners, 1xBrains, 3xShots
    - A player wins after she / he collects 13 brains and stops rolling.
    - Turns alternate until there is a winner.
    - Player turns
    -  A play has the following choices each turn
        -  Roll dice
        -  1. Gathering Dice
            - a. Runners are picked up
            - b. New dice are drawn until the player has 3 dice to roll or the zombie bucket is empty.
        - 2. Rolling Dice
            - a. Rolled brains are held
            - b. Rolled shots are held
            - c. Runners will be rerolled if the player continues.
        - 3. Check for death
            - a. If a player has 3 or more shots
            - His/her turn ends
            - All brains earned this turn are lost     
        - Stop
        - All brains gathered in the turn added the players score
        - If the player has 13 or more brains he / she wins the game.

ConnectFour-Remastered:
    This is revised version of the Connect Four Game that allows for more player combinations, such as the Cpu AI playing another Cpu AI.

BlockBusterStore:
    *I created this for fun to see what I could create that also had a practical application other than providing fun. 

    This is a program, that runs in the console, that will allow a user to rent games and movies from a video store. 

    - The user will have the following options when the program starts: rent movie, rent game and check out.
        - When either rent option is picked the user will be given a list of the titles in that category and an option to cancel. 
        - When an item is selected from the list it will print all the information for that title and give the user the option to either rent the item or cancel.
    - When the user selects check out it will print a receipt. 
        - The receipt will include the title of each rented item, each item’s cost, the subtotal, tax and total.

    *I created this version of Connect Four to explore the concept of Inheritance and more extensive OOP.


