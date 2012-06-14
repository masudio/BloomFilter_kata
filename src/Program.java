import java.util.Scanner;

public class Program
{
	public void run()
	{
		SpellChecker spellChecker = new SpellChecker(null,null,null);//TODO: fix these dependencies
		Scanner keyboard = new Scanner(System.in);

		if(spellChecker.isWord(keyboard.nextLine().trim())) System.out.println("That's a word.");
		else System.out.println("That's not a word.");
	}
}
