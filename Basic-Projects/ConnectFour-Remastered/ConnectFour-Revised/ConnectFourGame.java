import java.util.Scanner;
public class ConnectFourGame
{
    public  static final int PLAYING = 0;
    public  static final int RED_WINS = 1;
    public  static final int BLACK_WINS = 2;
    public  static final int DRAW = 3;
    public  static final int RED = 4;
    public  static final int BLACK = 5;
    public  static final int EMPTY = 6;
    public static  int[][] board =  { {6,6,6,6,6,6,6},
                                       {6,6,6,6,6,6,6},
                                       {6,6,6,6,6,6,6},
                                       {6,6,6,6,6,6,6},
                                       {6,6,6,6,6,6,6},
                                       {6,6,6,6,6,6,6},    };
    
    
    public static  boolean dropPiece(int column, int player)
    {
        boolean valid = false;
        if(getSpot(column, 0) == -1)
        {
            return false;
        }
        if(Fcol(column) == true)
        {
            return false;
        }
        if(board[5][column] == 6)
        {
            valid = true;
            if(valid == true)
            {
                if(player == 4)
                {
                    board[5][column] = 4;
                }
                if(player == 5)
                {
                    board[5][column] = 5;
                }
                return true;
            }
            }
        else if(board[5][column] == 6)
        {
            valid = true;
            if(valid == true)
                {
                if(player == 4)
                {
                    board[5][column] = 4;
                }
                if(player == 5)
                    {
                        board[5][column] = 5;
                    }
                    return true;
                }
            }
            else if(board[4][column] == 6)
            {
                valid = true;
                if(valid == true)
                {
                    if(player == 4)
                    {
                        board[4][column] = 4;
                    }
                    if(player == 5)
                    {
                        board[4][column] = 5;
                    }
                    return true;
                }
            }
            else if(board[3][column] == 6)
            {
                valid = true;
                if(valid == true)
                {
                    if(player == 4)
                    {
                        board[3][column] = 4;
                    }
                    if(player == 5)
                    {
                        board[3][column] = 5;
                    }
                    return true;
                }
            }else if(board[2][column] == 6)
            {
                valid = true;
                if(valid == true)
                {
                    if(player == 4)
                    {
                        board[2][column] = 4;
                    }
                    if(player == 5)
                    {
                        board[2][column] = 5;
                    }
                    return true;
                }
            }
            else if(board[1][column] == 6)
            {
                valid = true;
                if(valid == true)
                {
                    if(player == 4)
                    {
                        board[1][column] = 4;
                    }
                    if(player == 5)
                    {
                        board[1][column] = 5;
                    }
                    return true;
                }
            }
            else if(board[0][column] == 6)
            {
                valid = true;
                if(valid == true)
                {
                    if(player == 4)
                    {
                        board[0][column] = 4;
                    }
                    if(player == 5)
                    {
                        board[0][column] = 5;
                    }
                    return true;
                }
            }
        return valid;
    }
    public static  int status()
    {
        
       int result = 0;
       
        for(int r=0; r<=5;r++)
            {    
            for(int c=0; c<=3; c++)
            {
                if(board[r][c] == RED && board[r][c+1] == RED && board[r][c+2] == RED && board[r][c+3] == RED)
                {
                    result = RED_WINS;
                }
                else if(board[r][c] == BLACK && board[r][c+1] == BLACK && board[r][c+2] == BLACK && board[r][c+3] == BLACK)
                {
                    result = BLACK_WINS;
                }
            }
        }
        for(int r=0; r<=2;r++)
            {    
            for(int c=0; c<=6; c++)
            {
                if(board[r][c] == RED && board[r+1][c] == RED&& board[r+2][c] == RED && board[r+3][c] == RED)
                {
                    result = RED_WINS;
                }
                else if(board[r][c] == BLACK && board[r+1][c] == BLACK && board[r+2][c] == BLACK && board[r+3][c] == BLACK)
                {
                    result = BLACK_WINS;
                }
            }
        }
        for(int r=5; r>=2;r--)
            {    
            for(int c=0; c<=3; c++)
            {
                if(board[r][c] == RED && board[r-1][c+1] == RED&& board[r-2][c+2] == RED && board[r-3][c+3] == RED)
                {
                    result = RED_WINS;
                }
                else if(board[r][c] == BLACK && board[r-1][c+1] == BLACK && board[r-2][c+2] == BLACK && board[r-3][c+3] == BLACK)
                {
                    result = BLACK_WINS;
                }
            }
        }
        for(int r=5; r>=2;r--)
            {    
            for(int c=6; c>=3; c--)
            {
                if(board[r][c] == RED && board[r-1][c-1] == RED&& board[r-2][c-2] == RED && board[r-3][c-3] == RED)
                {
                    result = RED_WINS;
                }
                else if(board[r][c] == BLACK && board[r-1][c-1] == BLACK && board[r-2][c-2] == BLACK && board[r-3][c-3] == BLACK)
                {
                    result = BLACK_WINS;
                }
            }
        }
        return result;
    }
    
    public static  boolean Fcol(int column)
    {
        boolean full = false;
        if(board[5][column] != 6)
        {
            if(board[4][column] != 6)
            {
                if(board[3][column] != 6)
                {
                    if(board[2][column] != 6)
                    {
                        if(board[1][column] != 6)
                        {
                            if(board[0][column] != 6)
                            {   
                                full = true;
                            }
                        }
                    }
                }
            }
        }

        return full;
    }
    public static  void draw()
    {
        int count = 0;
        for(int[] x: board)
        {
            for(int y: x)
            {
                System.out.print("|");
                count++;
                if(y == 4)
                {
                    System.out.print("R");
                }
                if(y == 5)
                {
                    System.out.print("B");
                }
                if(y == 6)
                {
                    System.out.print(" ");
                }
                if(count == 7)
                {
                    System.out.print("|\n");
                    count = 0;
                }
            }
        }
    }
    public static  int getSpot(int col, int row)
    {
        if(col >= 0 && col <= 6)
        {
            if(row >= 0 && row <= 5)
            {
                return board[row][col];
            }
            else
            return -1;
        }
        return -1;
    }
}
