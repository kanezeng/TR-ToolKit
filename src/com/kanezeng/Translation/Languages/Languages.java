/**
 *  Copyright 2012 Zhijian Zeng, All Rights Reserved.
 *  Email: me@kanezeng.com
 *	This file is created at Mar 13, 2012
 */
package com.kanezeng.Translation.Languages;

/**
 * 
 */
public class Languages {
	public static LanguageObject getLanguage(String languageCode) {
		if (languageCode.equalsIgnoreCase("en")
				|| languageCode.equalsIgnoreCase("enu")
				|| languageCode.equalsIgnoreCase("en-us")) {
			return new USEnglish();
		} else if (languageCode.equalsIgnoreCase("cn")
				|| languageCode.equalsIgnoreCase("chs")
				|| languageCode.equalsIgnoreCase("zh-cn")) {
			return new SimplifiedChinese();
		}
		return null;
	}

	public static LanguageObject defaultLanguage() {
		return new USEnglish();
	}
}
