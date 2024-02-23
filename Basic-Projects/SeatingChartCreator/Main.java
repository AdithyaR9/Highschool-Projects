import java.util.*;



class Main 
{
  public static void main(String[] args)
    {
        Scanner boi = new Scanner(System.in);
        String name;
        int students;
        ArrayList<String> names = new ArrayList<String>();
        System.out.println("Type each students name on a different line, type \"Done\" when finished.");
        
        //----------------------------------------------------------
        
        do
        {           
           name = boi.nextLine();
           if(name.equals("Done") || name.equals("DONE") || name.equals("done"))
           {
               break;
           }
           else
           {
               names.add(name);
           }
        }while(true);
        
        System.out.println(" ");
        System.out.print("Enter the number of seats in your classroom: ");
        students = boi.nextInt();
        
        if(students < names.size())
            System.out.print("\nError there are not enough seats in your classroom.\n\n\n   Program Finished \n");
        
        else
        {
            System.out.print("\n\nThe seating chart is: ");
            System.out.print("\nName                   Seat Number");
            ArrayList<Integer> seats = new ArrayList<Integer>();
            for(int i = 0;i< students;i++)
            {
               seats.add(i);
            }
            for(int i = 0;i < names.size(); i++)
            {
                System.out.printf("\n%-10s    %10d",names.get(i),randomSeat(seats) + 1);  
            }
            System.out.println("\n\n Program Finished(Yayyyyyyy!).");
            
        }
    }
    public static int randomSeat(ArrayList<Integer> seats)
    {
        int seatNum = (int)(Math.random()*seats.size());
        return seats.remove(seatNum);
    }
}