/**
 *  Copyright 2012 Zhijian Zeng, All Rights Reserved.
 *  Email: me@kanezeng.com
 *	This file is created at 2012-2-15
 */
package com.kanezeng.Translation;

import java.util.ArrayList;

import com.kanezeng.Translation.EngObjects.ParsingRule;
import com.kanezeng.Translation.EngObjects.ExcludeRule;
import com.kanezeng.Translation.EngObjects.TUnit;
import com.kanezeng.Translation.FileProcessing.ExtractTranslatableStrings;
import com.kanezeng.Translation.FileProcessing.XLIFFFile;
import com.kanezeng.Translation.StringProcessing.LevenshteinDistance;
import com.kanezeng.Translation.StringProcessing.PseudoTranslate;
import com.kanezeng.Translation.Languages.Languages;

/**
 * This is used by Kane to test the APIs only. You can simply ignore it.
 */
public class MainStep {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Test Native2ASCII.toASCII()
		// System.out.println(Native2ASCII.toASCII("我是中国人haha!"));
//		 Test LevenshteinDistance
		 System.out.println(LevenshteinDistance.getDistance("This is Kane!!", "Tha is Kane"));
		System.out.println(LevenshteinDistance.getDifferentPercentage("This is Kane", "Tha is Kane"));
		System.out.println(LevenshteinDistance.getSimilarPercentage("This is Kane", "Thass is Kane"));
		// System.out.println(LevenshteinDistance.getSimilarPercentage("This is Kane",	"Thass is Kane",1));
		// Test Word Count
		// System.out.println(WordCount.getWordCount("     haha I am Kane!    "));
		// Test extracting translatable strings
		ArrayList<ParsingRule> allRules = new ArrayList<ParsingRule>();
		ArrayList<ExcludeRule> allExclude = new ArrayList<ExcludeRule>();

		allRules.add(new ParsingRule("^(.*?)=(.*?)$", 1, 2));
		allExclude.add(new ExcludeRule("^StringC.*?$"));
		for (TUnit tempUnit : ExtractTranslatableStrings.doExtract(
			"Sample/BasicResourceFile.txt", "UTF-8", allExclude, allRules)) {
			tempUnit = PseudoTranslate.getPseudoTranslationUnit(tempUnit,Languages.getLanguage("chs"));
			System.out.print("ID:" + tempUnit.ID + "\n");
			System.out.print("String:" + tempUnit.originalString + "\n");
			System.out.print("Translated String:" + tempUnit.translatedString + "\n");
		}
		String resourceFile = "Sample/BasicResourceFile.txt";
		String resourceFile2 = "Sample/BasicResourceFile2.txt";
		String outputXFile = "Sample/BasicResourceFile.xliff";
		ArrayList<TUnit> allUnits = ExtractTranslatableStrings.doExtract(
				resourceFile2, "UTF-8", allRules);
		allUnits.addAll(ExtractTranslatableStrings.doExtract(resourceFile,
				"UTF-8", allRules));

		XLIFFFile tempFile = new XLIFFFile();
		tempFile.create(allUnits, outputXFile, "enu");
		// Test encoding conversion
		// ConvertEncoding.convert("Sample/UTF8Sample.txt","Sample/GBKOutput.txt","UTF-8","GBK");
		System.out.println("wahaha!");
	}

}

