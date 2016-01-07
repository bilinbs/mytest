package com.bilin.arithmetic;

import java.util.Stack;

public class ExpressionConversionUtil {
	
	private ExpressionConversionUtil(){
		
	}
	
	public static String infixToPostfix(String infix) {
		Stack<Character> stack = new Stack<Character>();
		char[] infixChars = infix.toCharArray();
		StringBuilder postfix  = new StringBuilder();
		for (char c : infixChars) {
			switch (c) {
			case '(':
			case '+':
			case '-':
			case '*':
			case '/':
				while(!stack.empty() && !ArithmeticBase.checkPrecedence(c, stack.peek())){
					postfix.append(stack.pop());
				}
				stack.push(c);
				break;
			case ')':
				while (stack.peek()!= '(') {
					postfix.append(stack.pop());
				}
				stack.pop();
				break;
			default:
				postfix.append(c);
			}
		}
		while (!stack.empty()) {
			postfix.append(stack.pop());
		}
		return postfix.toString();

	}
	
	public static String infixToPrefix(String infix){
		throw new UnsupportedOperationException("Not Yet Implemented");
	}

}
