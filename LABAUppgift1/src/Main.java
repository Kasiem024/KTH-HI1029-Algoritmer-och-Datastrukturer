public class Main {
    public static void main(String[] args) {

        for (int amountTimes = 1; amountTimes < 41; amountTimes++) {
            long r = 0;
            for (int i = 1; i <= amountTimes; i++)
                for (int j = 1; j <= i; j++)
                    for (int k = j; k <= i + j; k++)
                        for (int m = 1; m <= i + j - k; m++)
                            r++;
            System.out.println(amountTimes + " " + r);
        }
    }
}