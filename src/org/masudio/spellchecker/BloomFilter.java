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
	public boolean insideSet(String hash)
	{
		byte[] bytes = hash.getBytes();
		
    	for(int i = 0; i < 32; i+=4)
    	{
    		long hashValue = byteArrayToLong(Arrays.copyOfRange(bytes, i, i + 4));
    		
    		long index = hashValue / 8;
    		int offset = (int)(hashValue % 8);
    		
    		if(0 == (filter[(int)index] & (1 << offset)))
    			return false;
    	}
		return true;
	}

	@Override
	public void add(String hash)
	{
		byte[] bytes = hash.getBytes();

		try
		{
			if(bytes.length != 32)
				throw new Exception("dictionary word's hash is not the right length");

			for(int i = 0; i < 32; i+=4)
			{
				long hashValue = byteArrayToLong(Arrays.copyOfRange(bytes, i, i + 4));

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
