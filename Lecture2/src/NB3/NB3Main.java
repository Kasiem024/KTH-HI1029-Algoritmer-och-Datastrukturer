package NB3;

public class NB3Main {
    public static void main(String[] args) {

        Node a = new Node("Gilgamesh");
        Node b = new Node("löper");
        Node c = new Node("på");
        Node d = new Node("stäppen");

        Node e = new Node("1111Gilgamesh");
        Node f = new Node("1111löper");
        Node g = new Node("1111på");
        Node h = new Node("1111stäppen");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        g.next = h;
        h.next = null;

        b.next = d;
        Node start = a;

        while (start != null) {
            System.out.println(start);
            start = start.next;
        }

        start = a;
        d.next = null;

        while (start != null) {
            System.out.println(start);
            start = start.next;
        }
    }
}
