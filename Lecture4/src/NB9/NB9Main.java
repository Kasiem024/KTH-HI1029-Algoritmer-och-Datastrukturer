package NB9;

public class NB9Main {
    public static void main(String[] args) {
        NB9<String> test = new NB9();

        System.out.println(test.size());

        test.offer("kasiem1");
        System.out.println(test.size());
        test.offer("kasiem2");
        System.out.println(test.size());

        test.offer("kasiem3");
        System.out.println(test.size());
        test.offer("kasiem4");
        System.out.println(test.size());

        test.poll();
        System.out.println(test.size());

        System.out.println(test);
    }
}
