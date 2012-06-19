package unit;

import static org.junit.Assert.assertEquals;

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

}
