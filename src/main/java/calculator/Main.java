package calculator;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main implements CalculatorInterface {

    public TokenList readTokens(String input) {
    	Scanner in = new Scanner(input);
    	TokenList output = new UnitList();
        Tokenizer tokenizer = new Tokenizer();
        
        while(in.hasNext()) {
        	output.add(tokenizer.tokenize(in.next()));
        }
        
        in.close();
        return output;
    }


       public Double rpn(TokenList tokens) {
    	Token temp;
    	TokenStack stack = new TStack();
    	double result = 0;
    	
    	for (int i = 0; i < tokens.size(); i++) {
    		temp = tokens.get(i);
    		
    		switch (temp.getType()) {
    			case 1: stack.push(temp);
    			case 2: temp = evaluate(temp,stack.pop(), stack.pop());
    		}
    	}
    	
    	if (stack.size() == 1) {
    		result = Double.parseDouble(stack.pop().getValue());
    	} else {
    		System.err.print("Invalid input remaining!");
    	}
    	 	
        return result;
    }
    
       private Token evaluate(Token operator, Token operandA, Token operandB) {
    	   Token temp;
    	   double result = 0;
    	
    	if (operator.getValue().equals("+")) {
    		result = Double.parseDouble(operandA.getValue()) + Double.parseDouble(operandB.getValue());
    	} else if (operator.getValue().equals("-")) {
    		result = Double.parseDouble(operandA.getValue()) - Double.parseDouble(operandB.getValue());
    	} else if (operator.getValue().equals("*")) {
    		result = Double.parseDouble(operandA.getValue()) * Double.parseDouble(operandB.getValue());
    	} else if (operator.getValue().equals("/")) {
    		result = Double.parseDouble(operandA.getValue()) / Double.parseDouble(operandB.getValue());
    	} else if (operator.getValue().equals("^")) {
    		result  = Double.parseDouble(operandB.getValue());
    		
    		for (int i = 0; i < Double.parseDouble(operandB.getValue()); i++) {
    			result = result * Double.parseDouble(operandB.getValue());
    		}
    	}
    	
    	temp = new Unit(Double.toString(result));
    	
		return temp;
    } 

    public TokenList shuntingYard(TokenList tokens) {
        // TODO: Implement this
        return null;
    }

    private void start() {
        Scanner in = new Scanner(System.in);
        
        // While there is input, read line and parse it.
        while(in.hasNextLine()) {
        	readTokens(in.nextLine());
        }
        
        in.close();
    }

    public static void main(String[] argv) {
        new Main().start();
    }
}
