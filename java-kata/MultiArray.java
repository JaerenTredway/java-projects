/**
 *@version 1.0 2019-08-26
 *@author Jaeren Tredway
*/
public class Main {
    /**
    * This program builds a multi-dimensional array and prints it.
    * @param args Command line arguments are ignored
    */
    public static void main(String[] args) {
        int i, j, k = 0;
        int myArray[][] = new int[4][4];

        for (i=0; i<myArray.length; i++) {
            for (j=0; j<myArray[i].length; j++) {
                myArray[i][j] = k;
                k++;
            }
        }

		System.out.println(); //spacer

		for (i=0; i<myArray.length; i++) {
            for (j=0; j<myArray[i].length; j++) {
                System.out.print(myArray[i][j]);
				if (myArray[i][j] < 10) {
					System.out.print("  ");
				} else {
					System.out.print(" ");
				}
            }
			System.out.println(); //carraige return
        }
    }
}