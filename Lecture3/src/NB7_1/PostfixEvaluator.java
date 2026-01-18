package NB7_1;

import java.util.Stack;
import java.util.EmptyStackException;

public class PostfixEvaluator {

    public static class SyntaxErrorException extends Exception {
        SyntaxErrorException(String message) {
            super(message);
        }
    }

    private static final String OPERATORS = "+-*/";
    private Stack<Integer> operandStack;

    public PostfixEvaluator() {
        this.operandStack = new Stack<>();
    }

    private int evalOp(char op) {

        int result = 0;
        int num1 = operandStack.pop();
        int num2 = operandStack.pop();

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
        String[] tokens = expression.split(" +");
        try {
            for (String nextToken : tokens) {
                if (Character.isDigit(nextToken.charAt(0))) {
                    operandStack.push(Integer.parseInt(nextToken));

                } else if (isOperator(nextToken.charAt(0))) {
                    operandStack.push(evalOp(nextToken.charAt(0)));

                } else {
                    throw new SyntaxErrorException("Invalid character encountered");
                }
            }

            int result = operandStack.pop();

            if (operandStack.isEmpty()) {
                return result;
            }
            throw new SyntaxErrorException("Wrong syntax");

        } catch (EmptyStackException ex) {
            throw new SyntaxErrorException("Syntax Error: The stack is empty");
        }
    }
}