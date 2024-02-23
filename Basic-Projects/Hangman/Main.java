import java.util.*;

class Main
{
   public static void main(String[] args)
   {
       Hangman.setHangMan();
       Hangman.printSentence();
       System.out.println(Hangman.guessesLeft());
       boolean boi = false;
       Hangman.printGuessed();
       Scanner scanner = new Scanner(System.in);
       do
       {
           do  
           {
               System.out.println("Enter your guess:");
               char petGirraffie = scanner.next().charAt(0);
               
               boi = Hangman.addGuessedLetter(petGirraffie);
               
               if(boi == false)
               {
                   System.out.println("Invalid option boi!, try again");
               
               }
               
           }while(boi == false);
           
           Hangman.isInSentence();
           Hangman.printSentence();
           
           System.out.println("Boi Yu have "+Hangman.guessesLeft()+" wrong guesses left");;
           
           Hangman.printGuessed();
           
           if(Hangman.guessesLeft() == 0)
           {
               System.out.println("Yu Lost (What a looser!)(:-()");
               System.out.println("The sentence was" + Hangman.sentence);
               break;
           }
           
           if(Hangman.won() == true)
           {
               System.out.println("Congrats you can say the alphabet(You Win)");
               break;
           }
           
       }while(Hangman.won() == false);
   }
}