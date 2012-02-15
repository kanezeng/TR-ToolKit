/**
 *  Copyright 2012 Zhijian Zeng, All Rights Reserved.
 *  Email: me@kanezeng.com
 *	This file is created at 2012-2-15
 */
package com.kanezeng.Translation.StringProcessing;

/**
 * 
 */
public class WordCount {
	public static int getWordCount(String target) {
		int result = 0;
		// Remove leading and trailing spaces.
		target = target.trim();
		result = target.split(" ").length;
		
		return result;
	}
}
