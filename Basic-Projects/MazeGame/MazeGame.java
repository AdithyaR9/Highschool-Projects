public class MazeGame
{
   
  public char[][] maze = {{'S','-','W','-','-','W'},
                          {'-','W','-','-','-','W'},
                          {'-','-','-','W','-','-'},
                          {'W','-','-','-','-','W'},
                         	{'-','-','-','W','-','-'},
                        	{'W','W','W','-','-','W'},
                       		{'E','-','-','-','W','-'}};
  private int playerColumn;
  private int playerRow;
  private int moveCount;
  
  public MazeGame()
  {
    for(int x = 0; x < maze.length; x++)
    {
      for(int y = 0; y < maze[x].length; y++)
      {
        if(maze[x][y] == 'S')
        {
          playerRow = x;
          playerColumn = y;
          break;
        }
      }
    }
  }
  public boolean won()
  {
    if(maze[playerRow][playerColumn] == 'E')
    {
      return true;
    }
    return false;
  }
  public int getMoveCount()
  {
    return moveCount;
  }
  public boolean move(char direction)
  {
      if(direction == 'w')
      {
          if(maze[playerRow - 1][playerColumn] == '-' || maze[playerRow - 1][playerColumn] == 'E')
          {
              moveCount++;
              playerRow--;
              return true;
          }
          return false;
      }
      
      if(direction == 'a')
      {
          if(maze[playerRow][playerColumn - 1] == '-' || maze[playerRow][playerColumn - 1] == 'E')
          {
            moveCount++;
            playerColumn--;
            return true;
          }
          return false;
      }
      
      if(direction == 's')
      {
          if(maze[playerRow + 1][playerColumn] == '-' || maze[playerRow + 1][playerColumn] == 'E')
          {
            moveCount++;
            playerRow++;
            return true;
          }
          return false;
      }
      
      if(direction == 'd')
      {
          if(maze[playerRow][playerColumn + 1] == '-' || maze[playerRow][playerColumn + 1] == 'E')
          {
            moveCount++;
            playerColumn++;
            return true;
          }
          return false;
      }
      return false;
  }
  
  public void draw()
  {
      for(int x = 0; x < maze.length; x++)
      {
          for(int y = 0; y < maze[x].length; y++)
          {
              if(x == playerRow && y == playerColumn)
              {
                  System.out.print("X");
                  continue;
              }
              System.out.print(maze[x][y] + " ");
          }
          System.out.println();
      }
  }
}
