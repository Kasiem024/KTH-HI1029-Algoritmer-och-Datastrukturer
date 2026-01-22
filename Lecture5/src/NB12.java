public class NB12 {

    public static void main(String[] args) {
        int n = 5;
        int x = 5;

        System.out.println(exponentRecursive(x, n));
        System.out.println(exponentIterative(x, n));
    }

    private static int exponentIterative(int x, int n) {
        int temp = 1;

        for (int i = 1; i <= n; i++) {
            temp = x * temp;
        }

        return temp;
    }

    private static int exponentRecursive(int x, int n) {
        if (n == 0) return 1;

        return x * exponentRecursive(x, n - 1);
    }
}