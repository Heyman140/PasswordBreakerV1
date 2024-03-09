import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class PBreaker {
	public static void main(String[] args) {
		ArrayList<String> Alphabet = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
		ArrayList<String> WordCorrect = new ArrayList<String>(); //this is where the correct letters will go
		ArrayList<String> PasswordArray = new ArrayList<String>();
		ArrayList<String> WordMade = new ArrayList<String>();
		
		int attempts = 0;
		String Password = "bob";
		String WordGuess = "";
		String CorrectWord = "";
		boolean isCorrect = false;
		int sizeMax = Alphabet.size();
		
		Random rand = new Random();
		
		//sets up the PasswordArray
		for (int i = 0; i < Password.length(); i++)
		{
			if ((Password.length() - 1) == i)
			{
				PasswordArray.add(Password.substring(i));
				//System.out.println(Password.substring(i));
			}
			else 
			{
				PasswordArray.add(Password.substring(i, i+1));
				//System.out.println(Password.substring(i, i+1));
			}
				
		}
		
		//sets up the "nulls" in WordMade
		for (int i = 0; i < PasswordArray.size(); i++)
		{
			WordCorrect.add("Null");
			WordMade.add("Null");
		}
		//each time a letter is guessed correctly, the null in that index where the password letter is located
		
		//create the while loop designed to get the random letter via random number and compare it with the password
		
		System.out.println("Program starting: Cracking in process!");
		
		while(isCorrect == false)
		{
			for (int i = 0; i < PasswordArray.size(); i++)
			{
				String letter = Alphabet.get(rand.nextInt(sizeMax));
				
				WordGuess = WordGuess + letter;
				
				WordMade.set(i, letter);
			}
			
			for (int i = 0; i < PasswordArray.size(); i++)
			{
				if ((WordCorrect.get(i)).equals(PasswordArray.get(i))) //only checks to see if correct value is within the arrays 
				{
					continue;
				}
				else
				{
					if (WordMade.get(i).equals(PasswordArray.get(i)))
					{
						WordCorrect.set(i, WordMade.get(i));
					}
				}
			}
			
			for (String i : WordCorrect)
			{
				CorrectWord += i;
			}
			
			if (CorrectWord.equals(Password))
			{
				isCorrect = true;
			}
			else
			{
				CorrectWord = "";
			}
			
			WordGuess = "";
			
			attempts++;
			
			System.out.println("Attempt " + attempts);
		}
		
		//should appear if the password is cracked
		System.out.println("Password cracked\nPassword: " + Password + "\nAttempts: " + attempts);
	}

}
