/**
 *  Copyright 2013 Zhijian Zeng, All Rights Reserved.
 *  Email: me@kanezeng.com
 *	This file is created at 2013-3-7 */
package com.kanezeng.Translation.StringProcessing;
import java.util.ArrayList;

import com.kanezeng.Translation.EngObjects.TUnit;
import com.kanezeng.Translation.StringProcessing.LevenshteinDistance;
/**
 * Leverage String with a set of given translation memories
 */
public class StringLeverage {
	/**
	 * Leverage String
	 * @param inputUnit				The translation unit we are going to leverage
	 * @param translationMemories	A set of translated units used as translation memories
	 * @param fuzzyLimit			The max limit of allowed fuzzy rate, value 0-100.
	 * @param checkFile				Set if the file information is considered.
	 * @param checkID				Set if the string ID is considered.
	 * @return						Leveraged translation unit.
	*/
	public static TUnit doLeverage(TUnit inputUnit, ArrayList<TUnit> translationMemories, int fuzzyLimit, boolean checkFile, boolean checkID) {
		//Check fuzzy limit
		if (fuzzyLimit<0) {
			fuzzyLimit=0;
		}else if (fuzzyLimit>100) {
			fuzzyLimit=100;
		}
		if (inputUnit==null || translationMemories==null ) return inputUnit;

		TUnit outputUnit = new TUnit("","","");

		//Start leverage

		outputUnit = strictLeverage(inputUnit, translationMemories, checkFile, checkID);

		// If Stric leverage failed to get a match, try loose leverage if fuzzyLimit is less than 100
		if (inputUnit.originalString.length() >0 && outputUnit.translatedString.length() ==0 && fuzzyLimit<100) {
			outputUnit = looseLeverage(inputUnit,translationMemories, fuzzyLimit);
		}
		// if no matches found, set the return value to original unit
		if (inputUnit.originalString.length() >0 && outputUnit.translatedString.length() ==0) {
			outputUnit = inputUnit;
		}
		return outputUnit;
	}

	private static TUnit strictLeverage(TUnit inputUnit, ArrayList<TUnit> translationMemories, boolean checkFile, boolean checkID) {
		TUnit outputUnit = new TUnit("","","");

		for (TUnit currentTM : translationMemories) {
			if(inputUnit.originalFile.equals(currentTM.originalFile) || checkFile == false) {
				if(inputUnit.ID.equals(currentTM.ID) || checkID == false) {
					if(inputUnit.originalString.equals(currentTM.originalString)) {
						outputUnit=currentTM;
						break;
					}
				}
			}
		}

		return outputUnit;
	}

	private static TUnit looseLeverage(TUnit inputUnit, ArrayList<TUnit> translationMemories, int fuzzyLimit) {
		TUnit outputUnit = new TUnit("","","");
		int currentFuzzy = 0;

		for (TUnit currentTM : translationMemories) {
			currentFuzzy=LevenshteinDistance.getSimilarPercentage(currentTM.originalString,inputUnit.originalString);
			if(currentFuzzy>=fuzzyLimit) {
				outputUnit=currentTM;
				fuzzyLimit=currentFuzzy;
			}
		}

		return outputUnit;
	}

}