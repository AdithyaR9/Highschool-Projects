public class YellowZombieDie extends ZombieDie
{
   public YellowZombieDie()
   {
       super(YELLOW);
   }
   public void roll()
   {
       int roll = (int)(Math.random()*6);
       if(roll == 0 || roll == 1)
           super.setValue(RUNNER);
           else if(roll == 2 || roll == 3)
               super.setValue(BRAIN);
               else if(roll == 4 || roll == 5)
                   super.setValue(SHOT);
   }
}
