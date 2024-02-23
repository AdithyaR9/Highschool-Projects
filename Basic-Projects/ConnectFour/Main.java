
import java.util.Scanner;
public class Main         
{
    public static void main(String[] args)
    {
        Scanner boi = new Scanner(System.in); 
        Scanner Re = new Scanner(System.in);
        Scanner Bl = new Scanner(System.in);
        boolean to = false;  
        boolean done = false;
        
        System.out.println("PvP enter (1) | PvCPU, enter (0)");
        
        int choze = boi.nextInt();
        ConnectFourGame.draw();
        int[][] board = new int[5][6];
        board = ConnectFourGame.board;
        int lol = 0;
        //-------------------------------
        if(choze == 1)
        {
            do
            {    
                do  
                {
                    System.out.println("Red Player, choose  a column from 0-6");
                    int move = Re.nextInt();
                    to = ConnectFourGame.dropPiece(move, 4);
                    ConnectFourGame.draw();
                    if(to = false)
                    System.out.println("INVALID MOVE(You Nub!), Try Again");
                }while(to = false);
                
                if(ConnectFourGame.status() == 1 || ConnectFourGame.status() == 2 || ConnectFourGame.status() == 3)
                {
                    done = true;
                    System.out.println("GAME OVER!??!!.");
                    if(ConnectFourGame.status() == 1 )
                    {
                        System.out.println("RED WINS!");
                    }
                    if(ConnectFourGame.status() == 2 )
                    {
                        System.out.println("BLACK WINS!");
                    }
                    break;
                }
                do  
                {
                    System.out.println("Black Player, choose  a column from 0-6");
                    int move = Bl.nextInt();
                    to = ConnectFourGame.dropPiece(move, 5);
                    ConnectFourGame.draw();
                    if(to = false)
                    System.out.println("INVALID MOVE(You Nub!), Try Again");
                }while(to = false);
                if(ConnectFourGame.status() == 1 || ConnectFourGame.status() == 2 || ConnectFourGame.status() == 3)
                {
                    done = true;
                    System.out.println("GAME OVER!??!!.");
                    if(ConnectFourGame.status() == 1 )
                    {
                        System.out.println("RED WINS!");
                    }
                    if(ConnectFourGame.status() == 2 )
                    {
                        System.out.println("BLACK WINS!");
                    }
                }
            }while(done == false);
        }
        //-------------------------------
        if(choze == 0)
        {
            do
            {    
                lol = 0;
                do  
                {
                    System.out.println("player red, choose column 0-6");
                    int move = Re.nextInt();
                    to = ConnectFourGame.dropPiece(move, 4);
                    ConnectFourGame.draw();
                    if(to = false)
                    System.out.println("INVALID MOVE, TRY AGAIN");
                }while(to = false);
                if(ConnectFourGame.status() == 1 || ConnectFourGame.status() == 2 || ConnectFourGame.status() == 3)
                {
                    done = true;
                    System.out.println("GAME OVER!??!!.");
                    if(ConnectFourGame.status() == 1 )
                    {
                        System.out.println("RED WINS!");
                    }
                    if(ConnectFourGame.status() == 2 )
                    {
                        System.out.println("BLACK WINS!");
                    }
                    break;
                }
                //-------------------------------
                for(int r=0; r<=5;r++)
            {    
            for(int c=0; c<=3; c++)
            {
                 if(board[r][c] == 4 && board[r][c+1] == 4 && board[r][c+2] == 4 )
                {
                     ConnectFourGame.dropPiece(c+3, 5);
                     lol = 1;
                }
            }
            }
            for(int r=5; r>=2;r--)
            {    
            for(int c=0; c<=6; c++)
            {
                if(board[r][c] == 4 && board[r-1][c] == 4 &&  board[r-1][c] == board[r-2][c])
                {
                     ConnectFourGame.dropPiece(c, 5);
                     lol = 1;
                }
            }
            }
            //-------------------------------
            for(int r=5; r>=2;r--)
            {    
            for(int c=0; c<=3; c++)
            {
                 if(board[r][c] == 4 && board[r-1][c+1] == 4 && board[r-1][c+1] ==  board[r-2][c+2] )
                {
                     if(board[r-2][c+2] != 6){
                     ConnectFourGame.dropPiece(c+3, 5);
                     lol = 1;
                    }
                }
            }
            }
            //-------------------------------
            for(int r=5; r>=2;r--)
            {    
            for(int c=6; c>=3; c--)
            {
                if(board[r][c] == 4 && board[r-1][c-1] == 4 && board[r-2][c-2] == 4)
                {
                    if(board[r-2][c-2] != 6){
                    ConnectFourGame.dropPiece(c-3, 5);
                    lol = 1;
                }
                }
                }
            }
            //-------------------------------
                if(lol == 0){
                
                do  
                {
                    
                    int move = (int)(Math.random()*6);
                    to = ConnectFourGame.dropPiece(move, 5);
                    System.out.println("         ");
                    
                }while(to = false);
                if(ConnectFourGame.status() == 1 || ConnectFourGame.status() == 2 || ConnectFourGame.status() == 3)
                {
                    done = true;
                    System.out.println("GAME OVER!??!!.");
                    if(ConnectFourGame.status() == 1 )
                    {
                        System.out.println("Red WINS!");
                    }
                    if(ConnectFourGame.status() == 2 )
                    {
                        System.out.println("Black WINS!");
                    }
                }
            }
            System.out.println("");
            System.out.println("");
            System.out.println("");
            ConnectFourGame.draw();
            }while(done == false);
        }
    }
}



