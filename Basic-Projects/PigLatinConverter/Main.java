import java.util.*;
 class Main 
{
      public static void main(String[] args) 
      {
        Scanner scan = new Scanner(System.in);
        System.out.println ("Enter a sentence: ");
        String sentence = scan.nextLine();
        System.out.println ("Your converted sentence is: "+convertSentence(sentence));
    }
    
    public static boolean isVowel(char c)
    {
    	String v = "AEIOUaeiou";
    	if(v.indexOf(c)>=0)
    		return true;
    	return false;
    }
    public static String convertSingleWord(String word)
    {
    	String output="";
    	if(isVowel(word.charAt(0)) && word.charAt(0) != 'y' && word.charAt(0) != 'Y')
    		output = word+"way";
    	else if(word.indexOf("qu") >= 0 || word.indexOf("QU") >= 0)
    	{
    		int num = word.indexOf('u');
    		output=  word.substring(num+1) + word.substring(0,word.indexOf('u')+1) + "ay";
    	}
    	else if(!isVowel(word.charAt(0))||word.charAt(0)=='y'||word.charAt(0)=='Y')
    	{
    		int x=0;
    		if(word.charAt(x)=='y' ||word.charAt(x)=='Y')
    			x=1;
    	   while(x<word.length()&&!isVowel(word.charAt(x)))
    	   {
    	   	  x++;
    	   }
    	   
    	   output+=word.substring(x)+word.substring(0,x)+"ay";
    	}
    	
    		
    		
    	return output;
    		
    	
    		
    }
    public static String convertSentence(String sentence)
    {
    	String output="";
    	String [] list = sentence.split(" ");
    	for(int i=0;i<list.length;i++)
    	{
    		if(i != list.length - 1)
    		{output+=convertSingleWord(list[i]) + " ";}
    		else
    		{output+=convertSingleWord(list[i]);}
    	}
    	return output;
    }
  
}