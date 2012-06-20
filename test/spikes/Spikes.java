package spikes;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.junit.Test;

public class Spikes
{

	@Test
	public void checkMD5HashFunction()
	{
		try
		{
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update("aString".getBytes());
			byte[] bytes = digest.digest();
			
			for(int i = 0; i < 4; i++)
			{
				Integer value = new Integer(Arrays.copyOfRange(bytes, i * 4, i*5));
			}
		}
		catch(NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
	}

}
