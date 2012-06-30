package spikes;

import static org.junit.Assert.assertEquals;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import org.junit.Test;
import org.masudio.spellchecker.IAmAHashFunction;
import org.masudio.spellchecker.MD5HashFunction;

public class Spikes
{

	//@Test
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
	
	byte[] outsideBytes;
	
	@Test
	public void byteArrayToHexString()
	{
		try
		{
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update("test".getBytes());
			byte[] bytes = digest.digest();
			outsideBytes = Arrays.copyOf(bytes, bytes.length);
			
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
		System.out.println("\nother method");
		System.out.println("hexString: " + hexString.toString());
		byte[] bytes = hexString.toString().getBytes();
		String hex = "";
		StringBuilder hexString2 = new StringBuilder();
		for(byte b : bytes)
        {
			hex = Integer.toHexString(0xFF & b);
			if(hex.length() == 1) hexString2.append('0');
	        hexString2.append(hex);
        }
		
		String hexStringOutput = hexString2.toString();
		System.out.println("hexString: " + hexStringOutput.toString());
		System.out.println("hexString length: " + hexStringOutput.length());
	}
	
	@Test
	public void testIfBytesFromHexStringIsSameAsBytesFromHashFunction()
	{
		try
		{
			MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
			digest.update("test".getBytes());
			byte[] bytes = digest.digest();
			outsideBytes = Arrays.copyOf(bytes, bytes.length);
			
			hexString = new StringBuilder();
			String hex = "";
			for(byte b : bytes)
            {
				hex = Integer.toHexString(0xFF & b);
//				if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
            }
		}
		catch(NoSuchAlgorithmException e)
		{
			e.printStackTrace();
		}
		
		String str = hexString.toString();
		byte[] hexStringBytes = str.getBytes();
		assertEquals(outsideBytes.length, hexStringBytes.length);
		int i = 0;
		
		for(byte currentByte : outsideBytes)
        {
	        assertEquals(currentByte, hexStringBytes[i++]);
        }
		
	}
	
	@Test
	public void testHash()
	{
		IAmAHashFunction function = new MD5HashFunction();
		String hexString = function.hash("test");
		byte[] bytes = hexString.getBytes();
		String hexString2 = function.hash("test");
		byte[] bytes2 = hexString.getBytes();
		
		assertEquals(hexString, hexString2);
		assertEquals(bytes.length,bytes2.length);
		for(int i = 0; i < bytes.length; i++)
		{
			assertEquals(bytes[i],bytes2[i]);
		}
	}
	
//	@Test
//	public void checkEndianness()
//	{
//		byte[] bytes = new byte[]{ 0,1,2,3 };
//		String s = new String(bytes);
//		byte[] result = s.getBytes();
//		for(byte b : result)
//        {
//	        System.out.println(b);
//        }
//	}
}
