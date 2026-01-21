package NB8_1;

import NB8.ArrayQueue;

public class NB8_1Main {
    public static void main(String[] args) {
        ArrayQueueFixed<Integer> fixed = new ArrayQueueFixed<>(3);

        fixed.offer(1);
        fixed.offer(2);
        fixed.offer(3);
        System.out.println(fixed.poll());
        fixed.offer(4);
        fixed.offer(5);

        System.out.println(fixed);
        System.out.println(fixed.poll());
        System.out.println(fixed);
    }
}
