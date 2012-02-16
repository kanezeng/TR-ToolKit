/**
 *  Copyright 2012 Zhijian Zeng, All Rights Reserved.
 *  Email: me@kanezeng.com
 *	This file is created at 2012-2-15
 */
package com.kanezeng.Translation.Utils;

import java.io.*;
import java.util.*;

/**
 * This is used to read and write files.
 */
public class FileIO {
	/**
	 * This method will read the whole file and return a String object. The line
	 * feeds are maintained as "\n"
	 * 
	 * @param fileName
	 *            The file to read.
	 * @param encoding
	 *            The encoding of the given file.
	 * @return A string contains all lines read from the file.
	 * @throws IOException
	 */
	public static String readFileToString(String fileName, String encoding)
			throws IOException {
		String result = "";
		StringBuilder sb = new StringBuilder();
		ArrayList<String> tempList = readFileToArrayList(fileName, encoding);

		for (String str : tempList) {
			sb.append(str);
			sb.append("\n");
		}
		return result;
	}

	/**
	 * This method will read the whole file and return a String list. The line
	 * feeds are maintained as "\n"
	 * 
	 * @param fileName
	 *            The file to read.
	 * @param encoding
	 *            the encoding of the given file
	 * @return A string list contains all lines read from the file.
	 * @throws IOException
	 */
	public static ArrayList<String> readFileToArrayList(String fileName,
			String encoding) throws IOException {
		ArrayList<String> result = new ArrayList<String>();
		encoding = encoding.trim();
		FileInputStream fs = new FileInputStream(fileName);
		InputStreamReader isr;
		if (encoding.equals("")) {
			isr = new InputStreamReader(fs);
		} else {
			isr = new InputStreamReader(fs, encoding);
		}
		BufferedReader br = new BufferedReader(isr);
		try {
			String data = "";
			while ((data = br.readLine()) != null) {
				result.add(data);
			}
		} catch (Exception e) {
		}
		return result;
	}

	/**
	 * Write text to the file
	 * 
	 * @param filePathAndName
	 *            The file to write
	 * @param fileContent
	 *            The content of the target file.
	 * @param encoding
	 *            The encoding of the target file
	 * @throws IOException
	 */
	public static void createFile(String filePathAndName, String fileContent,
			String encoding) {

		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			PrintWriter myFile = new PrintWriter(myFilePath, encoding);
			String strContent = fileContent;
			myFile.println(strContent);
			myFile.close();
		} catch (Exception e) {
		}
	}

	/**
	 * Write text to the file
	 * 
	 * @param filePathAndName
	 *            The file to write
	 * @param fileContent
	 *            The content of the target file.
	 * @throws IOException
	 */
	public static void createFile(String filePathAndName, String fileContent) {

		try {
			String filePath = filePathAndName;
			filePath = filePath.toString();
			File myFilePath = new File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.createNewFile();
			}
			FileWriter resultFile = new FileWriter(myFilePath);
			PrintWriter myFile = new PrintWriter(resultFile);
			String strContent = fileContent;
			myFile.println(strContent);
			myFile.close();
			resultFile.close();
		} catch (Exception e) {
		}
	}
	

	/**
	 * This method will delete the target file
	 * @param filePathAndName	the file name and path
	 * @return					return true if the file is deleted.
	 */
	public static boolean deleteFile(String filePathAndName) {
		boolean bea = false;
		try {
			String filePath = filePathAndName;
			File myDelFile = new File(filePath);
			if (myDelFile.exists()) {
				myDelFile.delete();
				bea = true;
			} else {
				bea = false;
			}
		} catch (Exception e) {
		}
		return bea;
	}
	

	/**
	 * Copy a file to another place
	 * @param oldPathFile	The file to be copied.
	 * @param newPathFile	The target file
	 */
	public static void copyFile(String oldPathFile, String newPathFile) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldPathFile);
			if (oldfile.exists()) { 
				InputStream inStream = new FileInputStream(oldPathFile); 
				FileOutputStream fs = new FileOutputStream(newPathFile);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; 
					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
		}
	}

}
