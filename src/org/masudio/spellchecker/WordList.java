package org.masudio.spellchecker;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class WordList implements IAmADictionary
{
	private String dictionaryFile;
	private Collection<String> words;
	
	public WordList(String filename)
	{
		dictionaryFile = filename;
		initialize();
	}
	
	private void initialize()
    {
		words = new ArrayList<String>();
	    try
        {
	        BufferedReader reader = new BufferedReader(new FileReader(dictionaryFile));
	        String word = null;
	        while(reader.ready())
	        {
	        	word = reader.readLine();
	        	words.add(word);
	        }
        }
	    catch(FileNotFoundException e)
        {
	        e.printStackTrace();
        }
	    catch(IOException e)
        {
	        e.printStackTrace();
        }
    }

	@Override
	public Iterator<String> iterator()
	{
		return words.iterator();
	}
}
