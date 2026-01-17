package NB7;

    public interface StackInt<E> {
        E pop();
        E peek();
        E push(E obj);
        boolean empty();
}
