public class ComputerPlayer extends Player
{
  public ComputerPlayer(String name, int color)
  {
    super(name, color);
	  this.name = name;		
    this.color = color;

  }

  public int move(ConnectFourGame game)
    {
        int answer = (int)(Math.random()*6);
   
        do {
           
           if(ConnectFourGame.dropPiece(answer, 0) == true)
              answer = answer;
        }while(ConnectFourGame.dropPiece(answer, 0) == false);
        
        System.out.println("CPU picked column" + answer );

        return answer;
    }
}