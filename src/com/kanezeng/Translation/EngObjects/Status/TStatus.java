/**
 *  Copyright 2012 Zhijian Zeng, All Rights Reserved.
 *  Email: me@kanezeng.com
 *	This file is created at 2012-2-15
 */
package com.kanezeng.Translation.EngObjects.Status;

/**
 * 
 */
public class TStatus {
	public int statusValue = 0;
	public String statusDescription = "";
	
	public TStatus(int newValue, String newDesc) {
		this.statusValue = newValue;
		this.statusDescription = newDesc;
	}
}
