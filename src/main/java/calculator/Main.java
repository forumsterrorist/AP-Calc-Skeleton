//package calculator;
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
                  break;
    			case 2: temp = evaluate(temp, stack.pop(), stack.pop());
                  stack.push(temp);
                  break;
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
    		double ttp  = Double.parseDouble(operandB.getValue());

    		for (int i = 0; i < ttp; i++) {
    			result = result * ttp;
    		}
    	}

    	temp = new Unit(Double.toString(result));

      return temp;
    }

    public TokenList shuntingYard(TokenList tokens) {
        TokenStack OperatorsStack = new TStack();
        TokenList output = new UnitList();
        Token temp;

        for (int i = 0; i < tokens.size(); i++) {
      		temp = tokens.get(i);

          if (temp.getType() == 1) {
            output.add(temp);

          } else if (temp.getType() == 2) {
            while ((OperatorsStack.size() > 0) && (OperatorsStack.top().getPrecedence() >= temp.getPrecedence())) {
              output.add(OperatorsStack.pop());
            }
            OperatorsStack.push(temp);

          } else if (temp.getType() == 3) {
            if (temp.getValue().equals("(")) {
              OperatorsStack.push(temp);
            } else if (temp.getValue().equals(")")) {
              while (!OperatorsStack.top().getValue().equals("(")) {
                output.add(OperatorsStack.pop());
              }
              OperatorsStack.pop();
            }
          }
        }
        while (OperatorsStack.size() > 0) {
          output.add(OperatorsStack.pop());
        }

        return output;
    }

    private void start() {
        Scanner in = new Scanner(System.in);
        String inp = "( ( ( 15  / ( 7 - ( 1 + 1 ) ) ) * 3 ) - ( 2 + ( 1 + 1 ) ) ) ^ 3";
        // While there is input, read line and parse it.
        while(in.hasNextLine()) {
          //TokenList step1 = readTokens(in.nextLine());
          TokenList step1 = readTokens(inp);
          System.out.print("Done reading\n");
          TokenList step2 = shuntingYard(step1);
          System.out.print("Done shunting\n");
          double result = rpn(step2);
          System.out.print("Done rpn\n");
        	//double result = rpn(shuntingYard(readTokens(in.nextLine())));
          System.out.printf("Result: %f\n", result);
          break;
        }

        in.close();
    }

    public static void main(String[] argv) {
        new Main().start();
    }
}
