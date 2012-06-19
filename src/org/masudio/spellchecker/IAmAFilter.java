package org.masudio.spellchecker;

public interface IAmAFilter
{
	boolean insideSet(String returnedHash);
	void add(String returnedHash);
}
