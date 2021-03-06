/**
 *  Copyright 2012 Zhijian Zeng, All Rights Reserved.
 *  Email: me@kanezeng.com
 *	This file is created at 2012-2-15
 */
package com.kanezeng.Translation.StringProcessing;

/**
 * 
 */
public class LevenshteinDistance {
	
	
	/**
	 * Return the distrance of the 2 given strings.
	 * @param primary	The first string
	 * @param secondary	The second string
	 * @param maxDiffPercentage	The max allowed different percentage (0-100), if the the different percentage is higher than its value, skip calculation to improve performance
	 * @return			the distrance of the 2 given strings.
	 */
	public static int getDistance(String primary, String secondary, int maxDiffPercentage) {
		int result = 0;
		
		int primarylength = primary.length();
		int secondarylength = secondary.length();
		if(primarylength==0) return secondarylength;
		if(secondarylength==0) return primarylength;
		
		// if the length of the 2 given strings are far different from each other, skip calculation
		int maxLength = Math.max(primarylength,secondarylength);
		int maxDiff = maxLength*maxDiffPercentage/100;
		if (maxLength==primarylength && secondarylength<primarylength-maxDiff) return maxLength;
		if (maxLength==secondarylength && primarylength<secondarylength-maxDiff) return maxLength;
		
		// Construct a matrix containing 0..primarylength rows and 0..secondarylength columns.
		int distance[][] = new int[secondarylength][primarylength];
		
		// Initialize the first column and first row
		for (int i=0;i<secondarylength;i++) distance[i][0] = i;
		for (int i=0;i<primarylength;i++) distance[0][i]=i;
		
		// Start calculation
		int cost =0;
		char pChar[] = primary.toCharArray();
		char sChar[] = secondary.toCharArray();
		
		for (int i=1;i<primarylength;i++) {
			for (int j=1;j<secondarylength;j++) {
				cost = (pChar[i]==sChar[j]?0:1);
				distance[j][i] = Math.min(Math.min(distance[j-1][i]+1, distance[j][i-1]+1),distance[j-1][i-1]+cost);
			}
		}
		
		result = distance[secondarylength-1][primarylength-1];
		
		return result;
	}
	
	/**
	 * Return the distrance of the 2 given strings.
	 * @param primary	The first string
	 * @param secondary	The second string
	 * @return			the distrance of the 2 given strings.
	 */
	public static int getDistance(String primary, String secondary) {
		return getDistance(primary, secondary,100);
	}
	
	/**
	 * Return the different percentage of two given strings
	 * @param primary	The first string
	 * @param secondary	The second string
	 * @param maxDiffPercentage	The max allowed different percentage.
	 * @return			An int value 0-100 represents the difference between the two given strings.
	 */
	public static int getDifferentPercentage(String primary, String secondary, int maxDiffPercentage) {
		int result = 100;
		if (primary.length()==0 && secondary.length()==0) {
			result = 0;
		} else {
			result = 100*getDistance(primary,secondary,maxDiffPercentage)/Math.max(primary.length(), secondary.length());
		}
		return result;
	}
	/**
	 * Return the different percentage of two given strings
	 * @param primary	The first string
	 * @param secondary	The second string
	 * @return			An int value 0-100 represents the difference between the two given strings.
	 */
	public static int getDifferentPercentage(String primary, String secondary) {
		return getDifferentPercentage(primary,secondary,100);
	}

	/**
	 * Return the similar percentage of two given strings
	 * @param primary	The first string
	 * @param secondary	The second string
	 * @param maxDiffPercentage	The max allowed different percentage.
	 * @return			An int value 0-100 represents the similar rate between the two given strings.
	 */
	public static int getSimilarPercentage(String primary, String secondary, int maxDiffPercentage) {
		return 100-getDifferentPercentage(primary,secondary,maxDiffPercentage);
	}
	

	/**
	 * Return the similar percentage of two given strings
	 * @param primary	The first string
	 * @param secondary	The second string
	 * @return			An int value 0-100 represents the similar rate between the two given strings.
	 */
	public static int getSimilarPercentage(String primary, String secondary) {
		return 100-getDifferentPercentage(primary,secondary,100);
	}

}
