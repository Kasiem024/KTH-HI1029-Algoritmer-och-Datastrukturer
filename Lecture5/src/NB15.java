public class NB15 {
    public static void main(String[] args) {
        String binary = "1011";
        int num = 11;

        System.out.println(biToIntWrapper(binary));
        System.out.println(intToBiWrapper(num));
    }

    private static int biToIntWrapper(String binary) {
        if (binary.isBlank()) throw new IllegalArgumentException();

        return biToInt(binary, 0, 0);
    }

    private static int biToInt(String binary, int index, int currentNum) {
        if (index == binary.length()) return currentNum;

        int tempNum = binary.charAt(index) - '0';

        currentNum = currentNum * 2 + tempNum;

        return biToInt(binary, index + 1, currentNum);
    }

    private static String intToBiWrapper(int num) {
        if (num < 0) throw new IllegalArgumentException();

        String stringToReverse = intToBi(num, "");
        return new StringBuilder(stringToReverse).reverse().toString();
    }

    private static String intToBi(int num, String currentString) {

        char c = num % 2 == 1 ? '1' : '0';

        num = num / 2;

        currentString = currentString + c;

        if (num == 0) return currentString;

        return intToBi(num, currentString);
    }
}
