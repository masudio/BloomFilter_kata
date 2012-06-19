package org.masudio.spellchecker;

public class SpellChecker implements ICheckSpelling
{

	private IAmAFilter filter;
	private IAmAHashFunction hashFunction;
	private IAmADictionary dictionary;

	/*
	 * dictionary must be filled already.
	 */
	public SpellChecker(IAmADictionary dictionary,
            IAmAHashFunction hashFunction,IAmAFilter filter)
    {
		this.dictionary = dictionary;
		this.hashFunction = hashFunction;
		this.filter = filter;
		
		initialize();
    }
	
	private void initialize()
	{
		String hash = null;
		for(Object word : dictionary)
        {
	        hash = hashFunction.hash((String)word);
	        filter.add(hash);
        }
	}

	public boolean isWord(String text)
    {
		String hash = hashFunction.hash(text);
		return filter.insideSet(hash);
    }
}
