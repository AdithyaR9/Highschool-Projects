import java.util.Scanner;
public class HumanPlayer extends Player
{
  public HumanPlayer(String name, int color)
  {
    super(name, color);
    this.name = name;		
    this.color = color;
  }

   public int move(ConnectFourGame game)
    {
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        
        do {
        if(ConnectFourGame.dropPiece(num, 0) == false)
        {
         System.out.println("IVALID MovE.?!!?. Enter Column Number (0-6): ");
        num = sc.nextInt();
        }
        else 
        {
        num = num;
        }
        }while(ConnectFourGame.dropPiece(num, 0) == false);
        
        return num;
    }
}
