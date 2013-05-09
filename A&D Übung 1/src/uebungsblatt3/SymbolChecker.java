package uebungsblatt3;

import java.util.Stack;

public class SymbolChecker {

	Stack<Character> s = new Stack<Character>();

	public boolean check(String input) {
		char[] cs = input.toCharArray();
		boolean result = true;
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
				else
					return false;
				break;
			case '}':
				if (!s.isEmpty() && s.peek() == '{')
					s.pop();
				else
					return false;
				break;

			case '/':
				if (i + 1 < cs.length && cs[i + 1] == '*') {
					s.push('*');
				} else if (!s.isEmpty() && cs[i - 1] == s.peek()) {
					s.pop();
				} else {
					return false;
				}
				break;

			}

			System.out.println(s);
			if (!s.isEmpty()) {
				result = false;
			} else {
				result = true;
			}
		}
		return result;
	}

	public boolean checkRegex(String input) {
		if (input.matches(".*?\\{(.*?)\\}.*?")
				|| input.matches(".*?\\((.*?)\\).*?")
				|| input.matches(".*?\\/\\*(.*?)\\*\\/.*?")) {
			check(input);
		} else {
			return false;
		}
		return true;
	}
}
