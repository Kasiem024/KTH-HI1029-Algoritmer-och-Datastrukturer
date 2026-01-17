package NB7;

import NB4.NB4;

public class NB7Main {
    public static void main(String[] args) {

        LinkedStack<String> linkedStack = new LinkedStack<>();

        linkedStack.push("item1");
        linkedStack.push("item2");
        linkedStack.push("item3");

        System.out.println(linkedStack.size());
        System.out.println(linkedStack.peek(1));
        System.out.println(linkedStack.flush());
        System.out.println(linkedStack.size());
    }
}
