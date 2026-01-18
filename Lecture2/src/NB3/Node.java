package NB3;

public class Node {
    public String data;
    public Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return data;
    }
}
