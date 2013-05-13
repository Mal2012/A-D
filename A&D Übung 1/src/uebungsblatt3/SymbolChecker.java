package uebungsblatt3;

import java.util.Stack;

public class SymbolChecker {

	Stack<Character> s = new Stack<Character>();

	public boolean check(String input) {
		char[] cs = input.toCharArray();
		for (int i = 0; i < cs.length; i++) {

			switch (cs[i]) {
			case '(':
				s.push('(');
				break;
			case '{':
				s.push('{');
				break;
			case ')':
				if (!s.isEmpty() && s.peek() == '(')
					s.pop();
				break;
			case '}':
				if (!s.isEmpty() && s.peek() == '{')
					s.pop();
				break;
			case '/':
				if (i + 1 < cs.length && cs[i + 1] == '*') {
					s.push('/');
					i++;
				}
				break;
			case '*':
				if (i + 1 < cs.length && cs[i + 1] == '/') {
					i++;
					if (!s.isEmpty())
						if (s.peek() == '/')
							s.pop();
						else
							return false;
					else
						return false;
				}
				break;
			}

		}
		return s.isEmpty();
	}

	public boolean checkRegex(String input) {
		if (input.matches(".*?\\{(.*?)\\}.*?")
				|| input.matches(".*?\\((.*?)\\).*?")
				|| input.matches(".*?\\/\\*(.*?)\\*\\/.*?")) {
			return check(input);
		} else {
			return false;
		}
	}
}
