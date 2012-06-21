package unit;

import static org.junit.Assert.*;

import org.junit.Test;
import org.masudio.spellchecker.IAmAHashFunction;

public class HashFunctionSpecs
{
	private IAmAHashFunction sut;
	
	@Test
	public void whenGivenAString_shouldReturnItsMD5HashValue()
	{
		String wordToCheck = "test";
		String expectedResult = "something!? Get what I'm supposed to be!";
		sut = new MD5HashFunction();
		
		String result = sut.hash(wordToCheck);
		
		assertEquals(expectedResult, result);
	}
}
