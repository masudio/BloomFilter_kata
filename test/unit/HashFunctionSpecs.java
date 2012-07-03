package unit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.masudio.spellchecker.IAmAHashFunction;
import org.masudio.spellchecker.MD5HashFunction;

public class HashFunctionSpecs
{
	private IAmAHashFunction sut;
	
	@Test
	public void whenGivenAString_shouldReturnItsMD5HashValue()
	{
		String wordToCheck = "test";
		byte[] expectedResult = new byte[]{9,-113,107,-51,70,33,-45,115,-54,-34,78,-125,38,39,-76,-10};
		sut = new MD5HashFunction();
		
		byte[] result = sut.hash(wordToCheck);
		
		assertArrayEquals(expectedResult, result);
	}
}
