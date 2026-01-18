package NB8;

public class NB8Main {
    public static void main(String[] args) {
        ArrayQueue<String> nameQ = new ArrayQueue<String>(12);
        nameQ.offer("item1");
        nameQ.offer("item2");
        nameQ.offer("item3");
        nameQ.offer("item4");
        nameQ.offer("item5");
        nameQ.offer("item6");

        System.out.println(nameQ);

        nameQ.poll();
        System.out.println(nameQ);

        nameQ.poll();
        System.out.println(nameQ);

        nameQ.poll();
        System.out.println(nameQ);

        nameQ.poll();
        System.out.println(nameQ);
    }
}
