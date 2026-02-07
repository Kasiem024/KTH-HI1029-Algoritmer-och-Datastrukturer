import java.util.Scanner;

public class Uppgift5 {

    static String target = "ABCDE";
    static String bestSolution = null;
    static int maxDepth = 15;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter package order (e.g., BECAD): ");
        String start = scan.nextLine();

        findSolution(start, "", 0);

        if (bestSolution != null) {
            System.out.println("Shortest solution was: " + bestSolution);
            System.out.println("Number of steps: " + bestSolution.length());
        } else {
            System.out.println("No solution found within max depth.");
        }
    }

    public static void findSolution(String current, String path, int depth) {

        if (current.equals(target)) {
            if (bestSolution == null || path.length() < bestSolution.length()) {
                bestSolution = path;
            }
            return;
        }

        if (depth >= maxDepth || (bestSolution != null && depth >= bestSolution.length())) {
            return;
        }

        String moveB = current.charAt(1) + "" + current.charAt(0) + current.substring(2);

        findSolution(moveB, path + "b", depth + 1);

        String moveS = current.charAt(4) + current.substring(0, 4);

        findSolution(moveS, path + "s", depth + 1);
    }
}