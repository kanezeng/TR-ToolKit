/**
 *  Copyright 2012 Zhijian Zeng, All Rights Reserved.
 *  Email: me@kanezeng.com
 *	This file is created at 2012-2-15
 */
package com.kanezeng.Translation.FileProcessing;

import java.util.ArrayList;

import com.kanezeng.Translation.EngObjects.ParsingRule;
import com.kanezeng.Translation.EngObjects.TUnit;

/**
 * This class will extract translatable strings from the given file following the specified parsing rules.
 */
public class ExtractTranslatableStrings {
	public ArrayList<TUnit> doExtract(String fileNameAndPath, String fileEncoding, ArrayList<ParsingRule> allRules) {
		ArrayList<TUnit> result = new ArrayList<TUnit>();
		
		return result;
	}
}
