package com.bilin.arithmetic.infix;

import com.bilin.io.ConsoleInput;
import com.bilin.io.Input;

public class TestMain {

	public static void main(String[] args) {
		Input ipHandler = new ConsoleInput();
		try {
			System.out.println("Enter the expression:");
			String expression = ipHandler.readString();
			InfixArithmeticWithString infixExprn = new InfixArithmeticWithString(
					expression);
			infixExprn.evaluate();
		} finally {
			ipHandler.cleanUp();
		}

	}

}
