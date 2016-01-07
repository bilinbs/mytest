package com.bilin.indexConversion;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] inputCharIndexes = {"A", "E", "Z", "AA", "AZ", "FF", "ZZ", "AAA"};
		//expected op = {1, 5, 26, 27, 52, 162,702,703}
		
		for(String str : inputCharIndexes){
			System.out.print(AlphaNumericIndexConversion.charToIndex(str)+", ");
		}
		System.out.println();
		
		int [] inputNumIndexes = {1, 10, 25, 26, 27, 29, 51, 702, 703};
		//expected op = {"A", "J", "Y","Z","AA" "AC","AY","ZZ","AAA"}
		
		for(int i : inputNumIndexes){
			System.out.print(AlphaNumericIndexConversion.indexToChar(i) + ", ");
		}
		

	}

}
