public class Print2DArray {
    //sets rows and columns to be visible to other methods with "static"
    static int rows = 5;
    static int columns = 10;
    //creates an array of rows and columns
    static int[][] questionOneArray = new int[rows][columns];

    /**
     * main calls the method "arrayOfRandomNumbers"
     * to generate an array of random numbers.
     */
    public static void main (String[] args) {
        arrayOfRandomNumbers();
    }

    /**
     * method uses nested for loop to go through
     * each index of i and j to assign a random
     * number between 0-99.
     * It then prints the results.
     */
    static void arrayOfRandomNumbers() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                questionOneArray[i][j] = (int)(Math.random()*(10));
                System.out.print(questionOneArray[i][j]);
            }
            System.out.println("\n");
        }
    }
}