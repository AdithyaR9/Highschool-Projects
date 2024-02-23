import java.util.Scanner;

class Main 
{
 
 
//-------------------------------------------------------------------------------
  public static void main(String[] args) 
  {
    // This code will use Scanner and println
    // It will also call all the other methods.
    
    Scanner cool= new Scanner(System.in);
    String sentencee;
    
    System.out.println("Enter your sentence: ");
    sentencee = cool.nextLine();
    
     consonantCount(sentencee);
     vowelCount(sentencee);
     punctuationCount(sentencee);
     wordCount(sentencee);
     
     int characterCount = sentencee.length();
    
    System.out.println("Your sentence has " + wordCount(sentencee) + " word(s)!");
    System.out.println("Your sentence has " + characterCount + " character(s)! (including spaces)");
    System.out.println("Your sentence has " + vowelCount(sentencee) + " vowelcharacter(s)!");
    System.out.println("Your sentence has " + consonantCount(sentencee) + " consonant(s)!");
     
   
    
    
  }
  public boolean isVowel(char letter)
  {
     char [] vowels = {'A','E','I','O','U','a','e','i','o','u'};
     
    for(int x = 0; x < vowels.length; x++)
    { 
      if(letter == vowels[x])
      {return true;}
    }
    return false;
  }
  
   public boolean isConsonant(char letter)
  {
    char [] consonants = {'B','C','D','F','G','H','J','K','L','M','N','P','Q','R','S','T','V','W','X','Y','Z','b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
   
    for(int y = 0; y < consonants.length; y++)
    { 
      if(letter == consonants[y])
      {return true;}
    }
    return false;
  }
  
   public boolean isPunctuation(char letter)
  {
    char [] punctuations = {'!',',','.','?',';',':'};
    
    for(int z = 0; z < punctuations.length; z++)
    { 
      if(letter == punctuations[z])
      {return true;}
    }
    return false;
  }
  
  public static int consonantCount(String sentence)
  {
    int consonantCounter = 0;
    char v1 = 'a';
    char v2 = 'e';
    char v3 = 'i';
    char v4 = 'o';
    char v5 = 'u';
    char vV1 = 'A';
    char vV2 = 'E';
    char vV3 = 'I';
    char vV4 = 'O';
    char vV5 = 'U';
    
    char p1 = '!';
    char p2 = ',';
    char p3 = '.';
    char p4 = '?';
    char p5 = ';';
    char p6 = ':';
    char spaces = ' ';
    for(int b = 0; b < sentence.length(); b++ )
    {
    if(sentence.charAt(b) != v1)
      if(sentence.charAt(b) != v2)
        if(sentence.charAt(b) != v3)
          if(sentence.charAt(b) != v4)
            if(sentence.charAt(b) != v5)
              if(sentence.charAt(b) != vV1)
                if(sentence.charAt(b) != vV2)
                  if(sentence.charAt(b) != vV3)
                    if(sentence.charAt(b) != vV4)
                      if(sentence.charAt(b) != vV5)
                        if(sentence.charAt(b)!= p1)
                          if(sentence.charAt(b)!= p2) 
                            if(sentence.charAt(b)!= p3)
                              if(sentence.charAt(b)!= p4)
                                if(sentence.charAt(b)!= p5)
                                  if(sentence.charAt(b)!= p6)
                                    if(sentence.charAt(b)!= spaces)
                        consonantCounter++;
    }
    return consonantCounter;
  }
  
   public static int vowelCount(String sentence)
  {
    int vowelCounter = 0;
    char v1 = 'a';
    char v2 = 'e';
    char v3 = 'i';
    char v4 = 'o';
    char v5 = 'u';
    char vV1 = 'A';
    char vV2 = 'E';
    char vV3 = 'I';
    char vV4 = 'O';
    char vV5 = 'U';
   
    for(int a = 0; a < sentence.length(); a++ )
    {
      if(sentence.charAt(a) == v1)
      {vowelCounter++;}
      if(sentence.charAt(a) == v2)
      {vowelCounter++;}
      if(sentence.charAt(a) == v3)
      {vowelCounter++;}
      if(sentence.charAt(a) == v4)
      {vowelCounter++;}
      if(sentence.charAt(a) == v5)
      {vowelCounter++;}
      if(sentence.charAt(a) == vV1)
      {vowelCounter++;}
      if(sentence.charAt(a) == vV2)
      {vowelCounter++;}
      if(sentence.charAt(a) == vV3)
      {vowelCounter++;}
      if(sentence.charAt(a) == vV4)
      {vowelCounter++;}
      if(sentence.charAt(a) == vV5)
      {vowelCounter++;}
    }
     return vowelCounter;
  }
  
   public static int punctuationCount(String sentence)
  {
    int punctuationCounter = 0;
    char p1 = '!';
    char p2 = ',';
    char p3 = '.';
    char p4 = '?';
    char p5 = ';';
    char p6 = ':';
   
    for(int c = 0; c < sentence.length(); c++ )
    {
       if(sentence.charAt(c) == p1)
      {punctuationCounter++;}
      if(sentence.charAt(c) == p2)
      {punctuationCounter++;}
      if(sentence.charAt(c) == p3)
      {punctuationCounter++;}
      if(sentence.charAt(c) == p4)
      {punctuationCounter++;}
      if(sentence.charAt(c) == p5)
      {punctuationCounter++;}
      if(sentence.charAt(c) == p6)
      {punctuationCounter++;}
    }
    return punctuationCounter;
  }
  
   public static int wordCount(String sentence)
  {
     int wordCounter = 1;
     char space = ' ';
    
    for(int d = 0; d < sentence.length(); d++ )
    {
      if(sentence.charAt(d) == space)
      {wordCounter++;}
    }
    return wordCounter;
  }
  
}