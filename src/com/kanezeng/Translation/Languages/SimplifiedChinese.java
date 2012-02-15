/**
 *  Copyright 2012 Zhijian Zeng, All Rights Reserved.
 *  Email: me@kanezeng.com
 *	This file is created at 2012-2-15
 */
package com.kanezeng.Translation.Languages;

/**
 * A language object represent Simplified Chinese
 */
public class SimplifiedChinese extends LanguageObject {
	SimplifiedChinese() {
		this.nameEnglish = "Simplified Chinese";
		this.nameLocalized = "��������";
		this.twoLetterCode = "CN";
		this.threeLetterCode = "CHS";
		this.pseudoPrefix = "��ʼ";
		this.pseudoSurfix = "����";
	}
}
