package unit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import java.util.Iterator;

import org.junit.Test;
import org.masudio.spellchecker.BloomFilter;
import org.masudio.spellchecker.IAmADictionary;
import org.masudio.spellchecker.IAmAFilter;
import org.masudio.spellchecker.IAmAHashFunction;

public class FilterSpecs
{
	private IAmAFilter sut;
	
	@Test
	public void whenAskedIfWordIsInSet_andItIs_shouldReturnTrue()
	{
		String returnedHash = "1f8f6bcd4621d373cade4e832627b4t8";
		sut = new BloomFilter();
		
		sut.add(returnedHash);
		boolean result = sut.insideSet(returnedHash);
		
		assertTrue(result);
	}
	
	@Test
	public void whenAskedIfWordIsInSet_andItIsNot_shouldReturnFalse()
	{
		String returnedHash = "1f8f6bcd4621d373cade4e832627b4t8";
		sut = new BloomFilter();
		
		sut.add(returnedHash);
		boolean result = sut.insideSet("123456789abcdef123456789abcdef12");
		
		assertFalse(result);
	}
}
