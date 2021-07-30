import java.util.Scanner;
class Main 
{
  public static void main(String[] args) 
  {
     Scanner boi = new Scanner(System.in); 
     String name;
     
     System.out.print("Enter Your Name");
     name = boi.next();
     System.out.print("Hello "+ name + "!");
  }
}