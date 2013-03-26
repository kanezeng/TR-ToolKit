/**
 *  Copyright 2012 Zhijian Zeng, All Rights Reserved.
 *  Email: me@kanezeng.com
 *	This file is created at 2012-2-15
 */
package com.kanezeng.Translation.EngObjects;

import com.kanezeng.Translation.EngObjects.Status.TStatus;

/**
 * 
 */
public abstract class TranslationStatus {
	public final static TStatus UNTRANSLATED = new TStatus(0, "Untranslated");
	public final static TStatus PSEUDOTRANSLATED = new TStatus(1,"Pseudo translated for testing");
	public final static TStatus FUZZYLEVERAGEDFORREVIEW = new TStatus(2,"Fuzzy Leveraged For Review");
	public final static TStatus LEVERAGEDFORREVIEW = new TStatus(3,"Leveraged For Review");
	public final static TStatus TRANSLATEDFORREVIEW = new TStatus(4,"Translated For Review");
	public final static TStatus SIGNEDOFF = new TStatus(5,"Signed Off");
}
