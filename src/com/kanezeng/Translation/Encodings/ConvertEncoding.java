/**
 *  Copyright 2012 Zhijian Zeng, All Rights Reserved.
 *  Email: me@kanezeng.com
 *	This file is created at 2012-2-16
 */
package com.kanezeng.Translation.Encodings;

import java.io.IOException;

import com.kanezeng.Translation.Utils.FileIO;

/**
 * This class is used for encoding conversion.
 */
public class ConvertEncoding {
	public static boolean convert(String inputFile, String outputFile, String fromEncoding, String toEncoding) {
		boolean result = false;
		try {
			String tempStr = FileIO.readFileToString(inputFile, fromEncoding);
			FileIO.createFile(outputFile, tempStr, toEncoding);
			
			// Kane: I need to add feature codes to verify if the conversion is done successfully.
			result = true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
}
