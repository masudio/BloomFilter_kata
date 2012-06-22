package org.masudio.spellchecker;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


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
		digest.update(wordToCheck.getBytes());
		byte[] bytes = digest.digest();
		
		StringBuilder hexString = new StringBuilder();
		String hex = "";
		for(byte b : bytes)
        {
			hex = Integer.toHexString(0xFF & b);
			if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
        }
		
		return hexString.toString();
	}

}
