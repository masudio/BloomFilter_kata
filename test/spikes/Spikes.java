package spikes;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

public class Spikes
{

	@Test
	public void checkMD5HashFunction()
	{
		try
		{
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update("test".getBytes());
			byte[] bytes = digest.digest();
			
			System.out.println(new String(bytes));
			ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
			IntBuffer intBuffer = byteBuffer.asIntBuffer();
			
			System.out.println(intBuffer.get());
			System.out.println(intBuffer.get());
			System.out.println(intBuffer.get());
			System.out.println(intBuffer.get());
		}
		catch(NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void byteArrayToHexString()
	{
		try
		{
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update("test".getBytes());
			byte[] bytes = digest.digest();
			
			hexString = new StringBuilder();
			String hex = "";
			for(byte b : bytes)
            {
				hex = Integer.toHexString(0xFF & b);
				if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
            }
			
			System.out.println("hexString: " + hexString.toString());
			System.out.println("hexString length: " + hexString.length());
			
			hexStringToByteArray_andBackToSeeIfItsTheSame();
		}
		catch(NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
	}
	
	private StringBuilder hexString;
	
	public void hexStringToByteArray_andBackToSeeIfItsTheSame()
	{
		System.out.println("other method\n");
		System.out.println("hexString: " + hexString.toString());
		byte[] bytes = hexString.toString().getBytes();
		String hex = "";
		for(byte b : bytes)
        {
			hex = Integer.toHexString(0xFF & b);
			if(hex.length() == 1) hexString.append('0');
	        hexString.append(hex);
        }
		
		String hexStringOutput = hexString.substring(0, 32);
		System.out.println("hexString: " + hexStringOutput.toString());
		System.out.println("hexString length: " + hexStringOutput.length());
	}
	
	@Test
	public void checkEndianness()
	{
		byte[] bytes = new byte[]{ 0,1,2,3 };
		String s = new String(bytes);
		byte[] result = s.getBytes();
		for(byte b : result)
        {
	        System.out.println(b);
        }
	}
}
