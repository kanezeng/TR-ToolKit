/**
 *  Copyright 2013 Zhijian Zeng, All Rights Reserved.
 *  Email: me@kanezeng.com
 *	This file is created at 2013-3-26 */
package com.kanezeng.Translation.StringProcessing;


import com.kanezeng.Translation.EngObjects.TUnit;
import com.kanezeng.Translation.Languages.LanguageObject;
import com.kanezeng.Translation.EngObjects.TranslationStatus;
/**
* This class is designed to pseudo translate given strings.
*/
public class PseudoTranslate {
	/**
	 * Pseudo translate a string
	 * @param inputString			The English string for pseudo translation
	 * @param targetLanguage		The target language of pseudo translation
	 * @return						Pseudo translated string
	*/
	public static String getPseudoTranslation (String inputString, LanguageObject targetLanguage ) {
		String result = inputString;
		if (inputString.trim().length() >0 ) {
			result = targetLanguage.pseudoPrefix + result + targetLanguage.pseudoSurfix;
		}
		return result;
	}

	/**
	 * Pseudo translate a TUnit
	 * @param inputUnit				The TUnit object for pseudo translation
	 * @param targetLanguage		The target language of pseudo translation
	 * @return						Pseudo translated TUnit object
	*/
	public static TUnit getPseudoTranslationUnit(TUnit inputUnit, LanguageObject targetLanguage) {
		// Only pseudo translated untranslated string
		if (inputUnit.translationStatus.statusValue <= TranslationStatus.UNTRANSLATED.statusValue) {
			inputUnit.translatedString = getPseudoTranslation(inputUnit.originalString, targetLanguage);
			inputUnit.translationStatus = TranslationStatus.PSEUDOTRANSLATED;
		}

		return inputUnit;
	}
}
