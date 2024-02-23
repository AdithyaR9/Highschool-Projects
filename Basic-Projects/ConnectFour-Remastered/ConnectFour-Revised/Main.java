import java.util.Scanner;

public class Main
{
public static void main(String[] args)
{
ConnectFourGame game = new ConnectFourGame();

Scanner boi = new Scanner(System.in);
Scanner pick = new Scanner(System.in);

System.out.println(" Is Red a Human(1) or a CPU(2):?");
int player1 = boi.nextInt();

Player p1 = null;

if(player1 == 1)
{
System.out.println("Enter Player Name: ");

String name = pick.nextLine();
p1 = new HumanPlayer(name, 4);
}

else if(player1 == 2)
{
System.out.println("Enter CPU Name: ");

String name = pick.nextLine();
p1 = new ComputerPlayer(name, 4);
}

System.out.println("Is Black a Human(1) or a CPU(2):?");
int player2 = boi.nextInt();
Player p2 = null;

if(player2 == 1)
{
System.out.println("Enter Player Name: ");

String name = pick.nextLine();
p2 = new HumanPlayer(name, 4);
}

else if(player2 == 2)
{
System.out.println("Enter CPU Name: ");
String name = pick.nextLine();

p2 = new ComputerPlayer(name, 4);
}


while(game.status() == 0)
{
System.out.println("It's "+p1.getName()+" turn, Enter Column Number (0-6): ");

game.draw();
int p = p1.move(game);
game.dropPiece(p, 4);

if(game.status() == 1)
{
game.draw();
System.out.println(p1.getName() +" won!!??!.");

break;
}

System.out.println("It's "+p2.getName()+" turn, Enter Column Number (0-6): ");
game.draw();

game.dropPiece(p2.move(game), 5);

if(game.status() == 2)
{
game.draw();

System.out.println(p2.getName()+" won!!??!.");
break;
}

}

}

}
