package com.bilin.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ConsoleInput implements Input {

	InputStreamReader isr;
	BufferedReader br;

	public ConsoleInput() {
		isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
	}

	@Override
	public String readString() {
		try{
			return br.readLine();
		} catch(IOException ioe){
			ioe.printStackTrace();
			return "";
		}
		
	}

	@Override
	public int readInteger() {
		while(true){
			try {
				
				String ip = br.readLine(); 
				return Integer.parseInt(ip);
			}catch(NumberFormatException nfe){
				System.out.print("Invalid number!!! Please enter the proper value again : ");
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
	}

	@Override
	public Map<String, Integer> readIntValuesOfVariables(
			Collection<String> variables) {
		Map<String, Integer> variableMap = new HashMap<String, Integer>();
		for (String var : variables) {
			System.out.printf("Enter the value for %s: ", var);
			variableMap.put(var, readInteger());
		}
		return variableMap;
	}

	public void cleanUp() {
		try {
			if (br != null) {
				br.close();
			}
			if (isr != null) {
				isr.close();
			}
		} catch (IOException e) {
			System.out.println("Exception while trying to close streams");
			e.printStackTrace();
		}
	}
}
