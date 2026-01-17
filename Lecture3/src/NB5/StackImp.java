package NB5;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackImp<E> implements StackInt<E> {
    private final ArrayList<E> stackList;

    public StackImp() {
        stackList = new ArrayList<>();
    }

    @Override
    public E pop() {
        if (stackList.isEmpty()) throw new EmptyStackException();

        return stackList.removeLast();
    }

    @Override
    public E peek() {
        if (stackList.isEmpty()) throw new EmptyStackException();

        return stackList.getLast();
    }

    @Override
    public E push(E obj) {

        stackList.addLast(obj);

        return stackList.getLast();
    }

    @Override
    public boolean empty() {
        return stackList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < stackList.size(); i++) {
            sb.append(stackList.get(i));
            // Lägg till komma om det inte är sista elementet
            if (i < stackList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}