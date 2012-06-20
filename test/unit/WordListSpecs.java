package unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

import org.junit.Test;
import org.masudio.spellchecker.IAmADictionary;
import org.masudio.spellchecker.WordList;

public class WordListSpecs
{
	private IAmADictionary sut;

	@Test
	public void whenRunOnAnUbuntuBox_shouldCreateWordListWithLotsOfWordsInIt_AndReturnIteratorWhichReturnsThoseWords()
	{
		sut = new WordList("/usr/share/dict/words");
		Iterator<String> toTest = sut.iterator();

		String result1 = toTest.next();
		String result2 = toTest.next();
		String result3 = toTest.next();

		assertEquals("A", result1);
		assertEquals("A's", result2);
		assertEquals("AA's", result3);
	}

	@Test
	public void shouldStoreANumberOfWords()
	{
		sut = new WordList("/usr/share/dict/words");
		Iterator<String> toTest = sut.iterator();
		int numberOfWords = 0;

		while(toTest.hasNext())
		{
			toTest.next();
			numberOfWords++;
		}
		
		System.out.println(numberOfWords);
		assertTrue(0 != numberOfWords);
	}
}
