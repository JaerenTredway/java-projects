public class StarDemo {

    public static void main(String[] args) {

        System.out.print("Prints without newline... ");
        System.out.println("Prints with newline");

        printRightTriangle(5);
        printRightTriangle(7);

        printCenteredTriangle(4, '#');
        printCenteredTriangle(6);

    }

    private static void printCenteredTriangle(int size) {
        //     *
        //    ***
        //   *****
        //  *******
        printCenteredTriangle(size, '*');
    }

    private static void printCenteredTriangle(int size, char c) {
        for(int i = 0; i < size; i++) {
            int numSpaces = size - 1 - i;
            int numStars = 2*i + 1;
            System.out.print(makeCharLine(numSpaces, ' '));
            System.out.println(makeCharLine(numStars, c));
        }
    }

    private static void printRightTriangle(int size) {
        for (int i = 1; i <= size; i++) {
            printStarLine(i);
        }
    }

    private static void printStarLine(int numStars) {
//        for(int i = 0; i < numStars; i++) {
//            System.out.print("*");
//        }
//        System.out.println();
        String starLine = makeStarLine(numStars);
        System.out.println(starLine);
    }

    private static String makeStarLine(int numStars) {
//        String result = "";
//        for(int i = 0; i < numStars; ++i) {
//            result += "*";
//        }
//        return result;
        return makeCharLine(numStars, '*');
    }

    private static String makeCharLine(int size, char c) {
        String result = "";
        for(int i = 0; i < size; ++i) {
            result += c;
        }
        return result;
    }
}
