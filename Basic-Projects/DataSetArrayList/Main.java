import java.util.ArrayList;
import java.util.Scanner;


class Main 
{
  static ArrayList<Integer> dataSet = new ArrayList<Integer>();
  static boolean b = true;
  public static void main(String[] args) 
  {
    
    while(b == true){
     Scanner bobi = new Scanner(System.in);
     System.out.println(" To Add Value Press 1 \n To Change value Press 2 \n To Insert Value Press 3 \n To Get Index Press 4 \n To Get Size Press 5 \n To Print Press 6 \n To Total Press 7 \n To Average Press 8 \n To Remove a Value Press 9 \n To Remove a Location Press 10 \n To Clear Press 11 \n To Exit Press 12");
     int selections = bobi.nextInt();
   
   //------------------------------------------------------------
    
    if(selections == 1)
    {
      Scanner bobia = new Scanner(System.in);
      System.out.println("Enter the value you want to add (dont add 0)");
      int x = bobia.nextInt();
      
      add(x);
    }
    
    if(selections == 2)
    {
       Scanner bobib = new Scanner(System.in);
      System.out.println("Enter the value you want to change the index to.");
      int x2 = bobib.nextInt();
      
       System.out.println("Enter the index you want to change.");
      int y = bobib.nextInt();
      
      change(x2,y);
    }
    
    if(selections == 3)
    {
      Scanner bobic = new Scanner(System.in);
      System.out.println("Enter the value you want to insert.");
      int x3 = bobic.nextInt();
      
      System.out.println("Enter the index you want to insert the value at.");
      int y2 = bobic.nextInt();
      
      insert(x3,y2);
    }
    
    if(selections == 4)
    {
       Scanner bobid = new Scanner(System.in);
      System.out.println("Enter the index you want the value of.");
      int x4 = bobid.nextInt();
      
      getIndex(x4);
    }
    
    if(selections == 5)
    {
      getSize();
    }
    
    if(selections == 6)
    {
      print(); 
    }
    
    if(selections == 7)
    {
      total();
    }
    
    if(selections == 8)
    {
      average();
    }
    
    if(selections == 9)
    {
      Scanner bobie = new Scanner(System.in);
      System.out.println("Enter the value you want to remove.");
      int x5 = bobie.nextInt();
      
      removeValue(x5);
    }
    
    if(selections == 10)
    {
       Scanner bobif = new Scanner(System.in);
      System.out.println("Enter the location you want to remove.");
      int x6 = bobif.nextInt();
      
      removeLocation(x6);
    }
    
    if(selections == 11)
    {
      dataSet.clear();
      System.out.println("ArrayList cleared. (:|)! ");
    }
    
    if(selections == 12)
    {
      System.out.println("Program Ended/Exited");
      b = false;
    }
    }
    
    
    
  }
  
  //---------------------------------------------------------------------------------
  
  public static void add(int x)
  {
    if(x != 0)
    {
      dataSet.add(x);
    }
    
  }
  
  public static void change(int x, int index)
  {
    if(index < dataSet.size())
    {
      dataSet.set(index,x);
    }
    else System.out.println("Sorry,Index is Invalid(Don't be a noob).");
  }
  
  public static void insert(int x, int index)
  {
    if(index < dataSet.size())
    {
      dataSet.add(index,x);
    }
    else System.out.println("Sorry,Index is Invalid(Don't be a noob).");
  }
  
  public static void getIndex(int index)
  {
    if(index < dataSet.size())
    {
      System.out.println(dataSet.get(index));
    }
    else System.out.println("Sorry,Index is Invalid(Don't be a noob).");
  }
  
  public static void getSize()
  {
    System.out.println(dataSet.size());
  }
  
  public static void print()
  {
    for(int x = 0; x < dataSet.size(); x++) 
    {
      System.out.println(dataSet.get(x));
    }
  }
  
  public static void total()
  {
    int totals = 0;
    for(int x = 0; x < dataSet.size(); x++) 
    {
      totals += dataSet.get(x);
    }
    System.out.println(totals);
  }
  
   public static void average()
  {
    double averageTotal = 0;
    for(int x = 0; x < dataSet.size(); x++) 
    {
      averageTotal += dataSet.get(x);
    }
    System.out.println(averageTotal / dataSet.size() );
  }
  
  public static void removeValue(int x)
  {
    boolean removeSuccess = false;
    for(int y = dataSet.size() - 1 ; y <= 0; y--) 
    {
      if(dataSet.get(y) == x)
      {
        System.out.println(dataSet.remove(y));
        removeSuccess = true;
        break;
      }
    }
    
    if(removeSuccess == false)
      {System.out.println("value not found(thats unfortunate!?!)");}
       else if(removeSuccess == true)
      {System.out.println("Congratulations, Remove Successful");}
  }
  
  public static void removeLocation(int index)
  {
     if(index < dataSet.size())
     {
     System.out.println(dataSet.remove(index));
     }
     else System.out.println("Sorry,Index is Invalid(Don't be a noob).");
  }
  
}