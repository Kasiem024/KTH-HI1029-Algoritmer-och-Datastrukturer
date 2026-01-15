public class NB2Main {
    public static void main(String[] args) {

        IntList list = new IntList(3);

        list.add(0);
        list.set(0, 1);
        list.add(2);
        list.add(3);
        list.add(3,4);
        list.remove(1);

        System.out.println("indexOf 1 " + list.indexOf(1));
        System.out.println(list.get(0));

        System.out.println(list);
    }
}