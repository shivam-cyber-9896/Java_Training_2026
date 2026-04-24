package com.shivam.monocept.stringutility;

public class StringUtility {

    public boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public String toUpperCase(String str) {
        if (str == null) 
        	return null;
        return str.toUpperCase();
    }

    public Integer getLength(String str) {
        if (str == null) 
        	return null;
        return str.length();
    }
}