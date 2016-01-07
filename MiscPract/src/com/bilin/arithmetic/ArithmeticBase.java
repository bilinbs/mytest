package com.bilin.arithmetic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.bilin.io.ConsoleInput;
import com.bilin.io.Input;

public abstract class ArithmeticBase {
	protected String expression;

	protected Map<Character, Integer> variableMap;
	
	public static Map<Character, Integer> operatorPrecedence;

	static {
		operatorPrecedence = new HashMap<Character, Integer>();
		operatorPrecedence.put('/', 1);
		operatorPrecedence.put('*', 2);
		operatorPrecedence.put('+', 3);
		operatorPrecedence.put('-', 4);
	}

	
	public ArithmeticBase(String expression){
		if (!expression.matches("[a-z\\(\\)\\+\\-\\*\\/]+")) {
			throw new IllegalArgumentException("Invalid expression!!!");
		}
		this.expression = expression.toLowerCase();
		populateVariables();
	}
	
	public ArithmeticBase(String expression, Map<Character, Integer> variableMap){
		this.expression = expression;
		this.variableMap = variableMap;
	}
	private void populateVariables() {
		Set<Character> variables = new HashSet<Character>();
		for (char c : expression.toCharArray()) {
			if (c >= 'a' && c <= 'z') {
				variables.add(c);
			}
		}
		getCharVariableValues(variables);
	}
	
	private void getCharVariableValues(Set<Character> variables) {
		Input input = new ConsoleInput();
		try {
			Set<String> varStrings = new HashSet<String>();
			for (Character var : variables) {
				varStrings.add(var.toString());
			}

			Map<String, Integer> varCharValueMap = input
					.readIntValuesOfVariables(varStrings);
			input.cleanUp();
			this.variableMap = new HashMap<Character, Integer>();
			for (String str : varCharValueMap.keySet()) {
				this.variableMap.put(str.charAt(0), varCharValueMap.get(str));
			}
		} finally {
			input.cleanUp();
		}
	}
	
	public int simpleEvaluate(char operator, char operand1, char operand2) {
		int op1 = this.variableMap.get(operand1);
		int op2 = this.variableMap.get(operand2);
		switch (operator) {
		case '/':
			return op1 / op2;
		case '*':
			return op1 * op2;
		case '+':
			return op1 + op2;
		case '-':
			return op1 - op2;

		default:
			return 0;
		}
	}
	public abstract int evaluate();
	
	public String getExpression() {
		return expression;
	}
	
	public static boolean checkPrecedence(char op1, char op2) {
		if(op1 == '(' || op2 =='('){
			return true;
		}
		return operatorPrecedence.get(op1) < operatorPrecedence.get(op2);
	}
}
