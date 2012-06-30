package org.masudio.spellchecker;
import java.util.Scanner;

public class Program
{
	public static void main(String[] args)
	{
		Program program = new Program();
		program.run();
	}
	
	public void run()
	{
		SpellChecker spellChecker = new SpellChecker(new WordList("/usr/share/dict/words"), new MD5HashFunction(), new BloomFilter());
		String word = "";
		
		while(!word.toLowerCase().equals("quit"))
		{
			System.out.println("Enter a word to spell check: ");
			Scanner keyboard = new Scanner(System.in);
			word = keyboard.nextLine().trim();
			
			if(spellChecker.isWord(word)) System.out.println("That's a word.");
			else System.out.println("That's not a word.");
		}
		
		System.out.println("Goodbye.");
	}
}
