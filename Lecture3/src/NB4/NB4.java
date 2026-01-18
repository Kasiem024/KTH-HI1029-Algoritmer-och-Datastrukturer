package NB4;

import java.util.Stack;

public class NB4 {
    public NB4() {
    }

    public boolean isBalanced(String par) {

        Stack<Character> stack = new Stack<>();
        char c = ' ';

        for (int i = 0; i < par.length(); i++) {
            c = par.charAt(i);

            if (c == '(' || c == '[' || c == '{') {

                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {

                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
                if (c == ')' && top != '(') return false;
            }
        }
        return stack.isEmpty();
    }
}