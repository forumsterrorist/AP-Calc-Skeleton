package calculator;

public class Tokenizer{
	final String OPERATORS = "+-/*^";
	
	Tokenizer() {
	}

	public Token tokenize(String input) {
		Token output;
		Unit temp = new Unit();
		
		temp.set(input);
		output = temp;
		
		System.out.print(output.getValue());
		
		return output;
	}
}
