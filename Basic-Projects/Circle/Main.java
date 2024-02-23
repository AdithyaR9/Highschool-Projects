import java.util.Scanner;
class Main 
{
  public static void main(String[] args) 
  {
    Scanner scanner = new Scanner(System.in);
    double radius;
    
    System.out.println("---Circle Program---");
    System.out.print("\nEnter the radius: ");
    
    radius = scanner.nextDouble();
    
    double circumfrence = 2* Math.PI *radius;
    double area = Math.PI*(radius*radius); 
    
    System.out.print("\n\nCircle properties:\n");
    System.out.printf("Radius- %.3f\n",radius );
    System.out.printf("Circumference- %.3f\n",circumfrence );
    System.out.printf("Area- %.3f\n",area );
  }
}