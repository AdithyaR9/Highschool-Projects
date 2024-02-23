import java.util.Scanner;
class Main
{
  public static void main(String[] args)
  {
    Scanner boi = new Scanner(System.in);
    
    MazeGame maze = new MazeGame();
    
    while(!maze.won())
    {
      maze.draw();
      
      System.out.println("Choose a direction to move: ");
      System.out.println("'w'- up,'s'- down,'a'- left,'d'- right");   
      
      char poxi = boi.next().charAt(0);
      maze.move(poxi);
      
    }
      System.out.println("You won the Game!!! \nYou beat it in "+ maze.getMoveCount() + " moves!!(Do it in less moves; Come on man you can do better!)");
    }
  }

