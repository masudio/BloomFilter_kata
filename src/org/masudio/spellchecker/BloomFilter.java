package org.masudio.spellchecker;

import java.util.Arrays;


public class BloomFilter implements IAmAFilter
{
	public static int BYTE_ARRAY_SIZE = Integer.MAX_VALUE / 8;
	
	private byte[] filter;
	
	public BloomFilter()
	{
		this.filter = new byte[BYTE_ARRAY_SIZE];
	}
	
	private long byteArrayToLong(byte[] b) 
	{
	    long value = 0;
	    for (int i = 0; i < 4; i++) {
	        int shift = (4 - 1 - i) * 8;
	        value += (b[i] & 0x000000FF) << shift;
	    }
	    return value;
	}

	@Override
	public boolean insideSet(byte[] hash)
	{
		try
		{
			if(hash.length != 16)
				throw new Exception("query word's hash is not the right length");
			
			for(int i = 0; i < 16; i+=4)
			{
				long hashValue = byteArrayToLong(Arrays.copyOfRange(hash, i, i + 4));
				hashValue = Math.abs(hashValue);

				long index = hashValue / 8;
				int offset = (int)(hashValue % 8);

				byte element = filter[(int)index];
				element &= (1 << offset);
				if(0 == element)
					return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
		return true;
	}

	@Override
	public void add(byte[] hash)
	{
		try
		{
			if(hash.length != 16)
				throw new Exception("dictionary word's hash is not the right length");

			for(int i = 0; i < 16; i+=4)
			{
				long hashValue = byteArrayToLong(Arrays.copyOfRange(hash, i, i + 4));
				hashValue = Math.abs(hashValue);
				
				long index = hashValue / 8;
				int offset = (int)(hashValue % 8);

				filter[(int)index] |= (1 << offset); // can i type cast like that?  Does it still work if index is negative when represented as an int?
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(1);
		}
	}
}
