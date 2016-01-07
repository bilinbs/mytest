package com.bilin.arithmetic.postfix;

import java.util.Map;
import java.util.Map.Entry;

import com.bilin.arithmetic.ArithmeticBase;

public class PostfixArithmetic extends ArithmeticBase{

	
	public PostfixArithmetic(String expression){
		super(expression);
	}
	
	public PostfixArithmetic(String expression, Map<Character, Integer> variableMap) {
		super(expression, variableMap);
	}

	@Override
	public int evaluate() {
		System.out.println(expression);
		for (Entry<Character, Integer> entry : this.variableMap.entrySet()) {
			System.out.printf("%s : %d\n", entry.getKey(), entry.getValue());
		}
		return 0;
	}

}
