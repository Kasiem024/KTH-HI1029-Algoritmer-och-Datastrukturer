package NB10;

public class NB10Main {
    public static void main(String[] args) {

        NB10<Integer> NB10 = new NB10<Integer>();

        NB10.offerLast(1);
        NB10.offerLast(2);
        NB10.offerFirst(3);
        System.out.println(NB10);

        System.out.println(NB10.pollFirst());
        System.out.println(NB10.pollLast());
        System.out.println(NB10);

        NB10.pollFirst();
        System.out.println(NB10.pollFirst());
        System.out.println(NB10.empty());
    }
}
