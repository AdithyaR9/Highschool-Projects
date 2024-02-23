import java.util.Scanner;
class Main
{
  public static void main(String[] args) 
  {
    Scanner scanner = new Scanner (System.in);
    
    System.out.print("Enter the number of students that are in your class:");
    double classStrength = scanner.nextDouble();
    System.out.print("Enter your rank");
    double rank = scanner.nextDouble();
    
    System.out.printf("You are in the top %.2f \n", rank / classStrength * 100);
    System.out.print("% of your class.");
    
    
  }
}