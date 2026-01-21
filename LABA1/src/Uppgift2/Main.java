package Uppgift2;

import java.security.spec.RSAOtherPrimeInfo;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList<String> list = new SingleLinkedList<>();

        list.add("Hej");
        list.add("på");
        list.add("dig");

        list.add(0, "Tja");

        System.out.println(list);

        System.out.println(list.remove(2));

        System.out.println(list.remove(2));

        System.out.println(list);
    }
}
