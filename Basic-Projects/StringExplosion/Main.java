import java.util.Scanner;

public class Main
 {
    public static void main(String[] args)
     {
        Scanner bobi = new Scanner(System.in);
        System.out.println("Enter a sentence: ");
        String convert = bobi.nextLine();
        
        System.out.println(convertSentence(convert));
     }
    public static String convertSentence(String sentence)
    {
        String[] sentencee = sentence.split(" ");
        String makeSentencee = "";
        for(int x = 0; x < sentencee.length; x++)
         {
            if(sentencee[x].length() % 2 == 0)
             {
               if(x != sentencee.length - 1)
                {makeSentencee += convertEvenWord(sentencee[x]) + " ";}
                else
                {
                  makeSentencee += convertEvenWord(sentencee[x]);
                }
             }
            else if(sentencee[x].length() % 2 == 1)
             {
if(x != sentencee.length - 1)
                {makeSentencee += convertOddWord(sentencee[x]) + " ";}
                else
                {
                  makeSentencee += convertOddWord(sentencee[x]);
                }
             }
         }
        return makeSentencee;
    }
    public static String convertEvenWord(String word)
    {
        if(word.length() == 2)
         {
            return word.toUpperCase();
         }
        else if(word.length() == 4)
         {
            return "****";
         }
        else if(word.length() == 6)
         {
            char flip0 = word.charAt(0);
            char flip5 = word.charAt(5);
            char flip2 = word.charAt(2);
            char flip3 = word.charAt(3);
         
         String flipWord  = "" + flip5 + word.charAt(1) + flip3 + flip2 + word.charAt(4) + flip0 + "";
            return flipWord;
            
         }
        else if(word.length() >= 8)
         {
            return word.substring(0,word.length()/2) + " " + word.substring(word.length()/2);
         }
        else
        return "-1 (You Failed!)";
        
    } 
    public static String convertOddWord(String word)
    {
        
        String lowerCase= "abcdefghijklmnopqrstuvwxyz";
        String upperCase = lowerCase.toUpperCase();
        
        if(word.length() == 1)
        {
            return "%";
        }
        else if(word.length() == 3)
        {
            return "<" + word.charAt(1) + ">";
        }
        else if(word.length() == 5)
        {
            String makeWorde = "";
            
            for(int x = 0; x < word.length(); x++)
            {
                String oppoCase = word.charAt(x) + "";
                if(lowerCase.contains(oppoCase))
                {
                    makeWorde += oppoCase.toUpperCase();
                   
                }
                else if(upperCase.contains(oppoCase))
                {
                    makeWorde += oppoCase.toLowerCase();
            }
          }
          return makeWorde;
        }
        else if(word.length() >= 7)
        {
            String makeWorde = "";
            
            for(int x = 0; x<word.length(); x+=2)
            {
                makeWorde += word.charAt(x);
            }
            return makeWorde;
        }
        else
        {
        return "-1 (You Failed!)";
        }
    }
 }

