/**
 *  Copyright 2012 Zhijian Zeng, All Rights Reserved.
 *  Email: me@kanezeng.com
 *	This file is created at 2012-2-15
 */
package com.kanezeng.Translation;

import com.kanezeng.Translation.StringProcessing.LevenshteinDistance;
import com.kanezeng.Translation.StringProcessing.WordCount;

/**
 * This is use by Kane to test the APIs only.
 * You can simply ignore it.
 */
public class MainStep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Test Native2ASCII.toASCII()
//		System.out.println(Native2ASCII.toASCII("w≈∂ «‘¯÷æº·haha!"));
		// Test LevenshteinDistance
//		System.out.println(LevenshteinDistance.getDistance("This is Kane", "Tha is Kane"));
//		System.out.println(LevenshteinDistance.getDifferentPercentage("This is Kane", "Tha is Kane"));
//		System.out.println(LevenshteinDistance.getSimilarPercentage("This is Kane", "Thass is Kane"));
//		System.out.println(LevenshteinDistance.getSimilarPercentage("This is Kane", "Thass is Kane",1));
		// Test Word Count
		System.out.println(WordCount.getWordCount("     haha I am Kane!    "));
	}

}
