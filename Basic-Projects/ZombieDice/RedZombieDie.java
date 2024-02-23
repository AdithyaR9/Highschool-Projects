public class RedZombieDie extends ZombieDie
{
   public RedZombieDie()
   {
       super(RED);
   }
   public void roll()
   {
       int roll = (int)(Math.random()*6);
       if(roll == 0 || roll == 1)
           super.setValue(RUNNER);
           else if(roll == 2)
               super.setValue(BRAIN);
               else if(roll == 3 || roll == 4 || roll == 5)
                   super.setValue(SHOT);
   }
}
