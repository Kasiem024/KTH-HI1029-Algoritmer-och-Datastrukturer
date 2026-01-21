package Uppgift3;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println("Före: " + list);

        Iterator<String> i = list.iterator();

        while (i.hasNext()) {
            System.out.println("Tar bort: " + i.next());
            i.remove();
            System.out.println("Kvar i listan: " + list);
        }
    }
}