package NB4;

public class NB4Main {
    public static void main(String[] args) {

        NB4 parChecker = new NB4();

        System.out.println(parChecker.isBalanced("(()()(()())((())))()"));
        System.out.println(parChecker.isBalanced("(((){}[])[]{()}){}"));
        System.out.println(parChecker.isBalanced("[{}([]{})]"));
        System.out.println(parChecker.isBalanced("({)}"));
        System.out.println(parChecker.isBalanced("())"));
        System.out.println(parChecker.isBalanced("{[]([(){]}}"));
        System.out.println(parChecker.isBalanced("[[]"));
    }
}