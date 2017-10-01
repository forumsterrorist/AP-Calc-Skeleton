package calculator;

public class TStack implements TokenStack {
	TokenList stack;
	
	TStack() {
		stack = new UnitList();
	}

	@Override
	public void push(Token token) {
		stack.add(token);
	}

	@Override
	public Token pop() {
		Token temp;
		
		temp = stack.get(stack.size());
		stack.remove(stack.size());
		
		return temp;
	}

	@Override
	public Token top() {
		return stack.get(stack.size());
	}

	@Override
	public int size() {
		return stack.size();
	}
}
