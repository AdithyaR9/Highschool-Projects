import java.util.*;
public class ZombieDiceBucket
{
   private ArrayList<ZombieDie> bucket;
   public ZombieDiceBucket()
   {
       bucket = new ArrayList<ZombieDie>();   
   }
   public void loadBucket()
   {
       bucket.clear();
       for(int x=0;x<6;x++)
           bucket.add(new GreenZombieDie());
       for(int x=0;x<4;x++)
           bucket.add(new YellowZombieDie());
       for(int x=0;x<3;x++)
           bucket.add(new RedZombieDie());
   }
   public ZombieDie draw()
   {
       if(bucket.isEmpty())
       {
           return null;
       }
       return bucket.remove((int)(Math.random()*bucket.size()));
   }
}
