package com.bilin.indexConversion;

import java.util.HashMap;
import java.util.Map;

public class AlphaNumericIndexConversion {
	 private static Map<Character,Integer> charMap = new HashMap<Character, Integer>();
	 private static Map<Integer, Character> numMap = new HashMap<Integer, Character>();
	 final static int MOD_VALUE = 26;
	 static {
		 int i = 1;
	     for(char c = 'A'; c<='Z'; c++,i++){
	         charMap.put(c,i);
	         numMap.put(i, c);
	     }
	     
	 }
	 
	 public static int charToIndex(String charIndex){
	     StringBuffer temp = new StringBuffer(charIndex);
	     int value = 0;
	     while(temp.length()>0){
	    	 int lastIndex = 0;//temp.length() - 1;
	    	 char c = temp.charAt(lastIndex);
	    	 temp.deleteCharAt(lastIndex);
	    	 value = (value * MOD_VALUE) + charMap.get(c) ;
	     }
	     return value;
	 }
	 
	 public static String indexToChar(int index){
		 StringBuffer charIndex = new StringBuffer();
		 while(index > 0){
			 int lastChar = index%MOD_VALUE == 0 ? MOD_VALUE : index%MOD_VALUE;
			 charIndex.insert(0,numMap.get(lastChar));
			 index = lastChar == MOD_VALUE ? (index / MOD_VALUE) - 1 : (index/ MOD_VALUE);
		 }
		 return charIndex.toString();
	 }
	 
}
