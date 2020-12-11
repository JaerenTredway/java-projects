public class StarPatterns {

    public static void main(String[] args) {
        printCenteredTriangle(20);
        System.out.println(makeStarLine(30, '-'));
    }

    private static String makeStarLine(int size, char c) {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += c;
        }
        return result;
    }

    private static void printCenteredTriangle(int size) {
        for (int i = 1; i < size; i += 2) {
            int numSpaces = size - i;
            int numStars = 2*i - 1;
            System.out.print(makeStarLine(numSpaces, ' '));
            System.out.println(makeStarLine(numStars, '*'));
        }
    }


}//EOF

