/**
 *  Copyright 2012 Zhijian Zeng, All Rights Reserved.
 *  Email: me@kanezeng.com
 *	This file is created at 2012-2-15
 */
package com.kanezeng.Translation.EngObjects;

import com.kanezeng.Translation.EngObjects.Status.TStatus;
import com.kanezeng.Translation.StringProcessing.WordCount;

/**
 * Represents a translation unit
 */
public class TUnit {
	public String originalFile = "";
	public String ID = "";
	public String originalString = "";
	public String translatedString = "";
	public TStatus translationStatus = TranslationStatus.UNTRANSLATED;
	// fuzzyRate equals 100 means this is a full match
	public int fuzzyRate = 100;
	
	public TUnit(String filename, String ID, String original) {
		this.originalFile=filename;
		this.ID = ID;
		this.originalString=original;
	}
	
	/**
	 * Get the word count of this translation unit.
	 * @return An integer value showing how many words can be found in the original string.
	 */
	public int getWordCount(){
		return WordCount.getWordCount(this.originalString);
	}
}
