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
	public void digestToHexString()
	{
		try
		{
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update("test".getBytes());
			byte[] bytes = digest.digest();
			
			StringBuilder hexString = new StringBuilder();
			String hex = "";
			for(byte b : bytes)
            {
				hex = Integer.toHexString(0xFF & b);
//				if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
            }
			
			System.out.println("hexString: " + hexString.toString());
			System.out.println(hexString.length());
		}
		catch(NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
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
