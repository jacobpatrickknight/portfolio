import java.util.HashMap;

/**
 * 
 * @author Jacob Knight
 * Counts every instance of a letter in a list of words
 */
public class Counter 
{
	public static void main(String[] args) 
	{
		String[] words = {"andy", "ben", "Anderson", "zulu", "Cassidy", "wendy"};
		HashMap<Character, Integer> letterCount = new HashMap<Character, Integer>();
		
		for (char letter = 'a'; letter <= 'z'; letter++)
			letterCount.put(letter, 0);
		
		char firstLetter;
		for (int i = 0; i < words.length; i++)
		{
			firstLetter = words[i].toLowerCase().charAt(0);
			if (letterCount.containsKey(firstLetter))
			{
				int value = letterCount.get(firstLetter) + 1;
				letterCount.put(firstLetter, value);
			}
		}
		
		//System.out.println(letterCount.entrySet());
		for (char letter = 'a'; letter <= 'z'; letter++)
			System.out.println(letter + ": " + letterCount.get(letter));		
	}
}