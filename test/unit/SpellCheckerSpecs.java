package unit;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import java.util.Iterator;

import org.junit.Test;
import org.masudio.spellchecker.IAmADictionary;
import org.masudio.spellchecker.IAmAFilter;
import org.masudio.spellchecker.IAmAHashFunction;
import org.masudio.spellchecker.ICheckSpelling;
import org.masudio.spellchecker.SpellChecker;
import org.mockito.InOrder;

public class SpellCheckerSpecs
{
	private ICheckSpelling sut;

	@Test
	public void test()
	{
		IAmADictionary mockDictionary = mock(IAmADictionary.class);
		IAmAHashFunction mockHashFunction = mock(IAmAHashFunction.class);
		IAmAFilter mockFilter = mock(IAmAFilter.class);
		Iterator mockIterator = mock(Iterator.class);
		String wordToCheck = "fire";
		byte[] returnedHash = new byte[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		boolean expectedResult = true;
		stub(mockDictionary.iterator()).toReturn(mockIterator);
		stub(mockIterator.hasNext()).toReturn(true).toReturn(false);
		stub(mockIterator.next()).toReturn(wordToCheck);
		stub(mockHashFunction.hash(wordToCheck)).toReturn(returnedHash);
		stub(mockFilter.insideSet(returnedHash)).toReturn(true);
		sut = new SpellChecker(mockDictionary, mockHashFunction, mockFilter);

		boolean result = sut.isWord(wordToCheck);

		// make sure mockFilter.add(returnedHash) is called before
		// mockFilter.insideSet(returnedHash) is.
		InOrder inOrder = inOrder(mockFilter);
		inOrder.verify(mockFilter).add(returnedHash);
		inOrder.verify(mockFilter).insideSet(returnedHash);
		assertEquals(expectedResult, result);
	}
}
