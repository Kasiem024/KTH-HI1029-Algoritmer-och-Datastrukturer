public class NB13 {
    public static void main(String[] args) {
        double n = 36, a = 1, e = 0.00001;

        System.out.println(rot(n, a, e));
    }

    private static double rot(double n, double a, double e) {
        if (n < 1) throw new IllegalArgumentException();

        double condition = (a * a) - n;

        if (condition < 0) condition = condition * -1;
        if (condition < e) return a;

        return rot(n, ((a * a) + n) / (2 * a), e);
    }
}