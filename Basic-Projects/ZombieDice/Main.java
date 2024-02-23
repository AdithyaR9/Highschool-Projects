import java.util.*;
public class Main
{
   public static void main(String[] args)
   {
       Scanner keyboard = new Scanner(System.in);
       System.out.print("Number of Players (2-5): ");
       int play=keyboard.nextInt();
       String[] names= new String[play];
       int[] scores= new int[play];
       int turn=0;
       ZombieDiceBucket bucket=new ZombieDiceBucket();
       ArrayList<ZombieDie> hand= new ArrayList<ZombieDie>();
       ArrayList<ZombieDie> brains= new ArrayList<ZombieDie>();
       ArrayList<ZombieDie> shots= new ArrayList<ZombieDie>();
       ArrayList<ZombieDie> runners= new ArrayList<ZombieDie>();

       for(int x = 0; x < play; x++)
       {
           System.out.print("Player Name "+(x+1)+":");
           String player = keyboard.next();
           names[x] = player;
       }
       shuffleNames(names);
       do
       {
           System.out.println("\n"+names[turn]+" it is your turn and you have "+scores[turn]+" brains in your bank.");
           System.out.println("---Turn Summary---");
           System.out.println("   Brains:  "+ brains);
           System.out.println("   Shots:   "+  shots);
           System.out.println("   Runners: "+runners);
           System.out.println("1.Keep Going");
           System.out.println("2.Stop & add money to bank");

           int selection = keyboard.nextInt();
           if(selection==1)
           {
               for(int x = runners.size()-1; x > -1; x--)
               {
                   runners.get(x).setValue(0);
                   hand.add(runners.remove(x));
               }
               while (hand.size() < 3)
               {
                   ZombieDie zombie = bucket.draw();
                   if(zombie==null)
                   {
                       bucket.loadBucket();
                   }
                   else
                   {
                       hand.add(zombie);
                   }
               }
               System.out.print("\nRolling");
               for(int x=0;x<3;x++)
               {
                   try
                   {
                       Thread.sleep(450);
                   }
                   catch(Exception e)
                   {
                      
                   }
                   System.out.print(".");
               }
               System.out.println("\nAfter drawing you have the following dice: "+hand);
               for(int x = 0; x < hand.size(); x++)
               {
                   hand.get(x).roll();
                   if(hand.get(x).getValue()== 1)
                       runners.add(hand.get(x));
                   else if(hand.get(x).getValue()== 2)
                       brains.add(hand.get(x));
                   else if(hand.get(x).getValue()== 3)
                       shots.add(hand.get(x));
               }
               System.out.println("The results of your rolls were: "+hand);
               hand.clear();
               if(shots.size()>=3)
               {
                   System.out.println("You lost all your brains you earned.");
                   hand.clear();
                   brains.clear(); 
                   shots.clear();
                   runners.clear();
                   if(turn<names.length-1)
                       turn++;
                   else
                       turn = 0;
               }
           }
           if(selection==2)
           {
               scores[turn] += brains.size();
               System.out.println("\nYou ate "+brains.size()+" brains this turn giving you "+scores[turn]+" brains now in your bank");
               brains.clear();
               shots.clear();
               runners.clear();
               if(turn<names.length-1)
                   turn++;
               else
                   turn = 0;
           }
       }while(findWinner(names,scores) ==null);   
       
       System.out.println("The winner is "+findWinner(names,scores));
   }
   public static void shuffleNames(String[] names)
   {
       for(int n=0;n<names.length;n++)
       {
           int r=(int)(Math.random()*names.length);
           String b=names[r];
           names[r]=names[n];
           names[n]=b;
       }  
   }
   public static String findWinner(String[] names, int[] scores)
   {
       String winner="";
       for(int n=0;n<names.length;n++)
       {
           if(scores[n]>=13)
           {
               winner=names[n];
               return winner;
           }
       }
       return null;
   }
}







