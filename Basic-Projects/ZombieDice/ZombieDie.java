public abstract class ZombieDie
{
   public static final int NOT_ROLLED = 0;
   public static final int RUNNER = 1;
   public static final int BRAIN = 2;
   public static final int SHOT = 3;
   public static final int RED = 1;
   public static final int GREEN = 2;
   public static final int YELLOW = 3;
   private int dieColor;
   private int value;
   public ZombieDie(int dieColor)
   {
       this.dieColor = dieColor;
       value = NOT_ROLLED;
   }
   public int getValue()
   {
       return value;
   }
   public int getDieColor()
   {
       return dieColor;
   }
   public void setDieColor(int dieColor)
   {
       this.dieColor = dieColor;
   }
   public void setValue(int value)
   {
       this.value = value;
   }
   public String toString()
   {
       String text = "";
  if(dieColor == 1)
    text += "Red";
  else if(dieColor == 2)
    text += "Green";
  else if(dieColor == 3)
    text += "Yellow";
  if(value == 1)
    text += "-" + "Runner";
  else if(value == 2)
    text += "-" + "brain";
  else if(value == 3)
    text += "-" + "Shot";
  return text;
   }
   public abstract void roll();
}

