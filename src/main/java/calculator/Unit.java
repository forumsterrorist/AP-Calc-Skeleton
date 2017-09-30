package calculator;

public class Unit implements Token {
	String token;
	int precedence;
	int type;
	double value;
	
	Unit() {
		token = null;
	}
	
	Unit(String input) {
		set(input);
	}
	
	public void set(String input) {
		token = input;
		
		if (token.equals("(") || token.equals(")")) {
			type = 3;
			return;
		} else if (token.equals("+") || token.equals("-")) {
			precedence = 2;
			type = 2;
			return;
		} else if (token.equals("/") || token.equals("*")) {
			precedence = 3;
			type = 2;
			return;
		} else if (token.equals("^")) {
			precedence = 4;
			type = 2;
			return;
		} else {
			try {
				value = Double.parseDouble(input);
				precedence = -1;
				type = 1;
			} catch (NumberFormatException e) {
				System.err.print("Not a valid number!");
			}
		}
	}
	
	@Override
	public String getValue() {
		return token;
	}

	@Override
	public int getType() {
		return type;
	}

	@Override
	public int getPrecedence() {
		return precedence;
	}
	
}
