package NB5;

public class Main {
    public static void main(String[] args) {

        StackImp<String> stack = new StackImp<>();

        stack.push("item1");
        stack.push("item2");
        stack.push("item3");

        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.peek());

        if (stack.empty()) System.out.println("Empty");
        else System.out.println("Not Empty");
    }
}
