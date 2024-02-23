import java.util.Scanner;
class Main 
{
  public static void main(String[] args) 
  {
    
    
    System.out.println("---Multiples---");
    Scanner yodaBoss = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int num = yodaBoss.nextInt();
    
   System.out.println("Enter the number of multiples you would like to see for the number " + num + " :"); 
   int multnum = yodaBoss.nextInt();
   int count = 0;
   String ans =  " ";
   for(int x = 0; x != multnum; x++)
   {
     count = num * (x + 1);
     if(x == multnum - 1)
     {
       ans += count;
     }
     else ans += count + ", ";
     
    
   }
    System.out.print("\nThe first " + multnum + " multiples of " + num + " are:" + ans);
   
  }
}