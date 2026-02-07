import java.util.LinkedList;
import java.util.Queue;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Uppgift6 {

    static String target = "ABCDE";

    static class State {
        String order;
        String path;

        public State(String order, String path) {
            this.order = order;
            this.path = path;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter package order (e.g., BECAD): ");
        String startOrder = scan.nextLine();

        solveWithBFS(startOrder);
    }

    public static void solveWithBFS(String start) {
        Queue<State> queue = new LinkedList<>();

        Set<String> visited = new HashSet<>();

        queue.add(new State(start, ""));

        visited.add(start);

        while (!queue.isEmpty()) {
            State current = queue.poll();

            if (current.order.equals(target)) {
                System.out.println("Shortest solution found: " + current.path);
                System.out.println("Number of steps: " + current.path.length());
                return; // Exit the method immediately
            }

            String moveB = current.order.charAt(1) + "" + current.order.charAt(0) + current.order.substring(2);

            if (!visited.contains(moveB)) {
                visited.add(moveB);
                queue.add(new State(moveB, current.path + "b"));
            }

            String moveS = current.order.charAt(4) + current.order.substring(0, 4);

            if (!visited.contains(moveS)) {
                visited.add(moveS);
                queue.add(new State(moveS, current.path + "s"));
            }
        }
        System.out.println("No solution found.");
    }
}