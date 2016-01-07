package com.bilin.io;

import java.util.Collection;
import java.util.Map;

public interface Input {
	
	public Map<String, Integer> readIntValuesOfVariables(Collection<String> variables);
	
	public String readString();
	
	public int readInteger();
	
	public void cleanUp();

}
