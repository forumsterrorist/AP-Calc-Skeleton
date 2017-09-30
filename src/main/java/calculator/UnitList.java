package calculator;

public class UnitList implements TokenList {
	Token[] list;
	
	UnitList() {
		list = new Token[0];
	}
	
	@Override
	public void add(Token token) {
		Token[] temp = new Token[list.length + 1];
		
		if (list.length == 0) {
			temp[0] = token;
			list = temp;
			return;
		}
		
		for (int i = 0; i < list.length;  i++) {
			temp[i] = list[i];
		}
		
		temp[temp.length - 1] = token;
		list = temp;
	}

	@Override
	public void remove(int index) {
		Token[] temp = list;
		Token[] temp2 = new Token[list.length - 1];
		
		for (int i = index; i < temp.length - 1;  i++) {
				temp[i] = temp[i + 1];
		}
		
		for (int j = 0; j < temp2.length; j++) {
			temp2[j] = temp[j];
		}
		
		list = temp2;
	}

	@Override
	public void set(int index, Token token) {
		list[index] = token;
	}

	@Override
	public Token get(int index) {
		return list[index];
	}

	@Override
	public int size() {
		return list.length;
	}

}
