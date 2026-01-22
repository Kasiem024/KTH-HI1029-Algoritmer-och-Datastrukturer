import java.util.Scanner;

public class NB14 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vilken poäng ska uppnås:");
        int goalPoints = scan.nextInt();
        System.out.println("Poängen kan nås med " + calcCost(goalPoints) + " kronor");
    }

    private static int calcCost(int goal) {
        if (goal < 1) return -1;

        return cost(1, goal);
    }

    private static int cost(int points, int goal) {
        if (points == goal) return 0;
        if (points > goal) return 100000;

        int cost10 = 10 + cost(points * 3, goal);
        int cost5 = 5 + cost(points + 4, goal);

        return Math.min(cost10, cost5);
    }
}
