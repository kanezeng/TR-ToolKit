/**
 *  Copyright 2012 Zhijian Zeng, All Rights Reserved.
 *  Email: me@kanezeng.com
 *	This file is created at 2012-2-15
 */
package com.kanezeng.Translation.Encodings;

/**
 * The class provide a method to convert native characters to unicode excaped format like: \u0a31
 */
public class Native2ASCII {

	private static String hexString="0123456789ABCDEF";
	
	public static String toASCII(String str) {
		StringBuilder sb = new StringBuilder();
		
		try {
			byte[] bytes = str.getBytes("Unicode");
			
			for (int i = 0; i<bytes.length -1 ;i +=2) {
				if(bytes[i] ==0 && bytes[i+1] <=127) {
					char[] chars = Character.toChars(bytes[i+1]);
					sb.append(new String(chars));
				} else {
					sb.append("\\u");
					sb.append(hexString.charAt((bytes[i] & 0xf0) >> 4));
					sb.append(hexString.charAt((bytes[i] & 0x0f) >> 0));
					sb.append(hexString.charAt((bytes[i+1] & 0xf0) >> 4));
					sb.append(hexString.charAt((bytes[i+1] & 0x0f) >> 0));
				}
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		String myresult = sb.toString();

		if (myresult.toLowerCase().startsWith("\\ufeff")) {
			myresult = myresult.substring(6);
		}
	
		return myresult;
	}
}
