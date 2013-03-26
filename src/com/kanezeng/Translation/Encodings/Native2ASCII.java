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

	public static String toNative(String str) {
		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);

			if (c == '\\' && i + 6 <= str.length() && str.charAt(i + 1) == 'u') {
				String sub = str.substring(i + 2, i + 6).toUpperCase();
				int i0 = hexString.indexOf(sub.charAt(0));
				int i1 = hexString.indexOf(sub.charAt(1));
				int i2 = hexString.indexOf(sub.charAt(2));
				int i3 = hexString.indexOf(sub.charAt(3));

				if (i0 < 0 || i1 < 0 || i2 < 0 || i3 < 0) {
					buf.append("\\u");
					i += 1;
				} else {
					byte[] data = new byte[2];
					data[0] = i2b(i1 + i0 * 16);
					data[1] = i2b(i3 + i2 * 16);
					try {
						buf.append(new String(data, "UTF-16BE").toString());
					} catch (Exception ex) {
						buf.append("\\u" + sub);
					}
					i += 5;
				}
			} else {
				buf.append(c);
			}
		}

		return buf.toString();
	}

	private static byte i2b(int i) {

		return (byte) ((i > 127) ? i - 256 : i);

	}
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
