package calculator;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

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
    //	Token temp;
    //	Stack stack = new Stack();
    	double result = 0;
    	/*
    	for (int i = 0; i < tokens.size(); i++) {
    		temp = tokens.get(i);
    		
    		switch (temp.getType()) {
    			case 1: stack.push(temp);
    			case 2: 
    			case 3:
    		}
    	}
    	
    	*/ 	
        return result;
    }
    
       /*    private double evaluate(Token operator, Token operandA, Token operandB) {
    	double result;
    	
    	if (operator.getValue().equals("+")) {
    	}
    } */

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
    }

    public static void main(String[] argv) {
        new Main().start();
    }
}
