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

		temp = stack.get(stack.size() - 1);
		stack.remove(stack.size() - 1);

		return temp;
	}

	@Override
	public Token top() {
		return stack.get(stack.size() - 1);
	}

	@Override
	public int size() {
		return stack.size();
	}
}
