/**
 *  Copyright 2012 Zhijian Zeng, All Rights Reserved.
 *  Email: me@kanezeng.com
 *	This file is created at 2012-2-15
 */
package com.kanezeng.Translation.EngObjects;

/**
 * Parsing rule is a regular expression used to extract translatable strings.
 */
public class ParsingRule {
	public String rule = "";
	public int indexOfID = 1;
	public int indexOfString = 1;
	
	public ParsingRule(String rule, int indexOfID, int indexOfString) {
		this.indexOfID = indexOfID;
		this.rule = rule;
		this.indexOfString = indexOfString;
	}
}
