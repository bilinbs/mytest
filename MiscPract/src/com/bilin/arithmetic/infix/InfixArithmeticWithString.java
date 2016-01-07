package com.bilin.arithmetic.infix;

import java.util.Map.Entry;

import com.bilin.arithmetic.ArithmeticBase;
import com.bilin.arithmetic.ExpressionConversionUtil;
import com.bilin.arithmetic.postfix.PostfixArithmetic;

public class InfixArithmeticWithString extends ArithmeticBase {

	public InfixArithmeticWithString(String expression) {
		super(expression);
	}

	public int evaluate() {
		System.out.println(expression);
		for (Entry<Character, Integer> entry : this.variableMap.entrySet()) {
			System.out.printf("%s : %d\n", entry.getKey(), entry.getValue());
		}
		String postfixExpr = ExpressionConversionUtil
				.infixToPostfix(expression);
		PostfixArithmetic postfix = new PostfixArithmetic(postfixExpr,
				variableMap);
		return postfix.evaluate();
	}

}
