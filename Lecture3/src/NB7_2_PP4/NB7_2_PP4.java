package NB7_2_PP4;

import java.util.EmptyStackException;
import java.util.Stack;

public class NB7_2_PP4 {

    public static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String message) {
            super(message);
        }
    }

    private static final String OPERATORS = "+-*/()";
    private final Stack<Integer> digitStack;
    private final Stack<Character> operatorStack;

    public NB7_2_PP4() {
        this.digitStack = new Stack<>();
        this.operatorStack = new Stack<>();
    }

    private int evalOp(char op) {

        int num1 = digitStack.pop();
        int num2 = digitStack.pop();
        int result = 0;

        switch (OPERATORS.indexOf(op)) {
            case 0:
                result = num2 + num1;
                break;
            case 1:
                result = num2 - num1;
                break;
            case 2:
                result = num2 * num1;
                break;
            case 3:
                result = num2 / num1;
                break;
            default:
                System.out.println("Something wrong happened");
        }

        return result;
    }

    private boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    public int eval(String expression) throws SyntaxErrorException {

        String[] tokens = expression.split(" +");//delar upp strängen vid mellanslag
        try {
            for (String nextToken : tokens) {
                if (Character.isDigit(nextToken.charAt(0))) {

                    digitStack.push(Integer.parseInt(nextToken));
                } else if (isOperator(nextToken.charAt(0))) {

                    char c = nextToken.charAt(0);

                    if (c == '(') {
                        operatorStack.push(c);
                    }
                    else if (c == ')') {
                        while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
                            digitStack.push(evalOp(operatorStack.pop()));
                        }
                        operatorStack.pop();
                    }
                    else {
                        while (!operatorStack.isEmpty() && operatorStack.peek() != '(' &&
                                getPrecedence(operatorStack.peek()) >= getPrecedence(c)) {
                            digitStack.push(evalOp(operatorStack.pop()));
                        }
                        operatorStack.push(c);
                    }

                } else {
                    throw new SyntaxErrorException("Invalid character encountered");
                }
            }

            while (!operatorStack.isEmpty() && !digitStack.isEmpty()) {
                digitStack.push(evalOp(operatorStack.pop()));
            }

            return digitStack.pop();

        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
    }

    private int getPrecedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0; // Parenthesis
    }
}