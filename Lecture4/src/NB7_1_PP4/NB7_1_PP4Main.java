package NB7_1_PP4;

import java.util.Scanner;

public class NB7_1_PP4Main {
    public static void main(String[] args) {

        NB7_1_PP4 evaluator = new NB7_1_PP4();
        String line;
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("Enter a postfix expression to evaluate");
            line = in.nextLine();
            if(!line.equals("")){
                try {
                    int result = evaluator.eval(line);
                    System.out.println("Value is " + result);
                } catch (NB7_1_PP4.SyntaxErrorException ex) {
                    System.out.println("Syntax error " + ex.getMessage());
                }
            } else {
                break;
            }
        }
    }
}
