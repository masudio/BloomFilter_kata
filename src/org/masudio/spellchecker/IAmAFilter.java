package org.masudio.spellchecker;

public interface IAmAFilter
{
	boolean insideSet(byte[] hash);
	void add(byte[] hash);
}
