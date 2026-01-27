public class NB15_1 {
private static int counter = 0;
    public static void main(String[] args) {
        int blue = 2;
        int white = 5;
        int red = 0;

        System.out.println(wrapper(blue, white, red));
        System.out.println(counter);
    }

    private static int wrapper(int blue, int white, int red) {
        return recursive(blue, white, red, 0);
    }

    public static int recursive(int blue, int white, int red, int nrSwitch) {
        counter++;
        if (blue == white && blue == red) return nrSwitch;
        if (nrSwitch > 15) return 10000;

        int switchBlue = 10000, switchWhite = 10000, switchRed = 10000;

        if (blue > 0) switchBlue = recursive(blue - 1, white + 1, red + 3, nrSwitch + 1);
        if (white > 0) switchWhite = recursive(blue + 2, white - 1, red + 4, nrSwitch + 1);
        if (red > 0) switchRed = recursive(blue + 1, white - 5, red - 1, nrSwitch + 1);

        return Math.min(Math.min(switchBlue, switchRed), switchWhite);
    }
}
