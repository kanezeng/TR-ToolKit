/**
 *  Copyright 2012 Zhijian Zeng, All Rights Reserved.
 *  Email: me@kanezeng.com
 *	This file is created at 2012-2-15
 */
package com.kanezeng.Translation.Utils;

import java.io.*;
import java.util.StringTokenizer;

/**
 * This class provides actions related to folders.
 */
public class FolderAction {

	/**
	 * Create the folder
	 * 
	 * @param folderPath
	 * @return the full path of the folder
	 */
	public static String createFolder(String folderPath) {
		String txt = folderPath;
		try {
			java.io.File myFilePath = new java.io.File(txt);
			txt = folderPath;
			if (!myFilePath.exists()) {
				myFilePath.mkdir();
			}
		} catch (Exception e) {
		}
		return txt;
	}

	/**
	 * Create the full folder structure
	 * 
	 * @param folderPath
	 *            the full path of the folder structure.
	 * @return
	 */
	public String createFolders(String folderPath) {
		String txts = folderPath;
		try {
			String[] myPath = folderPath.split(File.separator);
			String currentPath = "";
			for (String eachPath : myPath) {
				currentPath += File.separator + eachPath;
				createFolder(currentPath);
			}
		} catch (Exception e) {
		}
		return txts;
	}

	/**
	 * Remove a folder
	 * 
	 * @param path
	 *            The folder to be removed.
	 */
	public void deleteFolder(String path) {
		try {

			File dir = new File(path);
			if (dir.exists()) {
				File[] tmp = dir.listFiles();
				for (int i = 0; i < tmp.length; i++) {
					if (tmp[i].isDirectory()) {
						deleteFolder(path + File.separator + tmp[i].getName());
					} else {
						tmp[i].delete();
					}
				}
				dir.delete();
			}
		} catch (Exception e) {
		}
	}

	/**
	 * Remove all files under the given folder
	 * 
	 * @param path
	 * @return
	 */
	public boolean deleteAllFile(String path) {
		boolean bea = false;
		File file = new File(path);
		if (!file.exists()) {
			return bea;
		}
		if (!file.isDirectory()) {
			return bea;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (path.endsWith(File.separator)) {
				temp = new File(path + tempList[i]);
			} else {
				temp = new File(path + File.separator + tempList[i]);
			}
			if (temp.isFile()) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				deleteAllFile(path + File.separator + tempList[i]);
				deleteFolder(path + File.separator + tempList[i]);
				bea = true;
			}
		}
		return bea;
	}

	/**
	 * Copy a whole folder to a new location
	 * 
	 * @param oldPath
	 * @param newPath
	 */
	public void copyFolder(String oldPath, String newPath) {
		try {
			new File(newPath).mkdirs();
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}
				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath
							+ File.separator + (temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory()) {
					copyFolder(oldPath + File.separator + file[i], newPath
							+ File.separator + file[i]);
				}
			}
		} catch (Exception e) {
		}
	}
}
