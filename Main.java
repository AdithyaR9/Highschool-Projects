import java.util.Scanner;
class Main 
{
  public static void main(String[] args) 
  {
     Scanner scanner = new Scanner(System.in); 
     String name;
     
     System.out.print("Enter Your Name");
     name = scanner.next();
     System.out.print("Hello "+ name + "!");
  }
}
