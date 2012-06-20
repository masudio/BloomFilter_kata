package unit;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.masudio.spellchecker.IAmAHashFunction;

public class MD5HashFunction implements IAmAHashFunction
{
	private MessageDigest digest;
	
	public MD5HashFunction()
	{
		initialize();
	}
	
	private void initialize()
	{
		try
        {
			digest = java.security.MessageDigest.getInstance("MD5");
        }
		catch(NoSuchAlgorithmException e)
        {
	        e.printStackTrace();
        }
	
	}
	
	@Override
	public String hash(String wordToCheck)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
