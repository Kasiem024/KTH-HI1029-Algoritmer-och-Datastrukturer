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
        //hit skickar vi en operator den ska nu utföras på de två översta talen på stacken som ska tas bort. Sedan ska resultatet upp på stacken

        int num1 = operandStack.pop();
        int num2 = operandStack.pop();
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
        //skapa en stack för denna beräkning
        String[] tokens = expression.split(" +");//delar upp strängen vid mellanslag
        try {
            for (String nextToken : tokens) {
                if (Character.isDigit(nextToken.charAt(0))) {
                    // det kommer ett tal så använd Integer.parseInt(nextToken)) och lägg det på stacken!
                    operandStack.push(Integer.parseInt(nextToken));
                } else if (isOperator(nextToken.charAt(0))) {
                    // det kommer en operator så anropa evalOp för att göra beräkningen med operatorn
                    operandStack.push(evalOp(nextToken.charAt(0)));
                } else {
                    throw new SyntaxErrorException("Invalid character encountered");
                }
            }
            //Vi har läst hela uttrycket och gjort alla beräkningar så dags att ta ut svaret som borde vara det enda kvar på stacken
            //Om stacken inte är tom kasta ett syntax error annars returnera resultatet
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