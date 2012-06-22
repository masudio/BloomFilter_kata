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
		String expectedResult = "098f6bcd4621d373cade4e832627b4f6";
		sut = new MD5HashFunction();
		
		String result = sut.hash(wordToCheck);
		
		assertEquals(expectedResult, result);
	}
}
