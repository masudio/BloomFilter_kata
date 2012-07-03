package unit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.masudio.spellchecker.BloomFilter;
import org.masudio.spellchecker.IAmAFilter;

public class FilterSpecs
{
	private IAmAFilter sut;
	
	@Test
	public void whenAskedIfWordIsInSet_andItIs_shouldReturnTrue()
	{
		byte[] returnedHash = new byte[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		sut = new BloomFilter();
		
		sut.add(returnedHash);
		boolean result = sut.insideSet(returnedHash);
		
		assertTrue(result);
	}
	
	@Test
	public void whenAskedIfWordIsInSet_andItIsNot_shouldReturnFalse()
	{
		byte[] returnedHash = new byte[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		sut = new BloomFilter();
		
		sut.add(returnedHash);
		boolean result = sut.insideSet(new byte[]{1,11,3,4,3,2,1,2,3,4,5,4,22,4,3,4});
		
		assertFalse(result);
	}
}
