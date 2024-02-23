import java.util.Scanner;
class Main 
{
  public static void main(String[] args) 
  {
    char p1 = 'X';
    char p2 = 'O';
    int counter = 0;
   char[][] tictac = {{' ',' ',' '},
                     {' ',' ',' '},
                     {' ',' ',' '}};
    for(int x = 0;x<6;x++)
    {
          
          if(counter%1 == 0)
     {
       if(isWinner(tictac,p1) == true)
       {System.out.print("Player1 has is the Winner!");
         break;
       }
       if(isWinner(tictac,p2) == true)
       {System.out.print("Player2 is the Winner!");
         break;
       }
       
       if(isCat(tictac) == true)
       {
         System.out.print("The game has ended in a tie(CAT).!?!?!.");
         break;
       }
     }
      
    Scanner bobi = new Scanner(System.in);
    
    System.out.println("Player1 (X) enter the row for your move (0-2): ");
    int row = bobi.nextInt();
    
    System.out.println("Player1 (X) enter the column for your move (0-2): ");
    int column = bobi.nextInt();
    
    while(tictac[row][column] != ' ')
    {System.out.print("Invalid Move! Try again with another space.\n");
      System.out.println("Player1 (X) enter the row for your move (0-2): ");
     row = bobi.nextInt();
    
    System.out.println("Player1 (X) enter the column for your move (0-2): ");
     column = bobi.nextInt();}
    
    tictac[row][column] = 'X'; 
    
     displayBoard(tictac);
    
    if(counter%1 == 0)
     {
       if(isWinner(tictac,p1) == true)
       {System.out.print("Player1 has is the Winner!");
         break;
       }
       if(isWinner(tictac,p2) == true)
       {System.out.print("Player2 is the Winner!");
         break;
       }
       
       if(isCat(tictac) == true)
       {
         System.out.print("The game has ended in a tie(CAT).!?!?!.");
         break;
       }
     }
    
    System.out.println("Player2 (O) enter the row for your move (0-2): ");
    int rowe = bobi.nextInt();  
    
    System.out.println("Player2 (O) enter the column for your move (0-2): ");
    int columne = bobi.nextInt();
    
    while(tictac[rowe][columne] != ' ')
    {System.out.print("Invalid Move! Try again with another space.\n");
      System.out.println("Player2 (O) enter the row for your move (0-2): ");
     rowe = bobi.nextInt();
    
    System.out.println("Player2 (O) enter the column for your move (0-2): ");
     columne = bobi.nextInt();}
    
    tictac[rowe][columne] = 'O'; 
    
     displayBoard(tictac);
     
     counter++;
 
    }
      
  }
  
  public static void displayBoard(char[][] board)
  {
    for(int i = 0; i < board.length;i++)
    {
	    for(int j = 0; j < board[0].length;j++)
      {
        System.out.print(board[i][j]);
        
        if(j != board[0].length - 1)
        {System.out.print(" | ");}
      }
	      System.out.print("\n ------- \n");
    }
  }
  
  public static boolean isWinner(char[][] board, char player)
  {
    //0  0|1|2
    //1  0|1|2
    //2  0|1|2 
    
    boolean winner = false;
    
    //rows 
    if(board[0][0] == player && board[0][1] == player && board[0][2] == player)
    {winner = true;}
    if(board[1][0] == player && board[1][1] == player && board[1][2] == player)
    {winner = true;}
    if(board[2][0] == player && board[2][1] == player && board[2][2] == player)
    {winner = true;}
    //columns
    if(board[0][0] == player && board[1][0] == player && board[2][0] == player)
    {winner = true;}
    if(board[0][1] == player && board[1][1] == player && board[2][1] == player)
    {winner = true;}
    if(board[0][2] == player && board[1][2] == player && board[2][2] == player)
    {winner = true;}
    //diagonals
    if(board[0][0] == player && board[1][1] == player && board[2][2] == player)
    {winner = true;}
    
    return winner;
  }
   public static boolean isCat(char[][] board)
  {
    boolean cat = false;
    char player1 = 'X';
    char player2= 'O';
    
    if(isWinner(board,player1) == false)
     if(isWinner(board,player2) == false)
      if(board[0][0] == player1 ||board[0][0] == player2)
       if(board[0][1] == player1 ||board[0][1] == player2)
        if(board[0][2] == player1 ||board[0][2] == player2)
         if(board[1][0] == player1 ||board[1][0] == player2)
          if(board[1][1] == player1 ||board[1][1] == player2)
           if(board[1][2] == player1 ||board[1][2] == player2)
            if(board[2][0] == player1 ||board[2][0] == player2)
             if(board[2][1] == player1 ||board[2][1] == player2)
              if(board[2][2] == player1 ||board[2][2] == player2)      
     {cat = true;}
     
    return cat;
  }
}