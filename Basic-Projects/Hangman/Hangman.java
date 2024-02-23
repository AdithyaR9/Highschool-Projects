import java.util.*;

public class Hangman
{
   public static final int MAX_GUESSES = 6;
    
    static int wrongGuesses;
   
   private static ArrayList<String> sentences = new ArrayList<String>();
    
    static String sentence;
    
   private static ArrayList<Character> vowels = new ArrayList<Character>();
   private static ArrayList<Character> consonants = new ArrayList<Character>();
   private static ArrayList<Character> guessed = new ArrayList<Character>();
   //--------------------------------------------------------------------------------------
   public static void setHangMan()
   {
       int wrongGuesses = 0;
       int xy = (int)(Math.random()*sentences.size());
       
       sentences.add("What is up?");
       sentences.add("Hello!");
       sentences.add("How are you?");
       sentences.add("What is your name?");
       sentences.add( "I am Bob");
       sentences.add("Eat your food!");
       sentences.add( "Clean you room!");
       sentences.add("Do your homework!");
       sentences.add("Do your chores");
       sentences.add("Be quiet!");
      
       sentence = sentences.get(xy);
       for(int x = 0; x <= sentence.length()-1; x++)
       {
           if(sentence.charAt(x) != ' ')
           {
               guessed.add('_');
           }
           else if(sentence.charAt(x) == ' ')
           {
               guessed.add(' ');
           }
       }
   }
   public static boolean won()
   {
       String test = "";
       for(int x1 = 0; x1 <= guessed.size()-1; x1++)
       {
           if(guessed.get(x1) != '_' && x1 == guessed.size()-1)
           {
               return true;
           }
           if(guessed.get(x1) == '_')
           {
               break;
           }
       }
       return false;
   }
   public static void printSentence()
   {
       String brachiosaurus = "";
       
       for(int x1 = 0; x1 <= guessed.size()-1; x1++)
       {
           brachiosaurus += guessed.get(x1); 
       }
       
       System.out.println(brachiosaurus);
   }
   public static int guessesLeft()
   {
       return 6 - wrongGuesses;
   }
   public static boolean addGuessedLetter(char c)
   {
       boolean stegasaurus = false;
       String abomidation = c + "  ";
       abomidation.toLowerCase();
       c = abomidation.charAt(0);
       for(int x2 = 0; x2 <= vowels.size()-1; x2++)
       {
           if(c == vowels.get(x2))
           {
               return false;
           }
       } 
       
       if(isVowel(c) == true)
           {
               vowels.add(c); 
           }
           
       for(int x3 = 0; x3 <= consonants.size()-1; x3++)
       {
           if(c == consonants.get(x3))
           {
               return false;
           }
       } 
       
       if(isVowel(c) == false)
           {
               consonants.add(c); 
           }
           
       for(int x4 = 0; x4 <= sentence.length()-1; x4++)
       {
           if(c == sentence.toLowerCase().charAt(x4))
           {
               guessed.set(x4, c);
           }
       }
       for(int x5 = 0; x5 <= sentence.length()-1; x5++)
       {
           if(c != sentence.charAt(x5))
           {
               stegasaurus = false;
           }
           if(c == sentence.charAt(x5))
           {
               stegasaurus = true;
               return true;
           }
       }
       
       if(stegasaurus == false)
       {
           wrongGuesses = wrongGuesses + 1;
       }
       return true;
   }
   
   public static void printGuessed()
   {
       System.out.println("guessed vowels:" + vowels);
       System.out.println("guessed consonants:" + consonants);
   }
   public static boolean isPunctuation(char c)
   {
       if(c == '!'  || c == ',' || c == '.' || c == '?' || c == ';' || c == ':' || c == '\'')   
       { 
           return true;
       }
       else
           return false;
   }
   public static boolean isInSentence()
   {
       for(int y = 0; y <= sentence.length()-1; y++)
       {
           if(sentence.toLowerCase().charAt(y) == guessed.get(y))
           {
               guessed.set(y, sentence.charAt(y));
               return true;
           }
       }
       return false;
   }
   public static boolean isVowel(char c)
   {
       if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
       {
           return true;
       }
       return false;
   }
}